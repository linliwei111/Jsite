/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.work.entity;

import com.jsite.modules.sys.entity.User;
import com.jsite.modules.sys.entity.Office;
import com.jsite.modules.sys.entity.Area;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jsite.common.persistence.DataEntity;

/**
 * 工时表Entity
 * @author 工时表
 * @version 2019-01-23
 */
public class TaskTime extends DataEntity<TaskTime> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 归属用户
	private Office office;		// 归属部门
	private Area area;		// 归属区域
	private String monday;		// 星期一
	private String tuesday;		// 星期二
	private String wednesday;		// 星期三
	private String thursday;		// 星期四
	private String friday;		// 星期五
	private String saturday;		// 星期六
	private String sunday;		// 星期日
	private Date inDate;		// 加入日期
	
	public TaskTime() {
		super();
	}

	public TaskTime(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	@Length(min=0, max=255, message="星期一长度必须介于 0 和 255 之间")
	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}
	
	@Length(min=0, max=255, message="星期二长度必须介于 0 和 255 之间")
	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}
	
	@Length(min=0, max=255, message="星期三长度必须介于 0 和 255 之间")
	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	
	@Length(min=0, max=255, message="星期四长度必须介于 0 和 255 之间")
	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}
	
	@Length(min=0, max=255, message="星期五长度必须介于 0 和 255 之间")
	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}
	
	@Length(min=0, max=255, message="星期六长度必须介于 0 和 255 之间")
	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}
	
	@Length(min=0, max=255, message="星期日长度必须介于 0 和 255 之间")
	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
}