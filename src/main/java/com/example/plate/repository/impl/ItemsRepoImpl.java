package com.example.plate.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.plate.entity.Items;
@Repository
public interface ItemsRepoImpl extends JpaRepository<Items, Integer>  
{
	/*
	 * @Query("select u from User u where u.userName=:userName") User
	 * findByUser(String userName);
	 * 
	 * @Query("select count(u) from User u where u.userName=:userName and u.passcode=:passcode"
	 * ) Integer authenticateUser(String userName,String passcode);
	 */
}  