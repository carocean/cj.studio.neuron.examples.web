package cj.test.jeewebsite;

import java.util.List;

import cj.test.jeewebsite.bo.CategoryBO;


public interface ICategoryDAO {
	List<CategoryBO> getAll();

	CategoryBO get(String id);
}
