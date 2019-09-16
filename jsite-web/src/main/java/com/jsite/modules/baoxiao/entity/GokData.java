/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.baoxiao.entity;

import com.jsite.common.utils.excel.annotation.ExcelField;
import org.hibernate.validator.constraints.Length;
import com.jsite.modules.sys.entity.Office;

import com.jsite.common.persistence.DataEntity;

/**
 * 有票报销Entiy
 * @author 有票报销
 * @version 2019-03-21
 */
public class GokData extends DataEntity<GokData> {
	
	private static final long serialVersionUID = 1L;
	private String xiangmuguishu;		// 项目归属
	private String baoxiaoshijian;		// 报销时间
	private String baoxiaoren;		// 报销人
	private String zhaiyao;		// 摘要
	private String baoxiaoleibie;		// 报销类别
	private String baoxiaojine;		// 报销金额
	private String beizhu;		// 备注
	private Office office;		// 归属部门
	
	public GokData() {
		super();
	}

	public GokData(String id){
		super(id);
	}


	@ExcelField(title="项目归属", align=2, sort=5)
	@Length(min=0, max=64, message="项目归属长度必须介于 0 和 64 之间")
	public String getXiangmuguishu() {
		return xiangmuguishu;
	}

	public void setXiangmuguishu(String xiangmuguishu) {
		this.xiangmuguishu = xiangmuguishu;
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
	@ExcelField(title="摘要", align=2, sort=30)
	@Length(min=0, max=255, message="摘要长度必须介于 0 和 255 之间")
	public String getZhaiyao() {
		return zhaiyao;
	}

	public void setZhaiyao(String zhaiyao) {
		this.zhaiyao = zhaiyao;
	}
	@ExcelField(title="报销类别", align=2, sort=40)
	@Length(min=0, max=100, message="报销类别长度必须介于 0 和 100 之间")
	public String getBaoxiaoleibie() {
		return baoxiaoleibie;
	}

	public void setBaoxiaoleibie(String baoxiaoleibie) {
		this.baoxiaoleibie = baoxiaoleibie;
	}
	@ExcelField(title="报销金额", align=2, sort=50)
	@Length(min=0, max=255, message="报销金额长度必须介于 0 和 255 之间")
	public String getBaoxiaojine() {
		return baoxiaojine;
	}

	public void setBaoxiaojine(String baoxiaojine) {
		this.baoxiaojine = baoxiaojine;
	}
	@ExcelField(title="备注", align=2, sort=60)
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@ExcelField(title="归属部门", align=2, sort=22)
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
}