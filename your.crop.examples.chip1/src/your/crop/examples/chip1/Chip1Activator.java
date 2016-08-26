package your.crop.examples.chip1;

import cj.studio.ecm.IEntryPointActivator;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.context.IElement;

/**
 * 在程序集启动后或停止前发生
 * <pre>
 * 在Assembly.json中配置：
 * entryPoint.activators
 * 还有一种用法，如果没有参数，可以不在Assembly.json中注册，而直接声明为cj服务即可。
 * </pre>
 * @author carocean
 *
 */

public class Chip1Activator implements IEntryPointActivator {

	@Override
	public void activate(IServiceSite site,IElement args) {
		System.out.println("----这是chip1活动器启动后，参数："+args);
	}

	@Override
	public void inactivate(IServiceSite site) {
		System.out.println("----这是chip1活动器停止前");
	}

}
