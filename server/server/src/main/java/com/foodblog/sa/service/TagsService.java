package com.foodblog.sa.service;

import java.util.Collection;

import com.foodblog.sa.domain.TagsModel;

public interface TagsService {

	public Collection<TagsModel> findAll();
}
