package com.foodblog.sa.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodblog.sa.domain.ArticleQuoteModel;
import com.foodblog.sa.jparepo.ArticleQuoteRepo;
import com.foodblog.sa.service.ArticleQuoteService;

@Service
public class ArticleQuoteServiceImp implements ArticleQuoteService {

	@Autowired
	ArticleQuoteRepo articleQuoteRepo;
	
	@Override
	public ArticleQuoteModel save(ArticleQuoteModel quote) {
		return articleQuoteRepo.save(quote);
	}

	@Override
	public ArticleQuoteModel findByArticleId(Long id) {
		return articleQuoteRepo.findByArticleid(id);
	}

}
