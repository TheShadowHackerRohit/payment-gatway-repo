package com.example.practiceapis.Repository;

import com.example.practiceapis.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
