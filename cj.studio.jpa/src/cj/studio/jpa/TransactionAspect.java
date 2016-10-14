package cj.studio.jpa;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

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
		Field field=findPersistenceContext(b.getClass());
		if(field==null){
			throw new EcmException(String.format("类：%s 未发现注解：@PersistenceContext", b.getClass()));
		}
		EntityManager e = factory.getFactory(p.unitName()).createEntityManager();
		
		setPersistenceContext(b,field,e);
		EntityTransaction tran = e.getTransaction();
		try {
			tran.begin();
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

	private Field findPersistenceContext(Class<?> c) {
		Field[] arr = c.getDeclaredFields();
		for(Field f:arr	){
			PersistenceContext pc=f.getAnnotation(PersistenceContext.class);
			if(pc!=null)return f;
		}
		if (!c.equals(Object.class)){
			return findPersistenceContext(c.getSuperclass());
		}
		return null;
	}

	private void setPersistenceContext(Object b, Field f, EntityManager e) {
		try {
			f.setAccessible(true);
			f.set(b, e);
		} catch (Exception e1) {
			throw new EcmException(e1);
		} 
	}

	@Override
	public Class<?>[] getCutInterfaces() {
		// TODO Auto-generated method stub
		return null;
	}

}
