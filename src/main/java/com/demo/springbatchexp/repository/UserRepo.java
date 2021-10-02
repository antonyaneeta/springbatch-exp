package com.demo.springbatchexp.repository;

import com.demo.springbatchexp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {


}
