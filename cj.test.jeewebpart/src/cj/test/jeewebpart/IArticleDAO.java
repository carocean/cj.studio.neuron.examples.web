package cj.test.jeewebpart;

import java.math.BigInteger;
import java.util.List;

import cj.test.jeewebpart.bo.ArticleBO;


public interface IArticleDAO {
	void save(ArticleBO bo);
	void delete(BigInteger id);
	ArticleBO get(BigInteger id);
	List<ArticleBO> getAll();
	List<ArticleBO> getArticlesByCategory(String id);
	
}
