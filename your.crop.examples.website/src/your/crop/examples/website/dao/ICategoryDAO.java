package your.crop.examples.website.dao;

import java.util.List;

import your.crop.examples.website.bo.CategoryBO;

public interface ICategoryDAO {
	List<CategoryBO> getAll();

	CategoryBO get(String id);
}
