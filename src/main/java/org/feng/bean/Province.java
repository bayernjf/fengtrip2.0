/**
 * 
 */
package org.feng.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.alibaba.fastjson.JSON;

/**
 * @author 姜峰
 *
 */
@Entity
@Table(name="province")
public class Province {
	
	@Id
	private Integer codeid;
	private Integer parentid;
	private String cityname;
	
//	@ManyToOne
//	@JoinColumn(name="parentfeng")
//	@NotFound(action=NotFoundAction.IGNORE)
//	private Province province;
////	@OneToMany
////	@JoinTable(name = "childrenProvinces", 
////			joinColumns = { @JoinColumn(name = "friendsId") }, 
////							inverseJoinColumns = { @JoinColumn(name = "ownId") })
	@OneToMany
//	@JoinColumn(name="parentfeng", nullable=true)
	private List<Province> childrenProvinces;
	
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Province(Integer codeid, Integer parentid, String cityname, List<Province> childrenProvinces) {
		super();
		this.codeid = codeid;
		this.parentid = parentid;
		this.cityname = cityname;
		this.childrenProvinces = childrenProvinces;
	}

	public List<Province> getChildrenProvinces() {
		return childrenProvinces;
	}

	public void setChildrenProvinces(List<Province> childrenProvinces) {
		this.childrenProvinces = childrenProvinces;
	}

	public Integer getCodeid() {
		return codeid;
	}

	public void setCodeid(Integer codeid) {
		this.codeid = codeid;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public String toString() {
//		return "Province [codeid=" + codeid + ", parentid=" + parentid + ", cityname=" + cityname
//				+ ", childrenProvinces=" + childrenProvinces + "]";
		return JSON.toJSONString(this);
	}

}
