package cj.test.jeewebpart.bo;

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
@Table(name="category")
@NamedQuery(name="CategoryBO.findAll", query="SELECT s FROM CategoryBO s")
public class CategoryBO implements Serializable {
	private static final long serialVersionUID = 1L;
	String description;
	String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;
	public CategoryBO() {
		// TODO Auto-generated constructor stub
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	
}
