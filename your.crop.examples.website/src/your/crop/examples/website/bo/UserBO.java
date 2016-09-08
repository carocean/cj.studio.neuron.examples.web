package your.crop.examples.website.bo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the sos_user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="UserBO.findAll", query="SELECT s FROM UserBO s")
public class UserBO implements Serializable {
	private static final long serialVersionUID = 1L;
	String userName;
	int age;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;
	public UserBO() {
		// TODO Auto-generated constructor stub
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
