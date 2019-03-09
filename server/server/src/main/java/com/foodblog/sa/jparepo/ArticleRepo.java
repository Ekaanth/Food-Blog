package com.foodblog.sa.jparepo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.foodblog.sa.domain.ArticleModel;

@Repository
public interface ArticleRepo extends JpaRepository<ArticleModel, Long>, PagingAndSortingRepository<ArticleModel, Long> {

	public ArticleModel findById(long id);
}
