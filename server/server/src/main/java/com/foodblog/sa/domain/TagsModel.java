package com.foodblog.sa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_tag_table", schema = "stonehead")
public class TagsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tagname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTagName() {
		return tagname;
	}
	public void setTagName(String tagName) {
		this.tagname = tagName;
	}
	
	
}
