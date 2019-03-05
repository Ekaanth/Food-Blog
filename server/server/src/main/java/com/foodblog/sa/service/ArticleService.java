package com.foodblog.sa.service;

import org.springframework.web.multipart.MultipartFile;

import com.foodblog.sa.domain.ArticleModel;
import com.foodblog.sa.tmodel.TArticle;

public interface ArticleService {

	public ArticleModel findArticleById(Long id);
	
	public ArticleModel addArticle(ArticleModel article);
	
	public Long publishArticle(TArticle article);

	public Long draftArticle(TArticle visitDetails);

	public TArticle getArticleById(Long id);

	public void addArticleImage(MultipartFile files, Long id);
	
}
