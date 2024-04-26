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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 姜峰
 *
 */
@Entity
@Table(name="user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
//	@OneToMany
//	@JoinTable(name="jingfengtrip", 
//			joinColumns={ @JoinColumn(name="user_id") }, 
//							inverseJoinColumns={ @JoinColumn(name="id") })
	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="id") // 报错，外键，先不加
	private Set<JingFengTrip> jingFengTrips = new HashSet<>();
	
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
	public Set<JingFengTrip> getJingFengTrips() {
		return jingFengTrips;
	}
	public void setJingFengTrips(Set<JingFengTrip> jingFengTrips) {
		this.jingFengTrips = jingFengTrips;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", jingFengTrips="
				+ jingFengTrips + "]";
	}
	
}
