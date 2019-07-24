package com.foodblog.sa.jparepo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foodblog.sa.domain.ArticleTagsModel;

@Repository
public interface ArticleTagsRepo extends JpaRepository<ArticleTagsModel, Long>{


	public ArrayList<ArticleTagsModel> findByArticleid(Long id);

	@Query(value="SELECT Distinct u.articleid FROM articletaglist u where u.tagid= :uid" , nativeQuery=true)
	public ArrayList<Long> findByArticleListBytagid(Long id);
	
	@Query(value="select COUNT(*) FROM articletaglist u WHERE u.tagid= :uid" , nativeQuery=true)
	public Long countBytagid(@Param("uid") Long name);
}
