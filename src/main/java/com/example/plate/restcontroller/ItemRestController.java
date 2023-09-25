package com.example.plate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.plate.entity.Items;
import com.example.plate.service.impl.ItemsServiceImpl;

@RestController
@RequestMapping(value = "/plate")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemRestController {

	@Autowired
	ItemsServiceImpl itemService;

	@RequestMapping(value = "/fetchAllItems", method = RequestMethod.GET)
	public ResponseEntity<List<Items>> fetchAllItems() {
		List<Items> allItems = itemService.fetchAllItems();
		return new ResponseEntity<List<Items>>(allItems, HttpStatus.OK);

	}
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ResponseEntity<String> addItem(@RequestBody Items itemSelected) {
		int itemId = itemService.saveItem(itemSelected);
		return new ResponseEntity<String>("Item Added Successfully with ID:"+itemId, HttpStatus.OK);

	}
	
	
}
