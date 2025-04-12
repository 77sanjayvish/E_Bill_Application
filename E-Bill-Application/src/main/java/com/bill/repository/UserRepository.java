package com.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bill.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String mail);

}
