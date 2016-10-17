package cj.test.jeewebpart.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.jpa.CjTransaction;
import cj.test.jeewebpart.ICategoryDAO;
import cj.test.jeewebpart.bo.CategoryBO;
@CjBridge(aspects = "logging+transaction")
@CjService(name="categoryDAO")
public class CategoryDAO implements ICategoryDAO{
	@PersistenceContext
	EntityManager em;
	@Override
	@CjTransaction(unitName = "test")
	public List<CategoryBO> getAll() {
		TypedQuery<CategoryBO> q=em.createQuery("select c from CategoryBO c",CategoryBO.class);
		return q.getResultList();
	}
	@CjTransaction(unitName = "test")
	@Override
	public CategoryBO get(String id) {
		TypedQuery<CategoryBO> q=em.createQuery("select c from CategoryBO c where c.id=:id",CategoryBO.class);
		q.setParameter("id", new BigInteger(id));
		return q.getSingleResult();
	}
}
