package com.foodblog.sa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article", schema = "stonehead")
public class ArticleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String articleheading;
	private String articleby;
	private String artcleimage;
	private String articlemaintag;
	private String articlefirst;
	private String articlesecond;
	private String articletimestamp;
	
	public String getArticletimestamp() {
		return articletimestamp;
	}
	public void setArticletimestamp(String articletimestamp) {
		this.articletimestamp = articletimestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArticleheading() {
		return articleheading;
	}
	public void setArticleheading(String articleheading) {
		this.articleheading = articleheading; 
	}
	public String getArticleby() {
		return articleby;
	}
	public void setArticleby(String articleby) {
		this.articleby = articleby;
	}
	public String getArtcleimage() {
		return artcleimage;
	}
	public void setArtcleimage(String artcleimage) {
		this.artcleimage = artcleimage;
	}
	public String getArticlemaintag() {
		return articlemaintag;
	}
	public void setArticlemaintag(String articlemaintag) {
		this.articlemaintag = articlemaintag;
	}
	public String getArticlefirst() {
		return articlefirst;
	}
	public void setArticlefirst(String articlefirst) {
		this.articlefirst = articlefirst;
	}
	public String getArticlesecond() {
		return articlesecond;
	}
	public void setArticlesecond(String articlesecond) {
		this.articlesecond = articlesecond;
	}

}
