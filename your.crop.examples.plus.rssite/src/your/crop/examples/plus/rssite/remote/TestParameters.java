package your.crop.examples.plus.rssite.remote;

import java.math.BigInteger;

import cj.lns.chip.sos.service.framework.IRemoteParameters;
import cj.lns.chip.sos.service.framework.annotation.CjRemoteParameter;

public class TestParameters implements IRemoteParameters{
	@CjRemoteParameter(must = true, usage = "视窗标识")
	BigInteger swsId;
	@CjRemoteParameter(must = true, usage = "令牌")
	String cjtoken;
	
	public BigInteger getSwsId() {
		return swsId;
	}
	public void setSwsId(BigInteger swsId) {
		this.swsId = swsId;
	}
	@Override
	public String cjtoken() {
		// TODO Auto-generated method stub
		return cjtoken;
	}
	@Override
	public void cjtoken(String token) {
		// TODO Auto-generated method stub
		this.cjtoken=token;
	}
}
