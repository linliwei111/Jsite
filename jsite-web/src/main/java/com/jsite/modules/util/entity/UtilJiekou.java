/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.util.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 接口测试Entity
 * @author 接口测试
 * @version 2019-04-03
 */
public class UtilJiekou extends DataEntity<UtilJiekou> {
	
	private static final long serialVersionUID = 1L;
	private String jiekoumingcheng;		// 接口名称
	private String jiekouleixing;		// 接口类型
	private String qingqiuurl;		// 请求URL
	private String qingqiubody;		// 请求body
	private String chenggongshifanhuixiaoxi;		// 成功时返回消息
	private String shibaishifanhuixiaoxi;		// 失败时返回消息
	private String beizhuxinxi;		// 备注信息
	
	public UtilJiekou() {
		super();
	}

	public UtilJiekou(String id){
		super(id);
	}

	@Length(min=0, max=255, message="接口名称长度必须介于 0 和 255 之间")
	@ExcelField(title="接口名称", align=2, sort=1)
	public String getJiekoumingcheng() {
		return jiekoumingcheng;
	}

	public void setJiekoumingcheng(String jiekoumingcheng) {
		this.jiekoumingcheng = jiekoumingcheng;
	}
	
	@Length(min=0, max=255, message="接口类型长度必须介于 0 和 255 之间")
	@ExcelField(title="接口类型", align=2, sort=2)
	public String getJiekouleixing() {
		return jiekouleixing;
	}

	public void setJiekouleixing(String jiekouleixing) {
		this.jiekouleixing = jiekouleixing;
	}
	
	@Length(min=0, max=255, message="请求URL长度必须介于 0 和 255 之间")
	@ExcelField(title="请求URL", align=2, sort=3)
	public String getQingqiuurl() {
		return qingqiuurl;
	}

	public void setQingqiuurl(String qingqiuurl) {
		this.qingqiuurl = qingqiuurl;
	}
	
	@Length(min=0, max=255, message="请求body长度必须介于 0 和 255 之间")
	@ExcelField(title="请求body", align=2, sort=4)
	public String getQingqiubody() {
		return qingqiubody;
	}

	public void setQingqiubody(String qingqiubody) {
		this.qingqiubody = qingqiubody;
	}
	
	@Length(min=0, max=255, message="成功时返回消息长度必须介于 0 和 255 之间")
	@ExcelField(title="成功时返回消息", align=2, sort=5)
	public String getChenggongshifanhuixiaoxi() {
		return chenggongshifanhuixiaoxi;
	}

	public void setChenggongshifanhuixiaoxi(String chenggongshifanhuixiaoxi) {
		this.chenggongshifanhuixiaoxi = chenggongshifanhuixiaoxi;
	}
	
	@Length(min=0, max=255, message="失败时返回消息长度必须介于 0 和 255 之间")
	@ExcelField(title="失败时返回消息", align=2, sort=6)
	public String getShibaishifanhuixiaoxi() {
		return shibaishifanhuixiaoxi;
	}

	public void setShibaishifanhuixiaoxi(String shibaishifanhuixiaoxi) {
		this.shibaishifanhuixiaoxi = shibaishifanhuixiaoxi;
	}
	
	@Length(min=0, max=255, message="备注信息长度必须介于 0 和 255 之间")
	@ExcelField(title="备注信息", align=2, sort=7)
	public String getBeizhuxinxi() {
		return beizhuxinxi;
	}

	public void setBeizhuxinxi(String beizhuxinxi) {
		this.beizhuxinxi = beizhuxinxi;
	}
	
}