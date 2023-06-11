package com.example.practiceapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApisApplication.class, args);
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