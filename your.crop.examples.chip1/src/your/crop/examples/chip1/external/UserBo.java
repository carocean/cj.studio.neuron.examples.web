package your.crop.examples.chip1.external;

import cj.studio.ecm.annotation.CjExotericalType;

@CjExotericalType
public class UserBo {
 String userId;
 String userName;
 public String getUserId() {
	return userId;
}
 public String getUserName() {
	return userName;
}
 public void setUserId(String userId) {
	this.userId = userId;
}
 public void setUserName(String userName) {
	this.userName = userName;
}
}
