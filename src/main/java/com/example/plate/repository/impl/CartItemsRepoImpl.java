package com.example.plate.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.plate.entity.CartDetails;
import com.example.plate.entity.User;
@Repository
public interface CartItemsRepoImpl extends JpaRepository<CartDetails, Integer>  
{
	@Query("select u from CartDetails u where u.user=:u")
	List<CartDetails> findByUser(User u); 
	
	
	/*
	 * @Query("select u from User u where u.userName=:userName") User
	 * findByUser(String userName);
	 * 
	 * @Query("select count(u) from User u where u.userName=:userName and u.passcode=:passcode"
	 * ) Integer authenticateUser(String userName,String passcode);
	 */
}  