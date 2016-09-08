package cj.studio.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import cj.lns.chip.sos.service.framework.IPersistenceFactory;
import cj.studio.ecm.EcmException;
import cj.studio.ecm.adapter.IAdaptable;
import cj.studio.ecm.adapter.IPrototype;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.bridge.IAspect;
import cj.studio.ecm.bridge.ICutpoint;

/**
 * 事务方面
 * 
 * <pre>
 * 方面名：transaction
 * －用于拦截在dao层中的方法，为之添加事务
 * －用 @cjBridge声明方面，或用xml,json方式
 * 
 * 约束：
 * －使用者必须实现IEntityManager接口
 * </pre>
 * 
 * @author carocean
 *
 */
@CjService(name = "transaction")
public class TransactionAspect implements IAspect {
	@CjServiceRef(refByName = "persistenceFactory")
	IPersistenceFactory factory;

	public TransactionAspect() {
	}

	@Override
	public Object cut(Object bridge, Object[] args, ICutpoint point) {
		CjTransaction p = point.getMethodAnnotation(CjTransaction.class);
		if (p == null) {
			return point.cut(bridge, args);
		}

		IAdaptable a = (IAdaptable) bridge;
		IPrototype pt = a.getAdapter(IPrototype.class);
		Object b = pt.unWrapper();
		if (!(b instanceof IEntityManagerable)) {
			throw new EcmException("必须实现IEntityManagerable。" + b.getClass().getName());
		}
		IEntityManagerable em = (IEntityManagerable) b;
		EntityManager e = factory.getFactory(p.unitName()).createEntityManager();
		EntityTransaction tran = e.getTransaction();
		try {
			tran.begin();
			em.setEntityManager(e);
			Object ret = point.cut(bridge, args);
			tran.commit();
			return ret;
		} catch (Exception e1) {
			if (tran.isActive())
				tran.rollback();
			throw e1;
		}finally{
			if(e!=null){
				e.close();
			}
		}
	}

	@Override
	public Class<?>[] getCutInterfaces() {
		// TODO Auto-generated method stub
		return null;
	}

}
