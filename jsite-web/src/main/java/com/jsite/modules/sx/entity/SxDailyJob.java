package com.jsite.modules.sx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsite.common.persistence.TreeEntity;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * 实训攻略Entity
 * @author 林鹏群
 * @version 2019-09-04
 */
public class SxDailyJob extends TreeEntity<SxDailyJob> {

	private static final long serialVersionUID = 1L;

	private String href;		// 链接
	private String target;		// 目标
	private String icon;		// 图标
	private String isShow;		// 是否在菜单中显示
	private String permission;		// 权限标识

	public SxDailyJob() {
		super();
		this.isShow = "1";
	}

	public SxDailyJob(String id){
		super(id);
	}

	@JsonIgnore
	public static void sortList(List<SxDailyJob> list, List<SxDailyJob> sourcelist, String parentId, boolean cascade){
		for (int i=0; i<sourcelist.size(); i++){
			SxDailyJob e = sourcelist.get(i);
			if (e.getParent()!=null && e.getParent().getId().equals(parentId)){
				list.add(e);
				if (cascade){
					// 判断是否还有子节点, 有则继续获取子节点
					for (int j=0; j<sourcelist.size(); j++){
						SxDailyJob child = sourcelist.get(j);
						if (child.getParent()!=null && child.getParent().getId().equals(e.getId())){
							sortList(list, sourcelist, e.getId(), true);
							break;
						}
					}
				}
			}
		}
	}

	@Override
	public SxDailyJob getParent() {
		return parent;
	}

    @Override
	public void setParent(SxDailyJob parent) {
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

	@Length(min=1, max=1, message="是否在菜单中显示长度必须介于 1 和 1 之间")
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

}
