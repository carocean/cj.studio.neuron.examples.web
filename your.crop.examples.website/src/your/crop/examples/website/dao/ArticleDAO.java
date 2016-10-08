package your.crop.examples.website.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.jpa.CjTransaction;
import cj.studio.jpa.IEntityManagerable;
import your.crop.examples.website.bo.ArticleBO;
@CjBridge(aspects = "logging+transaction")
@CjService(name="articleDAO")
public class ArticleDAO implements IArticleDAO,IEntityManagerable{
	EntityManager em;
	@Override
	public void setEntityManager(EntityManager em) {
		this.em=em;
	}
	@Override
	@CjTransaction(unitName = "test")
	public void save(ArticleBO bo) {
		em.persist(bo);
	}

	@Override
	@CjTransaction(unitName = "test")
	public void delete(BigInteger id) {
		String hql="delete from ArticleBO c where c.id=:id";
		TypedQuery<ArticleBO> q=em.createQuery(hql,ArticleBO.class);
		q.setParameter("id", id);
		q.executeUpdate();
	}

	@Override
	@CjTransaction(unitName = "test")
	public ArticleBO get(BigInteger id) {
		String hql="select c from ArticleBO c where c.id=:id";
		TypedQuery<ArticleBO> q=em.createQuery(hql,ArticleBO.class);
		q.setParameter("id", id);
		return q.getSingleResult();
	}

	@Override
	@CjTransaction(unitName = "test")
	public List<ArticleBO> getAll() {
		TypedQuery<ArticleBO> q=em.createQuery("select c from ArticleBO c",ArticleBO.class);
		return q.getResultList();
	}

	@Override
	@CjTransaction(unitName = "test")
	public List<ArticleBO> getArticlesByCategory(String id) {
		String hql="select c from ArticleBO c where c.category=:category";
		TypedQuery<ArticleBO> q=em.createQuery(hql,ArticleBO.class);
		q.setParameter("category", new BigInteger(id));
		return q.getResultList();
	}

}
