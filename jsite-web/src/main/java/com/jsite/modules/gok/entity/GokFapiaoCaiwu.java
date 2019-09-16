/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.entity;

import org.hibernate.validator.constraints.Length;
import com.jsite.modules.sys.entity.Office;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 财务发票记录Entity
 * @author 财务发票记录
 * @version 2019-04-08
 */
public class GokFapiaoCaiwu extends DataEntity<GokFapiaoCaiwu> {
	
	private static final long serialVersionUID = 1L;
	private String xuhao;		// 序号
	private String riqi;		// 日期
	private String quyu;		// 区域
	private String baoxiaoren;		// 报销人
	private Office baoxiaorenbumen;		// 报销人部门
	private String tipiaoleibie;		// 替票类别
	private String tipiaojine;		// 替票金额
	private String feiyongmingxi;		// 费用明细
	private String shijijinemingxi;		// 实际金额明细
	private String shijibaoxiaoleibie;		// 实际报销类别
	private Office feiyongguishubumen;		// 费用归属部门
	private String xiangmuguishu;		// 项目归属
	private String jiekuan;		// 借款
	private String fapiaoleixing;		// 发票类型
	
	public GokFapiaoCaiwu() {
		super();
	}

	public GokFapiaoCaiwu(String id){
		super(id);
	}




	@Length(min=0, max=255, message="序号长度必须介于 0 和 255 之间")
	@ExcelField(title="序号", align=2, sort=1)
	public String getXuhao() {
		return xuhao;
	}

	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}
	
	@Length(min=0, max=255, message="日期长度必须介于 0 和 255 之间")
	@ExcelField(title="日期", align=2, sort=2)
	public String getRiqi() {
		return riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}
	
	@Length(min=0, max=255, message="区域长度必须介于 0 和 255 之间")
	@ExcelField(title="区域", align=2, sort=3)
	public String getQuyu() {
		return quyu;
	}

	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	
	@Length(min=0, max=255, message="报销人长度必须介于 0 和 255 之间")
	@ExcelField(title="报销人", align=2, sort=4)
	public String getBaoxiaoren() {
		return baoxiaoren;
	}

	public void setBaoxiaoren(String baoxiaoren) {
		this.baoxiaoren = baoxiaoren;
	}
	
	@ExcelField(title="报销人部门", align=2, sort=5)
	public Office getBaoxiaorenbumen() {
		return baoxiaorenbumen;
	}

	public void setBaoxiaorenbumen(Office baoxiaorenbumen) {
		this.baoxiaorenbumen = baoxiaorenbumen;
	}
	
	@Length(min=0, max=255, message="替票类别长度必须介于 0 和 255 之间")
	@ExcelField(title="替票类别", align=2, sort=6)
	public String getTipiaoleibie() {
		return tipiaoleibie;
	}

	public void setTipiaoleibie(String tipiaoleibie) {
		this.tipiaoleibie = tipiaoleibie;
	}
	
	@Length(min=0, max=255, message="替票金额长度必须介于 0 和 255 之间")
	@ExcelField(title="替票金额", align=2, sort=7)
	public String getTipiaojine() {
		return tipiaojine;
	}

	public void setTipiaojine(String tipiaojine) {
		this.tipiaojine = tipiaojine;
	}
	
	@Length(min=0, max=255, message="费用明细长度必须介于 0 和 255 之间")
	@ExcelField(title="费用明细", align=2, sort=8)
	public String getFeiyongmingxi() {
		return feiyongmingxi;
	}

	public void setFeiyongmingxi(String feiyongmingxi) {
		this.feiyongmingxi = feiyongmingxi;
	}
	
	@Length(min=0, max=255, message="实际金额明细长度必须介于 0 和 255 之间")
	@ExcelField(title="实际金额明细", align=2, sort=9)
	public String getShijijinemingxi() {
		return shijijinemingxi;
	}

	public void setShijijinemingxi(String shijijinemingxi) {
		this.shijijinemingxi = shijijinemingxi;
	}
	
	@Length(min=0, max=255, message="实际报销类别长度必须介于 0 和 255 之间")
	@ExcelField(title="实际报销类别", align=2, sort=10)
	public String getShijibaoxiaoleibie() {
		return shijibaoxiaoleibie;
	}

	public void setShijibaoxiaoleibie(String shijibaoxiaoleibie) {
		this.shijibaoxiaoleibie = shijibaoxiaoleibie;
	}
	
	@ExcelField(title="费用归属部门", align=2, sort=11)
	public Office getFeiyongguishubumen() {
		return feiyongguishubumen;
	}

	public void setFeiyongguishubumen(Office feiyongguishubumen) {
		this.feiyongguishubumen = feiyongguishubumen;
	}

	@ExcelField(title="项目归属", align=2, sort=12)
	@Length(min=0, max=64, message="项目归属长度必须介于 0 和 64 之间")
	public String getXiangmuguishu() {
		return xiangmuguishu;
	}

	public void setXiangmuguishu(String xiangmuguishu) {
		this.xiangmuguishu = xiangmuguishu;
	}

	
	@Length(min=0, max=255, message="借款长度必须介于 0 和 255 之间")
	@ExcelField(title="借款", align=2, sort=121)
	public String getJiekuan() {
		return jiekuan;
	}

	public void setJiekuan(String jiekuan) {
		this.jiekuan = jiekuan;
	}
	
	@Length(min=0, max=255, message="发票类型长度必须介于 0 和 255 之间")
	@ExcelField(title="发票类型", align=2, sort=131)
	public String getFapiaoleixing() {
		return fapiaoleixing;
	}

	public void setFapiaoleixing(String fapiaoleixing) {
		this.fapiaoleixing = fapiaoleixing;
	}
	
}