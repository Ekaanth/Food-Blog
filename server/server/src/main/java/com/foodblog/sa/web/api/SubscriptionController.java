package com.foodblog.sa.web.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodblog.sa.service.SubscriptionService;

@RestController
@RequestMapping(value = "/SubscriptionController/api/")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionServeice;
	
	@RequestMapping(value = "/subscribe/{email}", method = RequestMethod.GET)
	public ResponseEntity<String> subscribe(@PathVariable("email") String email) throws IOException {
		try {
			subscriptionServeice.subscribeNewUser(email);
			return new ResponseEntity<String>(
	                HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(
	                HttpStatus.BAD_REQUEST);
		}
	
	}
}
