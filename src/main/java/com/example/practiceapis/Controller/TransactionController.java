package com.example.practiceapis.Controller;


import com.example.practiceapis.Enum.Status;
import com.example.practiceapis.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/do-transaction")
    public ResponseEntity doTransaction(@RequestParam int userId, @RequestParam int amount ,@RequestParam Status status ){

        String response = transactionService.doTransaction(userId,amount,status);

        return  new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/find-amount-all-successfull-transaction-of-a-user")
    public ResponseEntity findAmountSuccessTransaction(@RequestParam int userId){
        int totalAmount = transactionService.findAmountSuccessTransaction(userId);

        return new ResponseEntity<>(totalAmount,HttpStatus.OK);

    }

    @DeleteMapping("/delete-all-failed-transaction")
    public ResponseEntity deleteTransaction(){
        String response = transactionService.deleteFailedTransaction();

        return  new ResponseEntity(response,HttpStatus.OK);
    }

}



/*

Create a payment gateway:
User = UserId, Name, Email, AccountNumber, List<Transaction>
Transaction = TransactionId, UserId, Amount, Status, AmountDeducted, Time
Refund = Amount, UserId,  TransactionId

Description: A user can do multiple transactions.
 A transaction can be successful or a failure.
 Money can be deducted in case of a failed transaction as well.


POST API - Add a User
POST API - Add a Transaction for a given amount

1. GET API - Find the total amount of successful transactions for a user
2. DELETE API - Delete all transactions that are failed
3. GET API - Return UserId with maximum refund amount
 */