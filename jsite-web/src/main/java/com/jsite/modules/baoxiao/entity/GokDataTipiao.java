/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.baoxiao.entity;

import com.jsite.common.utils.excel.annotation.ExcelField;
import org.hibernate.validator.constraints.Length;
import com.jsite.modules.sys.entity.Office;

import com.jsite.common.persistence.DataEntity;

/**
 * 替票报销Entity
 * @author 替票报销
 * @version 2019-03-21
 */
public class GokDataTipiao extends DataEntity<GokDataTipiao> {
	
	private static final long serialVersionUID = 1L;
	private String baoxiaoshijian;		// 报销时间
	private String baoxiaoren;		// 报销人
	private String tipiaoleibie;		// 替票类别
	private String tipiaojine;		// 替票金额
	private String baoxiaoleibie;		// 报销类别
	private String baoxiaojine;		// 报销金额
	private String fudaipingzhengshu;		// 附带凭证数
	private String beizhu;		// 备注
	private Office office;		// 归属部门
	
	public GokDataTipiao() {
		super();
	}

	public GokDataTipiao(String id){
		super(id);
	}
	@ExcelField(title="报销时间", align=2, sort=10)
	@Length(min=0, max=64, message="报销时间长度必须介于 0 和 64 之间")
	public String getBaoxiaoshijian() {
		return baoxiaoshijian;
	}

	public void setBaoxiaoshijian(String baoxiaoshijian) {
		this.baoxiaoshijian = baoxiaoshijian;
	}
	@ExcelField(title="报销人", align=2, sort=20)
	@Length(min=0, max=64, message="报销人长度必须介于 0 和 64 之间")
	public String getBaoxiaoren() {
		return baoxiaoren;
	}

	public void setBaoxiaoren(String baoxiaoren) {
		this.baoxiaoren = baoxiaoren;
	}
	@ExcelField(title="替票类别", align=2, sort=30)
	@Length(min=0, max=64, message="替票类别长度必须介于 0 和 64 之间")
	public String getTipiaoleibie() {
		return tipiaoleibie;
	}

	public void setTipiaoleibie(String tipiaoleibie) {
		this.tipiaoleibie = tipiaoleibie;
	}
	@ExcelField(title="替票金额", align=2, sort=40)
	@Length(min=0, max=255, message="替票金额长度必须介于 0 和 255 之间")
	public String getTipiaojine() {
		return tipiaojine;
	}

	public void setTipiaojine(String tipiaojine) {
		this.tipiaojine = tipiaojine;
	}
	@ExcelField(title="报销类别", align=2, sort=50)
	@Length(min=0, max=100, message="报销类别长度必须介于 0 和 100 之间")
	public String getBaoxiaoleibie() {
		return baoxiaoleibie;
	}

	public void setBaoxiaoleibie(String baoxiaoleibie) {
		this.baoxiaoleibie = baoxiaoleibie;
	}
	@ExcelField(title="报销金额", align=2, sort=60)
	@Length(min=0, max=255, message="报销金额长度必须介于 0 和 255 之间")
	public String getBaoxiaojine() {
		return baoxiaojine;
	}

	public void setBaoxiaojine(String baoxiaojine) {
		this.baoxiaojine = baoxiaojine;
	}
	@ExcelField(title="附带凭证张数", align=2, sort=70)
	@Length(min=0, max=255, message="附带凭证数长度必须介于 0 和 255 之间")
	public String getFudaipingzhengshu() {
		return fudaipingzhengshu;
	}

	public void setFudaipingzhengshu(String fudaipingzhengshu) {
		this.fudaipingzhengshu = fudaipingzhengshu;
	}
	@ExcelField(title="备注", align=2, sort=80)
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
}