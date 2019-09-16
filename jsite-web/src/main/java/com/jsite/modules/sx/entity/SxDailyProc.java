package com.jsite.modules.sx.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.jsite.common.persistence.TreeEntity;

/**
 * 实训流程Entity
 * @author 林鹏群
 * @version 2019-09-07
 */
public class SxDailyProc extends TreeEntity<SxDailyProc> {
	
	private static final long serialVersionUID = 1L;

	private String href;		// 链接
	private String target;		// 目标
	private String icon;		// 图标
	private String isShow;		// 显示
	private String permission;		// 权限标识
	private String roleName;		// 参与角色
	private String job;		// 工作内容
	private String refDoc;		// 参考文件
	private String joinTime;		// 参与时间
	
	public SxDailyProc() {
		super();
	}

	public SxDailyProc(String id){
		super(id);
	}


	@Override
	public SxDailyProc getParent() {
		return parent;
	}

    @Override
	public void setParent(SxDailyProc parent) {
		this.parent = parent;
	}
	@Length(min=0, max=2000, message="链接长度必须介于 0 和 2000 之间")
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	@Length(min=0, max=20, message="目标长度必须介于 0 和 20 之间")
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
	@Length(min=0, max=100, message="图标长度必须介于 0 和 100 之间")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Length(min=1, max=1, message="显示长度必须介于 1 和 1 之间")
	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
	@Length(min=0, max=200, message="权限标识长度必须介于 0 和 200 之间")
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	@Length(min=0, max=255, message="参与角色长度必须介于 0 和 255 之间")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Length(min=0, max=255, message="工作内容长度必须介于 0 和 255 之间")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@Length(min=0, max=255, message="参考文件长度必须介于 0 和 255 之间")
	public String getRefDoc() {
		return refDoc;
	}

	public void setRefDoc(String refDoc) {
		this.refDoc = refDoc;
	}
	
	@Length(min=0, max=255, message="参与时间长度必须介于 0 和 255 之间")
	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	
}