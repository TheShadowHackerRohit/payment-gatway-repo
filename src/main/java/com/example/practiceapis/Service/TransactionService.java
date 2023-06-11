package com.example.practiceapis.Service;

import com.example.practiceapis.Enum.Status;
import com.example.practiceapis.Model.Refund;
import com.example.practiceapis.Model.Transaction;
import com.example.practiceapis.Model.User;
import com.example.practiceapis.Repository.TransactionRepository;
import com.example.practiceapis.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    public String doTransaction(int userId, int amount, Status status) {
        Transaction transaction = new Transaction();

        User user = userRepository.findById(userId).get();

        transaction.setUser(user);
        transaction.setTime(new Date());
        transaction.setStatus(status);
        if(status.equals(Status.SUCCESS)){
            transaction.setAmount(amount);
            transaction.setAmountDeducted(0);
        }else {
            transaction.setAmountDeducted(amount);
            transaction.setAmount(0);
        }
        transaction.setStatus(status);

        Transaction savedTransaction = transactionRepository.save(transaction);

        user.getTransactionList().add(savedTransaction);

        Refund refund = new Refund();
        refund.setAmount(savedTransaction.getAmountDeducted());
        refund.setTransaction(savedTransaction);
        refund.setUser(user);

        user.getRefundList().add(refund);

        savedTransaction.setRefund(refund);


        return "transaction saved successfully with id: "+ savedTransaction.getTransactionId();


    }

    public int findAmountSuccessTransaction(int userId) {

        int totalAmount = 0;

        User user = userRepository.findById(userId).get();
        List<Transaction> transactionList = user.getTransactionList();

        for (Transaction transaction : transactionList){
            if (transaction.getStatus().equals(Status.SUCCESS)){
                totalAmount += transaction.getAmount();
            }
        }
        return totalAmount;
    }

    public String deleteFailedTransaction() {

        List<Transaction> transactionList = transactionRepository.findAll();
        List<Transaction> dummyList = new ArrayList<>();
        for (Transaction transaction : transactionList){
            if (transaction.getStatus().equals(Status.FAILED)){
                dummyList.add(transaction);
            }
        }

        for (Transaction transaction : dummyList){
            transactionList.remove(transaction);
        }
        return "delete all failed Transaction";
    }
}
