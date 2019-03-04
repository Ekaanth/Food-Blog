package com.foodblog.sa.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodblog.sa.domain.TagsModel;

@Repository
public interface TagsRepo extends JpaRepository<TagsModel, Long> {

	public TagsModel findByTagname(String tag);
}
