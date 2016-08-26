package your.crop.examples.chip2;

import cj.studio.ecm.annotation.CjService;
import your.crop.examples.chip1.external.IDeptmemt;
import your.crop.examples.chip1.external.UserBo;
/*
 * 实现了chip1中的IDeptmemt
 */
@CjService(name="deptment",isExoteric=true)
public class Deptment implements IDeptmemt{
	UserBo bo;
	public Deptment() {
		bo=new UserBo();
	}
	@Override
	public UserBo getUserId(String id) {
		bo.setUserId("zhaoxb");
		bo.setUserName("这是扩展chip1中的IDeptmemt：赵向彬 啊哈哈");
		return  bo;
	}

}
