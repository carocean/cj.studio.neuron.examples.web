package your.crop.examples.website.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.jpa.CjTransaction;
import cj.studio.jpa.IEntityManagerable;
import your.crop.examples.website.bo.UserBO;

@CjBridge(aspects = "logging+transaction")
@CjService(name="userDao")
public class UserDao implements IEntityManagerable, IUserDao{
	EntityManager em;
	@Override
	public void setEntityManager(EntityManager em) {
		this.em=em;
	}
	@Override
	@CjTransaction(unitName = "test")
	public List<UserBO> getUsers(){
		TypedQuery<UserBO> q=em.createQuery("select u from UserBO u",UserBO.class);
		return q.getResultList();
	}
}
