package com.example.practiceapis.Repository;

import com.example.practiceapis.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}
