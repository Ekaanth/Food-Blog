package com.foodblog.sa.web.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodblog.sa.domain.SiteVisitModel;
import com.foodblog.sa.domain.UserModel;
import com.foodblog.sa.service.UserService;

@RestController
@RequestMapping(value = "/UserController/api/")
public class UserController {

	
	@Autowired
	private UserService userservice;
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SiteVisitModel> addToSiteLog(@RequestBody UserModel userdetails) throws IOException {
		if(userdetails.getName().equalsIgnoreCase("payal")) {
			if(userdetails.getPassword().equals("p@yal")) {
				return new ResponseEntity<SiteVisitModel>(
		                HttpStatus.OK); 
			}else{
				return new ResponseEntity<SiteVisitModel>(
		                HttpStatus.FORBIDDEN);
			}
			
		} else {
			return new ResponseEntity<SiteVisitModel>(
	                HttpStatus.FORBIDDEN);
		}
	}
}
