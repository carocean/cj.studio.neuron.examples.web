package your.crop.examples.website.bs;

import java.math.BigInteger;
import java.util.List;

import your.crop.examples.website.bo.ArticleBO;
import your.crop.examples.website.bo.CategoryBO;

public interface IArticleBS {
	void saveArticle(ArticleBO bo);
	void deleteArticle(BigInteger id);
	ArticleBO getArticle(BigInteger id);
	List<ArticleBO> getAllArticles();
	List<ArticleBO> getArticlesByCategory(String id);
	List<CategoryBO> getCategories();
}
