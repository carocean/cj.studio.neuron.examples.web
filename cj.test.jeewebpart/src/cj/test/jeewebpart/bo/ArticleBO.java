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
@Table(name="article")
@NamedQuery(name="ArticleBO.findAll", query="SELECT s FROM ArticleBO s")
public class ArticleBO implements Serializable {
	private static final long serialVersionUID = 1L;
	String title;
	String cnt;
	String creator;
	String ctime;
	BigInteger category;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;
	public BigInteger getCategory() {
		return category;
	}
	public void setCategory(BigInteger category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	
}
