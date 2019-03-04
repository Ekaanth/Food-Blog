package com.foodblog.sa.jparepo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodblog.sa.domain.ArticleTagsModel;

@Repository
public interface ArticleTagsRepo extends JpaRepository<ArticleTagsModel, Long>{

	public ArrayList<ArticleTagsModel> findByArticleid(Long id);
}
