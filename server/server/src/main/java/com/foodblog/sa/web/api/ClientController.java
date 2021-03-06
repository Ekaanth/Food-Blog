package com.foodblog.sa.web.api;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foodblog.sa.domain.SiteVisitModel;
import com.foodblog.sa.domain.TagsModel;
import com.foodblog.sa.service.ArticleService;
import com.foodblog.sa.service.SiteVisitService;
import com.foodblog.sa.service.TagsService;
import com.foodblog.sa.tmodel.TArticle;

@RestController
@RequestMapping(value = "/ClientController/api/")
public class ClientController {
	
	@Autowired
	private SiteVisitService siteVisitService;
	
	@Autowired
	private TagsService tagsService;
	
	@Autowired
	ArticleService articleService;
	
	
	@RequestMapping(value = "/visitlog", method = RequestMethod.GET)
	public ResponseEntity<Collection<SiteVisitModel>> visitlog() throws IOException {
		Collection<SiteVisitModel> visitlog = siteVisitService.findAll();
		return new ResponseEntity<Collection<SiteVisitModel>>(visitlog,
                HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addToSiteLog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SiteVisitModel> addToSiteLog(@RequestBody SiteVisitModel visitDetails) throws IOException {
		SiteVisitModel model = siteVisitService.addToSiteLog(visitDetails);
		return new ResponseEntity<SiteVisitModel>(model,
                HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getAllTags", method = RequestMethod.GET)
	public ResponseEntity<Collection<TagsModel>> getAllTags() throws IOException {
		Collection<TagsModel> visitlog = tagsService.findAll();
		return new ResponseEntity<Collection<TagsModel>>(visitlog,
                HttpStatus.OK);
	}
	
	@RequestMapping(value = "/publishArticle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> publishArticle(@RequestBody TArticle visitDetails) throws IOException {
		Long draftArticle = articleService.publishArticle(visitDetails);
		System.out.println(draftArticle);
		return new ResponseEntity<String>(draftArticle.toString(),
                HttpStatus.OK);
	}
	
	@RequestMapping(value = "/draftArticle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> draftArticle(@RequestBody TArticle visitDetails) throws IOException {
		Long draftArticle = articleService.draftArticle(visitDetails);
		return new ResponseEntity<String>(draftArticle.toString(),
                HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getArticleById/{id}", method = RequestMethod.GET)
	public ResponseEntity<TArticle> getArticleById(@PathVariable("id") Long id) throws IOException {
		TArticle article  = articleService.getActiveTArticleById(id);
		return new ResponseEntity<TArticle>(article,
                HttpStatus.OK);
	}
	
	@RequestMapping(
	        value = ("/uploadArticleImage"),
	        method = RequestMethod.POST,
	        headers = "content-type=multipart/form-data")
	public ResponseEntity<String> uploadArticleImage(@RequestParam("file") MultipartFile files, @RequestParam("id") Long id)throws Exception
	{
		articleService.addArticleImage(files , id);
		return new ResponseEntity<String>("OK",
                HttpStatus.OK);
	}
	
	

}
