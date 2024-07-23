/**
 * 
 */
package org.feng.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 姜峰
 *
 */
@Entity
@Table(name="user")
public class UserPO implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
//	@OneToMany
//	@JoinTable(name="jiangfengtrip",
//			joinColumns={ @JoinColumn(name="user_id") }, 
//							inverseJoinColumns={ @JoinColumn(name="id") })
	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="id") // 报错，外键，先不加
	private Set<JiangFengTrip> jiangFengTrips = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<JiangFengTrip> getJingFengTrips() {
		return jiangFengTrips;
	}
	public void setJingFengTrips(Set<JiangFengTrip> jiangFengTrips) {
		this.jiangFengTrips = jiangFengTrips;
	}
	@Override
	public String toString() {
		return "UserPO [id=" + id + ", username=" + username + ", password=" + password + ", jiangFengTrips="
				+ jiangFengTrips + "]";
	}
	
}
