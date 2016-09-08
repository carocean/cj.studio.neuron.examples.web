package your.crop.examples.website.dao;

import java.util.List;

import cj.studio.jpa.CjTransaction;
import your.crop.examples.website.bo.UserBO;

public interface IUserDao {

	List<UserBO> getUsers();

}