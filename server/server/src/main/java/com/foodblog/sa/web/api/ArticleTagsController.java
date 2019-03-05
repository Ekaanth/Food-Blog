package com.foodblog.sa.web.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodblog.sa.domain.ArticleModel;
import com.foodblog.sa.domain.SiteVisitModel;
import com.foodblog.sa.service.ArticleService;
import com.foodblog.sa.tmodel.TArticle;

@RestController
@RequestMapping(value = "/ArticleTagsController/api/")
public class ArticleTagsController {

	
	@Autowired
	ArticleService articleService;
	
//	@RequestMapping(value = "/getTopFiveArticles", method = RequestMethod.GET)
//	public ResponseEntity<Collection<TArticle>> getTopFiveArticles() throws IOException {
//		Collection<SiteVisitModel> visitlog = 
//		return new ResponseEntity<Collection<TArticle>>(visitlog,
//                HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/getLatestFiveArticles", method = RequestMethod.GET)
	public ResponseEntity<List<ArticleModel>> getLatestFiveArticles() throws IOException {
		List<ArticleModel> latestFiveList = articleService.getLatestFiveArticles();
		return new ResponseEntity<List<ArticleModel>>(latestFiveList,
                HttpStatus.OK);
	}
}
