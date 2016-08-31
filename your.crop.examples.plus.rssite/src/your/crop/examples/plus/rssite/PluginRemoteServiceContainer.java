package your.crop.examples.plus.rssite;

import java.util.Map;

import cj.lns.chip.sos.service.framework.IRemoteService;
import cj.lns.chip.sos.service.framework.IRemoteServiceContainer;
import cj.lns.chip.sos.service.framework.RemoteServiceFramework;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.IAssembly;
import cj.studio.ecm.IAssemblyDependency;
import cj.studio.ecm.IServiceAfter;
import cj.studio.ecm.IServiceProvider;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.ServiceCollection;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.logging.ILogging;
import cj.studio.ecm.plugins.IAssemblyPlugins;
import cj.studio.ecm.plugins.IPluginDependencyEvent;
import cj.studio.ecm.plugins.moduleable.IModule;
import cj.studio.ecm.plugins.moduleable.ModuleContainer;

@CjService(name = "pluginRemoteServiceContainer")
public class PluginRemoteServiceContainer extends ModuleContainer
		implements IPluginDependencyEvent ,IServiceAfter{
	ILogging log;
	@CjServiceRef(refByName = "remoteServiceFramework")
	RemoteServiceFramework framework;
	@CjServiceRef
	SendServiceCenter sendServiceCenter;
	MyServiceProvider provider;
	public PluginRemoteServiceContainer() {
		log = CJSystem.current().environment().logging();
		provider=new MyServiceProvider();
	}
	@Override
	public void onAfter(IServiceSite site) {
		String homeDir = site.getProperty("home.dir");
	}
	
	@Override
	protected IServiceProvider getFrameworkServiceProvider() {
		return provider;
	}

	@Override
	protected void onContainerReady(IAssemblyPlugins root, IServiceSite site) {
		super.onContainerReady(root, site);
		framework.load(site);
		

		String ids[] = super.enumModuleName();
		for (String id : ids) {
			IRemoteServiceContainer container = framework.container();
			IModule m = super.module(id);
			m.site().out().plugLast("sendServiceCenter", sendServiceCenter);
			ServiceCollection<IRemoteService> remotes = m.site()
					.getServices(IRemoteService.class);
			try {
				container.append(remotes);
			} catch (Exception e) {
				log.error(getClass(), e);
			}
		}
	}

	@Override
	protected void onModuleReady(IAssembly the, IModule m,
			Map<String, IModule> modules, IAssembly parent,
			IAssemblyDependency root) {
		super.onModuleReady(the, m, modules, parent, root);

	}
	private class MyServiceProvider implements IServiceProvider{

		@Override
		public Object getService(String serviceId) {
			return null;
		}
		
		@Override
		public <T> ServiceCollection<T> getServices(Class<T> serviceClazz) {
			return null;
		}
	}
}
