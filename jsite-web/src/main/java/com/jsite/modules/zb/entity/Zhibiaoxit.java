/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.zb.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 指标系统Entity
 * @author 林鹏群
 * @version 2019-09-10
 */
public class Zhibiaoxit extends DataEntity<Zhibiaoxit> {

	private static final long serialVersionUID = 1L;
	private String xuhao;		// 序号
	private String tichushijian;		// 提出时间
	private String mokuaiyemian;		// 模块/页面
	private String xuqiumiaoshu;		// 需求描述
	private String youxianji;		// 优先级
	private String chulizhuangtai;		// 处理状态
	private String youjian;		// 邮件

	public Zhibiaoxit() {
		super();
	}

	public Zhibiaoxit(String id){
		super(id);
	}

	@Length(min=0, max=255, message="序号长度必须介于 0 和 255 之间")
	@ExcelField(title="序号", align=2, sort=10)
	public String getXuhao() {
		return xuhao;
	}

	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}

	@Length(min=0, max=255, message="提出时间长度必须介于 0 和 255 之间")
	@ExcelField(title="提出时间", align=2, sort=20)
	public String getTichushijian() {
		return tichushijian;
	}

	public void setTichushijian(String tichushijian) {
		this.tichushijian = tichushijian;
	}

	@Length(min=0, max=255, message="模块/页面长度必须介于 0 和 255 之间")
	@ExcelField(title="模块/页面", align=2, sort=30)
	public String getMokuaiyemian() {
		return mokuaiyemian;
	}

	public void setMokuaiyemian(String mokuaiyemian) {
		this.mokuaiyemian = mokuaiyemian;
	}

	@Length(min=0, max=255, message="需求描述长度必须介于 0 和 255 之间")
	@ExcelField(title="需求描述", align=2, sort=40)
	public String getXuqiumiaoshu() {
		return xuqiumiaoshu;
	}

	public void setXuqiumiaoshu(String xuqiumiaoshu) {
		this.xuqiumiaoshu = xuqiumiaoshu;
	}

	@Length(min=0, max=255, message="优先级长度必须介于 0 和 255 之间")
	@ExcelField(title="优先级", align=2, sort=50)
	public String getYouxianji() {
		return youxianji;
	}

	public void setYouxianji(String youxianji) {
		this.youxianji = youxianji;
	}

	@Length(min=0, max=255, message="处理状态长度必须介于 0 和 255 之间")
	@ExcelField(title="处理状态", align=2, sort=60)
	public String getChulizhuangtai() {
		return chulizhuangtai;
	}

	public void setChulizhuangtai(String chulizhuangtai) {
		this.chulizhuangtai = chulizhuangtai;
	}

	@Length(min=0, max=255, message="邮件长度必须介于 0 和 255 之间")
	@ExcelField(title="邮件", align=2, sort=70)
	public String getYoujian() {
		return youjian;
	}

	public void setYoujian(String youjian) {
		this.youjian = youjian;
	}

}
