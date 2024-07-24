/**
 * 
 */
package org.feng.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author 姜峰
 *
 */
@Data
public class ProvincePO {
	
	@Id
	private Integer codeid;
	private Integer parentid;
	private String cityname;
	
//	@ManyToOne
//	@JoinColumn(name="parentfeng")
//	@NotFound(action=NotFoundAction.IGNORE)
//	private ProvincePO province;
////	@OneToMany
////	@JoinTable(name = "childrenProvincePOS",
////			joinColumns = { @JoinColumn(name = "friendsId") }, 
////							inverseJoinColumns = { @JoinColumn(name = "ownId") })
	@OneToMany
//	@JoinColumn(name="parentfeng", nullable=true)
	private List<ProvincePO> childrenProvincePOS;
	
	public ProvincePO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProvincePO(Integer codeid, Integer parentid, String cityname, List<ProvincePO> childrenProvincePOS) {
		super();
		this.codeid = codeid;
		this.parentid = parentid;
		this.cityname = cityname;
		this.childrenProvincePOS = childrenProvincePOS;
	}

	public List<ProvincePO> getChildrenProvinces() {
		return childrenProvincePOS;
	}

	public void setChildrenProvinces(List<ProvincePO> childrenProvincePOS) {
		this.childrenProvincePOS = childrenProvincePOS;
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
//		return "ProvincePO [codeid=" + codeid + ", parentid=" + parentid + ", cityname=" + cityname
//				+ ", childrenProvincePOS=" + childrenProvincePOS + "]";
		return JSON.toJSONString(this);
	}

}
