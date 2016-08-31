package your.crop.examples.plus.rssite.remote;

import cj.lns.chip.sos.service.framework.IRemoteService;
import cj.lns.chip.sos.service.framework.RemoteResult;
import cj.lns.chip.sos.service.framework.annotation.CjRemoteMethod;
import cj.lns.chip.sos.service.framework.annotation.CjRemoteService;
import cj.studio.ecm.annotation.CjExotericalType;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.graph.CircuitException;

//使用cjnet工具，向远程服务发出查询请求：index -t sos/1.0 -Hcj-circuit-sync=true -u /rssite/test/rs/?cjtoken=xxx&swsId=99999
@CjExotericalType(typeName = "remoteService")
@CjRemoteService(usage = "演示远程服务")
//@CjBridge(aspects = "logging+transaction")//本项目不演示数据库的部分，因此未使用模块化(模块化中提供了数据库支持，包括事务、日志方面的使用
@CjService(name = "/test/rs/", isExoteric = true)
public class TestRemote implements IRemoteService {
	@CjRemoteMethod(usage = "获取视窗已挂载的应用，通过应用代码和提供商", returnContentType = "text/json", returnUsage = "返回已挂载应用，404不存在")
	public RemoteResult findAppByProvider(TestParameters parameters)
			throws CircuitException {
		return new RemoteResult();
	}
}
