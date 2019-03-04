package com.foodblog.sa.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodblog.sa.domain.ArticleQuoteModel;

@Repository
public interface ArticleQuoteRepo extends JpaRepository<ArticleQuoteModel, Long> {

	public ArticleQuoteModel findByArticleid(Long id);
}
