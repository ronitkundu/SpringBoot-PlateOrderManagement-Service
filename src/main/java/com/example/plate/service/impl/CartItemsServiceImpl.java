package com.example.plate.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plate.entity.CartDetails;
import com.example.plate.entity.User;
import com.example.plate.repository.impl.CartItemsRepoImpl;
import com.example.plate.repository.impl.UserRepoImpl;

@Service
public class CartItemsServiceImpl {

	@Autowired
	CartItemsRepoImpl cartItemsRepo;
	@Autowired
	UserRepoImpl userRepo;
	
	public List<CartDetails> fetchAllOrderedItemsForUserID(int userID) {
		Optional<User> user=userRepo.findById(userID);
		if(user != null) {
			User u=user.get();
			return cartItemsRepo.findByUser(u);
		}
		return null;
	}
		
	public int saveAllcartOrders(List<CartDetails> cartOrders, int userID) {
		Optional<User> user=userRepo.findById(userID);
		if(user != null) {
			User u=user.get();
			cartOrders.forEach(o -> {
				o.setUser(u);
			});
		}
		System.out.println(cartOrders);
		return cartItemsRepo.saveAll(cartOrders).size();
	}
	
	/*public Integer authenticateUser(User user, String authToken) {
		Decoder decoder = Base64.getDecoder();
		Integer currentUserAuthentic = userRepo.authenticateUser(user.getUserName(),
				new String(decoder.decode(authToken)));
		return currentUserAuthentic;
	}

	public String save(User user, String authToken) {

		Decoder decoder = Base64.getDecoder();
		user.setPasscode(new String(decoder.decode(authToken)));
		String uploadMessage = validate(user,"Add");
		if (uploadMessage == null) {
			User currentUserSaved = userRepo.save(user);
			uploadMessage = "User Registered Successfully";
		}
		return uploadMessage;
	}
	public String update(User user) {

		String uploadMessage = validate(user,"update");
		if (uploadMessage == null) {
			User currentUserSaved = userRepo.findByUser(user.getUserName());
			currentUserSaved.setAdress(user.getAdress());
			System.out.println("aaaaaaa"+currentUserSaved.toString());
					userRepo.save(currentUserSaved);
			uploadMessage = "User Details Updated Successfully";
		}
		return uploadMessage;
	}
	public String delete(User user) {
		String uploadMessage = validate(user,"delete");
		if (uploadMessage == null) {
			 userRepo.delete(user);
			uploadMessage = "User Deleted Successfully";
		}
		return uploadMessage;
	}
	public String validate(User user,String operation) {
		String message = null;
		if(operation.equalsIgnoreCase("Add")) {
			if (userRepo.findByUser(user.getUserName()) != null) {
				message = "User Already Exists";
			}
		}
		if(operation.equalsIgnoreCase("update")||operation.equalsIgnoreCase("delete")) {
			if (userRepo.findByUser(user.getUserName()) == null) {
				message = "User Doesn't Exists";
			}
		}
		
		return message;
	}*/

}
