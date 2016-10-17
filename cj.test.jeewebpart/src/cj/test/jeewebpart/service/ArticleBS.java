package cj.test.jeewebpart.service;

import java.math.BigInteger;
import java.util.List;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.test.jeewebpart.IArticleBS;
import cj.test.jeewebpart.IArticleDAO;
import cj.test.jeewebpart.ICategoryDAO;
import cj.test.jeewebpart.bo.ArticleBO;
import cj.test.jeewebpart.bo.CategoryBO;
@CjService(name="articleBS")
public class ArticleBS implements IArticleBS{
	@CjServiceRef
	private IArticleDAO articleDAO;
	@CjServiceRef
	private ICategoryDAO categoryDAO;
	@Override
	public void saveArticle(ArticleBO bo) {
		bo.setCtime(String.valueOf(System.currentTimeMillis()));
		articleDAO.save(bo);
	}

	@Override
	public void deleteArticle(BigInteger id) {
		articleDAO.delete(id);
	}

	@Override
	public ArticleBO getArticle(BigInteger id) {
		// TODO Auto-generated method stub
		return articleDAO.get(id);
	}

	@Override
	public List<ArticleBO> getAllArticles() {
		// TODO Auto-generated method stub
		return articleDAO.getAll();
	}

	@Override
	public List<ArticleBO> getArticlesByCategory(String id) {
		return articleDAO.getArticlesByCategory(id);
	}
	@Override
	public CategoryBO getCategory(String id){
		return categoryDAO.get(id);
	}
	@Override
	public List<CategoryBO> getCategories() {
		// TODO Auto-generated method stub
		return categoryDAO.getAll();
	}

}
