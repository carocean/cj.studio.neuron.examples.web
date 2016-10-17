package cj.test.jeewebpart;

import java.math.BigInteger;
import java.util.List;

import cj.test.jeewebpart.bo.ArticleBO;
import cj.test.jeewebpart.bo.CategoryBO;


public interface IArticleBS {
	void saveArticle(ArticleBO bo);
	void deleteArticle(BigInteger id);
	ArticleBO getArticle(BigInteger id);
	List<ArticleBO> getAllArticles();
	List<ArticleBO> getArticlesByCategory(String id);
	List<CategoryBO> getCategories();
	CategoryBO getCategory(String id);
}
