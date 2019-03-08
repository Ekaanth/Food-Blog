package com.foodblog.sa.serviceImp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.foodblog.sa.tmodel.TCategoryCount;

@Service
@Transactional
public class ArticleServiceImp implements ArticleService {

	private static String UPLOADED_FOLDER = "C://Apache24//htdocs//downloadUpload//";

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
		String timeStamp = new SimpleDateFormat("dd MMMMM yyyy").format(new Date());
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

		for (TagsModel subarticle : article.getArticleSubtags()) {
			if (subarticle.getId() != article.getArticleMaintag().getId()) {
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
		String timeStamp = new SimpleDateFormat("dd MMMMM yyyy").format(new Date());
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

		for (TagsModel subarticle : article.getArticleSubtags()) {
			if (subarticle.getId() != article.getArticleMaintag().getId()) {
				ArticleTagsModel subTag = new ArticleTagsModel();
				subTag.setArticleid(savedArticle.getId());
				subTag.setTagid(subarticle.getId());
				subTag.setTagName(subarticle.getTagName());
				articelTagsRepo.save(subTag);
			}
		}

		return savedArticle.getId();
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
		article.setArticleBy(art.getArticleby());
		article.setArticleHeading(art.getArticleheading());
		article.setArticleFirstParagraph(art.getArticlefirst());
		article.setArticleSecondParagraph(art.getArticlesecond());
		article.setArticleImage(art.getArtcleimage());
		article.setTimestamp(art.getArticletimestamp());
		article.setArticleStatus(art.getArticlestatus());
		TagsModel maintag = tagsRepo.findByTagname(art.getArticlemaintag());
		article.setArticleMaintag(maintag);

		return article;
	}

	@Override
	public void addArticleImage(MultipartFile files, Long id) {
		new File(UPLOADED_FOLDER + "//" + id).mkdirs();
		try {
			String timeStamp = new SimpleDateFormat("dd MMMMM yyyy").format(new Date());
			byte[] bytes = files.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + "//" + id + "//" + timeStamp + ".jpeg");
			Files.write(path, bytes);
			// StringBuilder base64 = new StringBuilder("data:image/png;base64,");
			// base64.append(Base64.getEncoder().encodeToString(bytes));
			ArticleModel artm = articleRepo.findById(id.intValue());
			artm.setArtcleimage(path.toString());
			articleRepo.save(artm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TArticle getActiveTArticleById(Long id) {
		ArticleModel art = findArticleById(id);
		if (art.getArticlestatus().equals(ArticleStatus.ACTIVE)) {
			return getArticleById(id);
		} else {
			return null;
		}
	}

	@Override
	public ArticleModel getActiveArticleById(Long id) {
		ArticleModel art = findArticleById(id);
		if (art.getArticlestatus().equals(ArticleStatus.ACTIVE)) {
			return findArticleById(id);
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<ArticleModel> getLatestFiveArticles() {
		ArrayList<ArticleModel> getAllActiveArticle = (ArrayList<ArticleModel>) articleRepo.findAll();
		Collections.sort(getAllActiveArticle, new Comparator<ArticleModel>() {
			@Override
			public int compare(ArticleModel o1, ArticleModel o2) {
				if (o1.getArticleby() == null || o2.getArticleby() == null)
					return 0;
				return o1.getArticleby().compareTo(o2.getArticleby());
			}
		});
		ArrayList<ArticleModel> latestFive = new ArrayList<>();
		for (ArticleModel articleModel : getAllActiveArticle) {
			System.out.println(articleModel.getId());
			if (latestFive.size() < 5) {
				latestFive.add(getActiveArticleById(articleModel.getId()));
			}
		}
		return latestFive;
	}

	@Override
	public Collection<TArticle> getAllActiveArticles() throws JsonProcessingException {
		Collection<ArticleModel> allActiceArticle = articleRepo.findAll();
		Collection<TArticle> allActiceTArticle = null;
		for (ArticleModel articleModel : allActiceArticle) {
			if (articleModel.getArticlestatus().equals(ArticleStatus.ACTIVE)) {
				// allActiceTArticle.add(getActiveArticleById(articleModel.getId()));
				// System.out.println(getActiveArticleById(articleModel.getId());
				ObjectMapper mapper = new ObjectMapper();
				System.out.println(mapper.writeValueAsString(getActiveTArticleById(articleModel.getId())));
			}
		}
		return allActiceTArticle;
	}

	@Override
	public Collection<TCategoryCount> getRandomCategoryCount() {
		List<ArticleTagsModel> tCount = (List<ArticleTagsModel>) articelTagsRepo.findAll();

		// shuffle list
		Collections.shuffle(tCount);

		// adding defined amount of numbers to target list
		List<ArticleTagsModel> targetList = new ArrayList<ArticleTagsModel>();

		for (ArticleTagsModel articleTagsModel : tCount) {
			if (targetList.size() < 4) {
				targetList.add(articleTagsModel);
			}
		}
		List<TCategoryCount> tagCount = new ArrayList<TCategoryCount>();
		for (ArticleTagsModel articleTagsModel : targetList) {
			TCategoryCount t = new TCategoryCount();
			t.setCount(articelTagsRepo.countBytagid(articleTagsModel.getTagid()));
			t.setTagid(articleTagsModel.getTagid());
			t.setTagName(articleTagsModel.getTagName());
			tagCount.add(t);
		}
		return tagCount;
	}

}
