package com.foodblog.sa.serviceImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodblog.sa.domain.ArticleModel;
import com.foodblog.sa.domain.ArticleQuoteModel;
import com.foodblog.sa.domain.ArticleTagsModel;
import com.foodblog.sa.domain.TagsModel;
import com.foodblog.sa.enumHelper.ArticleStatus;
import com.foodblog.sa.jparepo.ArticleRepo;
import com.foodblog.sa.jparepo.ArticleTagsRepo;
import com.foodblog.sa.jparepo.TagsRepo;
import com.foodblog.sa.service.ArticleService;
import com.foodblog.sa.tmodel.TArticle;

@Service
@Transactional
public class ArticleServiceImp implements ArticleService {

	@Autowired
	ArticleRepo articleRepo;

	@Autowired
	ArticleTagsRepo articelTagsRepo;

	@Autowired
	ArticleQuoteServiceImp articleQuoteServiceImp;
	
	@Autowired
	TagsRepo tagsRepo;

	@Override
	public ArticleModel addArticle(ArticleModel article) {
		// TODO Auto-generated method stub
		return articleRepo.save(article);
	}

	@Override
	public ArticleModel findArticleById(Long id) {
		return articleRepo.findById(id).get();
	}

	@Override
	public Long publishArticle(TArticle article) {
		ArticleModel art = new ArticleModel();
		art.setArticleheading(article.getArticleHeading());
		art.setArticleby(article.getArticleBy());
		art.setArticlefirst(article.getArticleFirstParagraph());
		art.setArticlesecond(article.getArticleSecondParagraph());
		art.setArticlemaintag(article.getArticleMaintag().getTagName());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		art.setArticletimestamp(timeStamp);
		art.setArticlestatus(ArticleStatus.ACTIVE);
		ArticleModel savedArticle = addArticle(art);
		
		ArticleTagsModel am = new ArticleTagsModel();
		am.setArticleid(savedArticle.getId());
		am.setTagid(article.getArticleMaintag().getId());
		am.setTagName(article.getArticleMaintag().getTagName());
		articelTagsRepo.save(am);

		ArticleQuoteModel aq = new ArticleQuoteModel();
		aq.setArticleid(savedArticle.getId());
		aq.setQuoteauthor(article.getArticelQuoteAuthor());
		aq.setQuotetext(article.getArticleQuote());
		aq.setTimestamp(timeStamp);
		articleQuoteServiceImp.save(aq);

		for(TagsModel subarticle : article.getArticleSubtags()) {
			if(subarticle.getId() != article.getArticleMaintag().getId()) {
				ArticleTagsModel subTag = new ArticleTagsModel();
				subTag.setArticleid(savedArticle.getId());
				subTag.setTagid(subarticle.getId());
				subTag.setTagName(subarticle.getTagName());
				articelTagsRepo.save(subTag);
			}
		}
		return null;
	}

	@Override
	public Long draftArticle(TArticle article) {
		ArticleModel art = new ArticleModel();
		art.setArticleheading(article.getArticleHeading());
		art.setArticleby(article.getArticleBy());
		art.setArticlefirst(article.getArticleFirstParagraph());
		art.setArticlesecond(article.getArticleSecondParagraph());
		art.setArticlemaintag(article.getArticleMaintag().getTagName());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		art.setArticletimestamp(timeStamp);
		art.setArticlestatus(ArticleStatus.PENDING);
		ArticleModel savedArticle = addArticle(art);
		
		ArticleTagsModel am = new ArticleTagsModel();
		am.setArticleid(savedArticle.getId());
		am.setTagid(article.getArticleMaintag().getId());
		am.setTagName(article.getArticleMaintag().getTagName());
		articelTagsRepo.save(am);

		ArticleQuoteModel aq = new ArticleQuoteModel();
		aq.setArticleid(savedArticle.getId());
		aq.setQuoteauthor(article.getArticelQuoteAuthor());
		aq.setQuotetext(article.getArticleQuote());
		aq.setTimestamp(timeStamp);
		articleQuoteServiceImp.save(aq);

		for(TagsModel subarticle : article.getArticleSubtags()) {
			if(subarticle.getId() != article.getArticleMaintag().getId()) {
				ArticleTagsModel subTag = new ArticleTagsModel();
				subTag.setArticleid(savedArticle.getId());
				subTag.setTagid(subarticle.getId());
				subTag.setTagName(subarticle.getTagName());
				articelTagsRepo.save(subTag);
			}
		}
		
		return  savedArticle.getId();
	}

	@Override
	public TArticle getArticleById(Long id) {
		
		TArticle article = new TArticle();
		article.setId(id);

		ArticleQuoteModel quote = articleQuoteServiceImp.findByArticleId(id);
		article.setArticelQuoteAuthor(quote.getQuoteauthor());
		article.setArticleQuote(quote.getQuotetext());

		ArrayList<ArticleTagsModel> tagsList = articelTagsRepo.findByArticleid(id);
		ArrayList<TagsModel> tagslist = new ArrayList<>();
		for (ArticleTagsModel articleTagsModel : tagsList) {
			System.out.println(articleTagsModel.getTagid());
			TagsModel tm = new TagsModel();
			tm.setId(articleTagsModel.getTagid());
			tm.setTagName(articleTagsModel.getTagName());
			tagslist.add(tm);
		}
		
		article.setArticleSubtags(tagslist);
		
		ArticleModel art = findArticleById(id);
		System.out.println(art.getArticlemaintag());
		article.setArticleBy(art.getArticleby());
		article.setArticleHeading(art.getArticleheading());
		article.setArticleFirstParagraph(art.getArticlefirst());
		article.setArticleSecondParagraph(art.getArticlesecond());
		article.setTimestamp(art.getArticletimestamp());
		article.setArticleStatus(art.getArticlestatus());
		TagsModel maintag = tagsRepo.findByTagname(art.getArticlemaintag());
		article.setArticleMaintag(maintag);
		
		return article;
	}

}
