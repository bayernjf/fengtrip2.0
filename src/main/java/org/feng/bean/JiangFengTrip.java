/**
 * 
 */
package org.feng.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 姜峰
 *
 */
@Entity
@Table(name="jiangfengtrip")
public class JiangFengTrip implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String location;
	private String activity;
	private String transportation;
	private String time;
	private String city;
	private Date createTime;
	private Integer priority;
	private Integer userId;
	/*
	 * 0：未完成
	 * 1：已完成
	 * -1：删除
	 */
	private Integer stat;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	@Override
	public String toString() {
		return "JiangFengTrip [id=" + id + ", location=" + location + ", activity=" + activity + ", transportation="
				+ transportation + ", time=" + time + ", city=" + city + ", createTime=" + createTime + ", priority="
				+ priority + ", userId=" + userId + ", stat=" + stat + "]";
	}

}
