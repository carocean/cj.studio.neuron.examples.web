/*
 * 2016.0829
 * 作者：cj
 * 注意：extends只能从一个接口派生，且如果使用接口，其它非接口的导出函数将不可见。
 * isStronglyJss:false,
 *	extends:'',
 * <![jss:{
		scope:'runtime',
		filter:{
	 	}
 	},
 	services:{
 		factory:"persistenceFactory"
 	}
 ]>
 */

var UserBO = Java.type('your.crop.examples.website.bo.UserBO');
var String = Java.type('java.lang.String');
var WebUtil = Java.type('cj.studio.ecm.net.web.WebUtil');


exports.getUsers = function() {
	print('这是演示jss服务通过方面调用');
	var factory=imports.head.services.factory;
	var em = factory.getFactory('test').createEntityManager();
	var tran = em.getTransaction();
	try {
		tran.begin();
		var q=em.createQuery("select u from UserBO u",UserBO.class);
		return q.getResultList();
		tran.commit();
	} catch (e) {
		if (tran.isActive())
			tran.rollback();
		throw e;
	}finally{
		if(em!=null)
		em.close();
	}
}