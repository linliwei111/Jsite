/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 发票记录Entity
 * @author 发票记录
 * @version 2019-04-03
 */
public class GokFapiao extends DataEntity<GokFapiao> {
	
	private static final long serialVersionUID = 1L;
	private String baoxiaoren;		// 报销人
	private String baoxiaoshijian;		// 报销时间
	private String fapiaodaima;		// 发票代码
	private String fapiaohaoma;		// 发票号码
	private String baoxiaojine;		// 报销金额
	
	public GokFapiao() {
		super();
	}

	public GokFapiao(String id){
		super(id);
	}

	@Length(min=0, max=255, message="报销人长度必须介于 0 和 255 之间")
	@ExcelField(title="报销人", align=2, sort=1)
	public String getBaoxiaoren() {
		return baoxiaoren;
	}

	public void setBaoxiaoren(String baoxiaoren) {
		this.baoxiaoren = baoxiaoren;
	}
	
	@Length(min=0, max=255, message="报销时间长度必须介于 0 和 255 之间")
	@ExcelField(title="报销时间", align=2, sort=2)
	public String getBaoxiaoshijian() {
		return baoxiaoshijian;
	}

	public void setBaoxiaoshijian(String baoxiaoshijian) {
		this.baoxiaoshijian = baoxiaoshijian;
	}
	
	@Length(min=0, max=255, message="发票代码长度必须介于 0 和 255 之间")
	@ExcelField(title="发票代码", align=2, sort=3)
	public String getFapiaodaima() {
		return fapiaodaima;
	}

	public void setFapiaodaima(String fapiaodaima) {
		this.fapiaodaima = fapiaodaima;
	}
	
	@Length(min=0, max=255, message="发票号码长度必须介于 0 和 255 之间")
	@ExcelField(title="发票号码", align=2, sort=4)
	public String getFapiaohaoma() {
		return fapiaohaoma;
	}

	public void setFapiaohaoma(String fapiaohaoma) {
		this.fapiaohaoma = fapiaohaoma;
	}
	
	@Length(min=0, max=255, message="报销金额长度必须介于 0 和 255 之间")
	@ExcelField(title="报销金额", align=2, sort=5)
	public String getBaoxiaojine() {
		return baoxiaojine;
	}

	public void setBaoxiaojine(String baoxiaojine) {
		this.baoxiaojine = baoxiaojine;
	}
	
}