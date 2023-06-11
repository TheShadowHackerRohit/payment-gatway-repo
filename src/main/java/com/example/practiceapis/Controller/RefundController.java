package com.example.practiceapis.Controller;


import com.example.practiceapis.Model.Refund;
import com.example.practiceapis.Service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refund")
public class RefundController {

    @Autowired
    RefundService refundService;

    @GetMapping("/maximum-refund")
    public ResponseEntity getMaximumRefund(){
        int userId = refundService.getMaximumRefund();
        return  new ResponseEntity<>(userId, HttpStatus.OK);
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
