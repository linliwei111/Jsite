/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 周报Entity
 * @author 周报
 * @version 2019-04-26
 */
public class Zhoubao extends DataEntity<Zhoubao> {
	
	private static final long serialVersionUID = 1L;
	private String bianhao;		// 编号
	private String biangengmiaoshu;		// 变更描述
	private String biangengyuanyin;		// 变更原因
	private String hetongcankao;		// 合同参考
	private String biangengleixing;		// 变更类型
	private String youxianshunxu;		// 优先顺序
	private String zhuangtai;		// 状态
	private String tichufang;		// 提出方
	private String tichuren;		// 提出人
	private String tichuriqi;		// 提出日期
	private String yingxiangdengji;		// 影响等级
	private String suoxuziyuan;		// 所需资源
	private String suoxurentian;		// 所需人天
	private String suoxuqitachengben;		// 所需其他成本
	private String zerenren;		// 责任人
	private String yujiwanchengriqi;		// 预计完成日期
	private String gongsishenpiyijianjiriqi;		// 公司审批意见及日期
	private String pizhunzhixingriqi;		// 批准执行日期
	private String kehuyijianjiriqi;		// 客户意见及日期
	private String biangengwenjianqianshuriqi;		// 变更文件签署日期
	
	public Zhoubao() {
		super();
	}

	public Zhoubao(String id){
		super(id);
	}

	@Length(min=0, max=255, message="编号长度必须介于 0 和 255 之间")
	@ExcelField(title="编号", align=2, sort=10)
	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	
	@Length(min=0, max=255, message="变更描述长度必须介于 0 和 255 之间")
	@ExcelField(title="变更描述", align=2, sort=20)
	public String getBiangengmiaoshu() {
		return biangengmiaoshu;
	}

	public void setBiangengmiaoshu(String biangengmiaoshu) {
		this.biangengmiaoshu = biangengmiaoshu;
	}
	
	@Length(min=0, max=255, message="变更原因长度必须介于 0 和 255 之间")
	@ExcelField(title="变更原因", align=2, sort=30)
	public String getBiangengyuanyin() {
		return biangengyuanyin;
	}

	public void setBiangengyuanyin(String biangengyuanyin) {
		this.biangengyuanyin = biangengyuanyin;
	}
	
	@Length(min=0, max=255, message="合同参考长度必须介于 0 和 255 之间")
	@ExcelField(title="合同参考", align=2, sort=40)
	public String getHetongcankao() {
		return hetongcankao;
	}

	public void setHetongcankao(String hetongcankao) {
		this.hetongcankao = hetongcankao;
	}
	
	@Length(min=0, max=255, message="变更类型长度必须介于 0 和 255 之间")
	@ExcelField(title="变更类型", align=2, sort=50)
	public String getBiangengleixing() {
		return biangengleixing;
	}

	public void setBiangengleixing(String biangengleixing) {
		this.biangengleixing = biangengleixing;
	}
	
	@Length(min=0, max=255, message="优先顺序长度必须介于 0 和 255 之间")
	@ExcelField(title="优先顺序", align=2, sort=60)
	public String getYouxianshunxu() {
		return youxianshunxu;
	}

	public void setYouxianshunxu(String youxianshunxu) {
		this.youxianshunxu = youxianshunxu;
	}
	
	@Length(min=0, max=255, message="状态长度必须介于 0 和 255 之间")
	@ExcelField(title="状态", align=2, sort=70)
	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	@Length(min=0, max=255, message="提出方长度必须介于 0 和 255 之间")
	@ExcelField(title="提出方", align=2, sort=80)
	public String getTichufang() {
		return tichufang;
	}

	public void setTichufang(String tichufang) {
		this.tichufang = tichufang;
	}
	
	@Length(min=0, max=255, message="提出人长度必须介于 0 和 255 之间")
	@ExcelField(title="提出人", align=2, sort=90)
	public String getTichuren() {
		return tichuren;
	}

	public void setTichuren(String tichuren) {
		this.tichuren = tichuren;
	}
	
	@Length(min=0, max=255, message="提出日期长度必须介于 0 和 255 之间")
	@ExcelField(title="提出日期", align=2, sort=100)
	public String getTichuriqi() {
		return tichuriqi;
	}

	public void setTichuriqi(String tichuriqi) {
		this.tichuriqi = tichuriqi;
	}
	
	@Length(min=0, max=255, message="影响等级长度必须介于 0 和 255 之间")
	@ExcelField(title="影响等级", align=2, sort=110)
	public String getYingxiangdengji() {
		return yingxiangdengji;
	}

	public void setYingxiangdengji(String yingxiangdengji) {
		this.yingxiangdengji = yingxiangdengji;
	}
	
	@Length(min=0, max=255, message="所需资源长度必须介于 0 和 255 之间")
	@ExcelField(title="所需资源", align=2, sort=120)
	public String getSuoxuziyuan() {
		return suoxuziyuan;
	}

	public void setSuoxuziyuan(String suoxuziyuan) {
		this.suoxuziyuan = suoxuziyuan;
	}
	
	@Length(min=0, max=255, message="所需人天长度必须介于 0 和 255 之间")
	@ExcelField(title="所需人天", align=2, sort=130)
	public String getSuoxurentian() {
		return suoxurentian;
	}

	public void setSuoxurentian(String suoxurentian) {
		this.suoxurentian = suoxurentian;
	}
	
	@Length(min=0, max=255, message="所需其他成本长度必须介于 0 和 255 之间")
	@ExcelField(title="所需其他成本", align=2, sort=140)
	public String getSuoxuqitachengben() {
		return suoxuqitachengben;
	}

	public void setSuoxuqitachengben(String suoxuqitachengben) {
		this.suoxuqitachengben = suoxuqitachengben;
	}
	
	@Length(min=0, max=255, message="责任人长度必须介于 0 和 255 之间")
	@ExcelField(title="责任人", align=2, sort=150)
	public String getZerenren() {
		return zerenren;
	}

	public void setZerenren(String zerenren) {
		this.zerenren = zerenren;
	}
	
	@Length(min=0, max=255, message="预计完成日期长度必须介于 0 和 255 之间")
	@ExcelField(title="预计完成日期", align=2, sort=160)
	public String getYujiwanchengriqi() {
		return yujiwanchengriqi;
	}

	public void setYujiwanchengriqi(String yujiwanchengriqi) {
		this.yujiwanchengriqi = yujiwanchengriqi;
	}
	
	@Length(min=0, max=255, message="公司审批意见及日期长度必须介于 0 和 255 之间")
	@ExcelField(title="公司审批意见及日期", align=2, sort=170)
	public String getGongsishenpiyijianjiriqi() {
		return gongsishenpiyijianjiriqi;
	}

	public void setGongsishenpiyijianjiriqi(String gongsishenpiyijianjiriqi) {
		this.gongsishenpiyijianjiriqi = gongsishenpiyijianjiriqi;
	}
	
	@Length(min=0, max=255, message="批准执行日期长度必须介于 0 和 255 之间")
	@ExcelField(title="批准执行日期", align=2, sort=180)
	public String getPizhunzhixingriqi() {
		return pizhunzhixingriqi;
	}

	public void setPizhunzhixingriqi(String pizhunzhixingriqi) {
		this.pizhunzhixingriqi = pizhunzhixingriqi;
	}
	
	@Length(min=0, max=255, message="客户意见及日期长度必须介于 0 和 255 之间")
	@ExcelField(title="客户意见及日期", align=2, sort=190)
	public String getKehuyijianjiriqi() {
		return kehuyijianjiriqi;
	}

	public void setKehuyijianjiriqi(String kehuyijianjiriqi) {
		this.kehuyijianjiriqi = kehuyijianjiriqi;
	}
	
	@Length(min=0, max=255, message="变更文件签署日期长度必须介于 0 和 255 之间")
	@ExcelField(title="变更文件签署日期", align=2, sort=200)
	public String getBiangengwenjianqianshuriqi() {
		return biangengwenjianqianshuriqi;
	}

	public void setBiangengwenjianqianshuriqi(String biangengwenjianqianshuriqi) {
		this.biangengwenjianqianshuriqi = biangengwenjianqianshuriqi;
	}
	
}