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
import com.foodblog.sa.tmodel.TCategoryCount;

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
	
//	SELECT a.articlemaintag, count(*) FROM stonehead.article a 
//	GROUP BY a.articlemaintag;
	
	@RequestMapping(value = "/getLatestFiveArticles", method = RequestMethod.GET)
	public ResponseEntity<List<ArticleModel>> getLatestFiveArticles() throws IOException {
		List<ArticleModel> latestFiveList = articleService.getLatestFiveArticles();
		return new ResponseEntity<List<ArticleModel>>(latestFiveList,
                HttpStatus.OK);
	}
	
	
//	NOT WORKING 
	
	@RequestMapping(value = "/getAllActiveArticles", method = RequestMethod.GET)
	public ResponseEntity<Collection<TArticle>> getAllActiveArticles() throws IOException {
		try {
			Collection<TArticle> latestFiveList = articleService.getAllActiveArticles();
			return new ResponseEntity<Collection<TArticle>>(latestFiveList,
	                HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Collection<TArticle>>(
	                HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getRandomCategoryCount", method = RequestMethod.GET)
	public ResponseEntity<Collection<TCategoryCount>> getRandomCategoryCount() throws IOException {
		try {
			Collection<TCategoryCount> tagsCount = articleService.getRandomCategoryCount();
			return new ResponseEntity<Collection<TCategoryCount>>(tagsCount,
	                HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Collection<TCategoryCount>>(
	                HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
