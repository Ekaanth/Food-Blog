package com.foodblog.sa.service;

import java.util.ArrayList;

import com.foodblog.sa.domain.ArticleTagsModel;

public interface ArticleTagsService {

	public ArticleTagsModel save(ArticleTagsModel article);
	
	public ArrayList<ArticleTagsModel> findAllTagsById(Long articleid);
}
