package cj.test.jeewebpart;

import java.util.List;

import cj.test.jeewebpart.bo.CategoryBO;


public interface ICategoryDAO {
	List<CategoryBO> getAll();

	CategoryBO get(String id);
}
