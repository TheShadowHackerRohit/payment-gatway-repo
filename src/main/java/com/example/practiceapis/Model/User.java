package com.example.practiceapis.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String name;

    String emailId;

    String accountNumber;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Refund> refundList = new ArrayList<>();


}
/*

Create a payment gateway:
User = UserId, Name, Email, AccountNumber, List<Transaction>
Transaction = TransactionId, UserId, Amount, Status, AmountDeducted, Time
Refund = Amount, UserId,  TransactionId

Description: A user can do multiple transactions.
 A transaction can be successful or a failure.
 Money can be deducted in case of a failed transaction as well.
 */