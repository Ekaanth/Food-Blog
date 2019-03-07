package com.foodblog.sa.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.foodblog.sa.domain.ArticleModel;
import com.foodblog.sa.tmodel.TArticle;
import com.foodblog.sa.tmodel.TCategoryCount;

public interface ArticleService {

	public ArticleModel findArticleById(Long id);
	
	public ArticleModel addArticle(ArticleModel article);
	
	public Long publishArticle(TArticle article);

	public Long draftArticle(TArticle visitDetails);

	public TArticle getArticleById(Long id);

	public void addArticleImage(MultipartFile files, Long id);

	public TArticle getActiveTArticleById(Long id);

	public ArrayList<ArticleModel> getLatestFiveArticles();

	public ArticleModel getActiveArticleById(Long id);

	public Collection<TArticle> getAllActiveArticles() throws JsonProcessingException;

	public Collection<TCategoryCount> getRandomCategoryCount();
	
}
