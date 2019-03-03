package com.foodblog.sa.web.api;

import java.io.IOException;
import java.util.Collection;

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
import com.foodblog.sa.service.SiteVisitService;
import com.foodblog.sa.service.UserService;

@RestController
@RequestMapping(value = "/ClientController/api/")
public class ClientController {

	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private SiteVisitService siteVisitService;
	
	
	@RequestMapping(value = "/visitlog", method = RequestMethod.GET)
	public ResponseEntity<Collection<SiteVisitModel>> visitlog() throws IOException {
		Collection<SiteVisitModel> visitlog = siteVisitService.findAll();
		return new ResponseEntity<Collection<SiteVisitModel>>(visitlog,
                HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addToSiteLog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SiteVisitModel> addToSiteLog(@RequestBody SiteVisitModel visitDetails) throws IOException {
		siteVisitService.addToSiteLog(visitDetails);
		return new ResponseEntity<SiteVisitModel>(
                HttpStatus.CREATED);
	}

}
