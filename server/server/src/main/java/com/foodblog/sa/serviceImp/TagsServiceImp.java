package com.foodblog.sa.serviceImp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodblog.sa.domain.TagsModel;
import com.foodblog.sa.jparepo.TagsRepo;
import com.foodblog.sa.service.TagsService;

@Service
public class TagsServiceImp implements TagsService{

	@Autowired
	TagsRepo tagsRepo;
	
	@Override
	public Collection<TagsModel> findAll() {
		return tagsRepo.findAll();
	}

}
