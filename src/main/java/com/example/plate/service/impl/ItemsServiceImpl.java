package com.example.plate.service.impl;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plate.entity.Items;
import com.example.plate.entity.User;
import com.example.plate.repository.impl.ItemsRepoImpl;

@Service
public class ItemsServiceImpl {

	@Autowired
	ItemsRepoImpl itemsRepo;

	public List<Items> fetchAllItems() {
			return itemsRepo.findAll();
	}
	public int saveItem(Items item) {
		return itemsRepo.save(item).getId();
	}
	
	public int saveAllItems(List<Items> items) {
		return itemsRepo.saveAll(items).size();
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
