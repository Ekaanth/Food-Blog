package com.foodblog.sa.serviceImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodblog.sa.domain.ArticleTagsModel;
import com.foodblog.sa.jparepo.ArticleTagsRepo;
import com.foodblog.sa.service.ArticleTagsService;

@Service
public class ArticleTagsServiceImp implements ArticleTagsService{

	
	@Autowired
	ArticleTagsRepo articleTagsRepo;
	
	@Override
	public ArticleTagsModel save(ArticleTagsModel at) {
		return articleTagsRepo.save(at);
	}

	@Override
	public ArrayList<ArticleTagsModel> findAllTagsById(Long articleid) {
		return articleTagsRepo.findByArticleid(articleid);
	}

	

	
	
}
