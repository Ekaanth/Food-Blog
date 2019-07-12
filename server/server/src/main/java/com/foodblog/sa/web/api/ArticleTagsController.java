package com.foodblog.sa.web.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodblog.sa.domain.ArticleModel;
import com.foodblog.sa.domain.SiteVisitModel;
import com.foodblog.sa.domain.UserModel;
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
	
	@RequestMapping(value = "/getPopularTags", method = RequestMethod.GET)
	public ResponseEntity<Collection<TCategoryCount>> getPopularTags() throws IOException {
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
	

	@RequestMapping(value = "/populateTagsLog", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> populateTagsLog(@RequestBody UserModel userdetails) throws IOException {
		try {
//			articleService.populatTagsLog(id);
			return new ResponseEntity<String>("OK",
	                HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>(
	                HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/findAllActiveArticlesPageination", method = RequestMethod.GET)
	public ResponseEntity<Page<ArticleModel>> findAllActiveArticlesPageination() throws IOException {
		try {
			Page<ArticleModel> allActiveArticle = articleService.findAllActiveArticlesPageination();
			return new ResponseEntity<Page<ArticleModel>>(allActiveArticle,
	                HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Page<ArticleModel>>(
	                HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/findAllActiveArticlesByTag/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ArticleModel>> findAllActiveArticlesByTag(@PathVariable("id") Long id) throws IOException {
		try {
			List<ArticleModel> allActiveArticle = articleService.findAllActiveArticlesByTag(id);
			return new ResponseEntity<List<ArticleModel>>(allActiveArticle,
	                HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<List<ArticleModel>>(
	                HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/findAllActiveArticleByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Page<TArticle>> findAllActiveArticleByName(@PathVariable("name") String name) throws IOException {
		try {
			Page<TArticle> allActiveArticle = articleService.findAllActiveArticleByName(name);
			return new ResponseEntity<Page<TArticle>>(allActiveArticle,
	                HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Page<TArticle>>(
	                HttpStatus.BAD_REQUEST);
		}
	}
	
}
