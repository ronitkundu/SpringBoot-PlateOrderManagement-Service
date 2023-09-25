package com.example.plate.restcontroller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.plate.entity.CartDetails;
import com.example.plate.entity.User;
import com.example.plate.service.impl.CartItemsServiceImpl;
import com.example.plate.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value="/plate")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRestController {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	CartItemsServiceImpl cartService;
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<Object> authenticateUser(@RequestBody User user,@RequestHeader(value="X-Auth",required=true)String authToken) throws URISyntaxException, MalformedURLException{
			Decoder decoder=Base64.getDecoder();
			Integer currentUserAuthentic=userService.authenticateUser(user,new String(decoder.decode(authToken)));
			if(currentUserAuthentic==1) {
				return new ResponseEntity<Object>(currentUserAuthentic,HttpStatus.OK);
			}
			return new ResponseEntity<Object>(currentUserAuthentic,HttpStatus.UNAUTHORIZED);

		}
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ResponseEntity<Object> registerUser(@RequestBody User user,@RequestHeader(value="X-Auth",required=true)String authToken) throws URISyntaxException, MalformedURLException{
			String uploadMessage=userService.save(user,authToken);
			if(uploadMessage=="User Registered Successfully") {
				return new ResponseEntity<Object>(uploadMessage,HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(uploadMessage,HttpStatus.INTERNAL_SERVER_ERROR);

			}

		}
	@RequestMapping(value="/updateUser",method=RequestMethod.PUT)
	public ResponseEntity<Object> UpdateUser(@RequestBody User user) throws URISyntaxException, MalformedURLException{
			String uploadMessage=userService.update(user);
			if(uploadMessage.equalsIgnoreCase("Details Updated Successfully")) {
				return new ResponseEntity<Object>(uploadMessage,HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(uploadMessage,HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	@RequestMapping(value="/deleteUser",method=RequestMethod.PUT)
	public ResponseEntity<Object> deleteUser(@RequestBody User user) throws URISyntaxException, MalformedURLException{
			String uploadMessage=userService.delete(user);
			if(uploadMessage.equalsIgnoreCase("User Deleted Successfully")) {
				return new ResponseEntity<Object>(uploadMessage,HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(uploadMessage,HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}
	
	@RequestMapping(value = "/addToCart/{userID}", method = RequestMethod.POST)
	public ResponseEntity<String> addAllItemsToCart(@PathVariable (value = "userID") int userId,@RequestBody List<CartDetails> itemsSelected) {
		if(!userService.existsById(userId)) {
            throw new RuntimeException("User ID " + userId + " not found");
        }
		else {
			cartService.saveAllcartOrders(itemsSelected, userId);
			return new ResponseEntity<String>("Items added successfully", HttpStatus.OK);
		}

	}
	@RequestMapping(value = "/getCartDetailsForUser/{userID}", method = RequestMethod.GET)
	public ResponseEntity<List<CartDetails>> getCartDetailsForUser(@PathVariable (value = "userID") int userId) {
		
		if(!userService.existsById(userId)) {
            throw new RuntimeException("User ID " + userId + " not found");
        }
		else {
			List<CartDetails> cart=cartService.fetchAllOrderedItemsForUserID(userId);
			return new ResponseEntity<List<CartDetails>>(cart, HttpStatus.OK);
		}

	}
}
