package com.foodblog.sa.service;

import com.foodblog.sa.domain.ArticleQuoteModel;

public interface ArticleQuoteService {

	public ArticleQuoteModel save(ArticleQuoteModel quote);
	
	public ArticleQuoteModel findByArticleId(Long id);
	
	
}
