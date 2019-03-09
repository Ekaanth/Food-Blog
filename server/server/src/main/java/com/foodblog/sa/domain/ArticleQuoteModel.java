package com.foodblog.sa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articlequote", schema = "stonehead")
public class ArticleQuoteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long articleid;
	private String quotetext;
	private String quoteauthor;
	private String timestamp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getArticleid() {
		return articleid;
	}
	public void setArticleid(Long articleid) {
		this.articleid = articleid;
	}
	public String getQuotetext() {
		return quotetext;
	}
	public void setQuotetext(String quotetext) {
		this.quotetext = quotetext;
	}
	public String getQuoteauthor() {
		return quoteauthor;
	}
	public void setQuoteauthor(String quoteauthor) {
		this.quoteauthor = quoteauthor;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ArticleQuoteModel [id=" + id + ", articleid=" + articleid + ", quotetext=" + quotetext
				+ ", quoteauthor=" + quoteauthor + ", timestamp=" + timestamp + "]";
	}
	
	
	
}
