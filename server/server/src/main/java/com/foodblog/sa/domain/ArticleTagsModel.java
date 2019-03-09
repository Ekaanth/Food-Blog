package com.foodblog.sa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articletaglist", schema = "stonehead")
public class ArticleTagsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private Long articleid;
	private Long tagid;
	private String tagName;
	
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
	public Long getTagid() {
		return tagid;
	}
	public void setTagid(Long tagid) {
		this.tagid = tagid;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	@Override
	public String toString() {
		return "ArticleTagsModel [id=" + id + ", articleid=" + articleid + ", tagid=" + tagid + ", tagName=" + tagName
				+ "]";
	}
	
	
}
