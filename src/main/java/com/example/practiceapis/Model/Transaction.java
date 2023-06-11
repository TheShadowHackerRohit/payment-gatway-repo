package com.example.practiceapis.Model;


import com.example.practiceapis.Enum.Status;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int transactionId;

    int amount;

    @Enumerated(EnumType.STRING)
    Status status;

    int amountDeducted;

    @Timestamp
    Date time;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToOne(mappedBy = "transaction",cascade = CascadeType.ALL)
    Refund refund;



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