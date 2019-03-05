package com.foodblog.sa.tmodel;

import java.util.ArrayList;

import com.foodblog.sa.domain.TagsModel;
import com.foodblog.sa.enumHelper.ArticleStatus;

public class TArticle {

	private long id;
	private String articleHeading;
	private String articleBy;
	private String articleFirstParagraph;
	private String articleSecondParagraph;
	private TagsModel articleMaintag;
	private String articleImage;
	private ArrayList<TagsModel> articleSubtags;
	private String articleQuote;
	private String articelQuoteAuthor;
	private String timestamp;
	private ArticleStatus articleStatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getArticleHeading() {
		return articleHeading;
	}
	public void setArticleHeading(String articleHeading) {
		this.articleHeading = articleHeading;
	}
	public String getArticleBy() {
		return articleBy;
	}
	public void setArticleBy(String articleBy) {
		this.articleBy = articleBy;
	}
	public String getArticleFirstParagraph() {
		return articleFirstParagraph;
	}
	public void setArticleFirstParagraph(String articleFirstParagraph) {
		this.articleFirstParagraph = articleFirstParagraph;
	}
	public String getArticleSecondParagraph() {
		return articleSecondParagraph;
	}
	public void setArticleSecondParagraph(String articleSecondParagraph) {
		this.articleSecondParagraph = articleSecondParagraph;
	}
	public TagsModel getArticleMaintag() {
		return articleMaintag;
	}
	public void setArticleMaintag(TagsModel articleMaintag) {
		this.articleMaintag = articleMaintag;
	}
	public ArrayList<TagsModel> getArticleSubtags() {
		return articleSubtags;
	}
	public void setArticleSubtags(ArrayList<TagsModel> articleSubtags) {
		this.articleSubtags = articleSubtags;
	}
	public String getArticleQuote() {
		return articleQuote;
	}
	public void setArticleQuote(String articleQuote) {
		this.articleQuote = articleQuote;
	}
	public String getArticelQuoteAuthor() {
		return articelQuoteAuthor;
	}
	public void setArticelQuoteAuthor(String articelQuoteAuthor) {
		this.articelQuoteAuthor = articelQuoteAuthor;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public ArticleStatus getArticleStatus() {
		return articleStatus;
	}
	public void setArticleStatus(ArticleStatus articleStatus) {
		this.articleStatus = articleStatus;
	}
	public String getArticleImage() {
		return articleImage;
	}
	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}

	
}
