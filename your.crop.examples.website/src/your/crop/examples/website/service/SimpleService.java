package your.crop.examples.website.service;

import cj.studio.ecm.annotation.CjService;
//演示jss中对容器中的java服务请求的拦截
//内核为了不侵入开发者实现的类的默认构造函数，所以只要是适配器、桥、或要在jss服务中调用其方法，均必须是接口方法。因为内核从Object.class生成代理，这样就不强求开发者提供一个空构造。
@CjService(name="simpleService")
public class SimpleService implements IEcho {
	/* (non-Javadoc)
	 * @see your.crop.examples.website.service.IEcho#printEcho(java.lang.String)
	 */
	@Override
	public void printEcho(String text){
		System.out.println(text);
	}
}
