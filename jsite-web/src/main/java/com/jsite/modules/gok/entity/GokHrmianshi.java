/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 人事面试记录Entity
 * @author 人事面试记录
 * @version 2019-04-13
 */
public class GokHrmianshi extends DataEntity<GokHrmianshi> {
	
	private static final long serialVersionUID = 1L;
	private String goutongshijian;		// 沟通时间
	private String xingming;		// 姓名
	private String xueli;		// 学历
	private String biyeyuanxiao;		// 毕业院校
	private String zhuanye;		// 专业
	private String biyeshijian;		// 毕业时间
	private String gongzuonianxian;		// 工作年限
	private String qiuzhigangwei;		// 求职岗位
	private String xinziyaoqiu;		// 薪资要求
	private String lianxifangshi;		// 联系方式
	private String dangqianzhuangtai;		// 当前状态
	private String qitayaoqiu;		// 其他要求
	private String shifoujieshouzhudian;		// 是否接受驻点
	private String kezhudianquyu;		// 可驻点区域
	private String yaoyueqingkuang;		// 邀约情况
	private String tuijianqiye;		// 推荐企业
	private String yujidaogangshijian;		// 预计到岗时间
	private String mianshijieguo;		// 面试结果
	private String qitashuoming;		// 其他说明
	
	public GokHrmianshi() {
		super();
	}

	public GokHrmianshi(String id){
		super(id);
	}

	@Length(min=0, max=255, message="沟通时间长度必须介于 0 和 255 之间")
	@ExcelField(title="沟通时间", align=2, sort=1)
	public String getGoutongshijian() {
		return goutongshijian;
	}

	public void setGoutongshijian(String goutongshijian) {
		this.goutongshijian = goutongshijian;
	}
	
	@Length(min=0, max=255, message="姓名长度必须介于 0 和 255 之间")
	@ExcelField(title="姓名", align=2, sort=2)
	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	@Length(min=0, max=255, message="学历长度必须介于 0 和 255 之间")
	@ExcelField(title="学历", align=2, sort=3)
	public String getXueli() {
		return xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	
	@Length(min=0, max=255, message="毕业院校长度必须介于 0 和 255 之间")
	@ExcelField(title="毕业院校", align=2, sort=4)
	public String getBiyeyuanxiao() {
		return biyeyuanxiao;
	}

	public void setBiyeyuanxiao(String biyeyuanxiao) {
		this.biyeyuanxiao = biyeyuanxiao;
	}
	
	@Length(min=0, max=255, message="专业长度必须介于 0 和 255 之间")
	@ExcelField(title="专业", align=2, sort=5)
	public String getZhuanye() {
		return zhuanye;
	}

	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	
	@Length(min=0, max=255, message="毕业时间长度必须介于 0 和 255 之间")
	@ExcelField(title="毕业时间", align=2, sort=6)
	public String getBiyeshijian() {
		return biyeshijian;
	}

	public void setBiyeshijian(String biyeshijian) {
		this.biyeshijian = biyeshijian;
	}
	
	@Length(min=0, max=255, message="工作年限长度必须介于 0 和 255 之间")
	@ExcelField(title="工作年限", align=2, sort=7)
	public String getGongzuonianxian() {
		return gongzuonianxian;
	}

	public void setGongzuonianxian(String gongzuonianxian) {
		this.gongzuonianxian = gongzuonianxian;
	}
	
	@Length(min=0, max=255, message="求职岗位长度必须介于 0 和 255 之间")
	@ExcelField(title="求职岗位", align=2, sort=8)
	public String getQiuzhigangwei() {
		return qiuzhigangwei;
	}

	public void setQiuzhigangwei(String qiuzhigangwei) {
		this.qiuzhigangwei = qiuzhigangwei;
	}
	
	@Length(min=0, max=255, message="薪资要求长度必须介于 0 和 255 之间")
	@ExcelField(title="薪资要求", align=2, sort=9)
	public String getXinziyaoqiu() {
		return xinziyaoqiu;
	}

	public void setXinziyaoqiu(String xinziyaoqiu) {
		this.xinziyaoqiu = xinziyaoqiu;
	}
	
	@Length(min=0, max=255, message="联系方式长度必须介于 0 和 255 之间")
	@ExcelField(title="联系方式", align=2, sort=10)
	public String getLianxifangshi() {
		return lianxifangshi;
	}

	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	@Length(min=0, max=255, message="当前状态长度必须介于 0 和 255 之间")
	@ExcelField(title="当前状态", align=2, sort=11)
	public String getDangqianzhuangtai() {
		return dangqianzhuangtai;
	}

	public void setDangqianzhuangtai(String dangqianzhuangtai) {
		this.dangqianzhuangtai = dangqianzhuangtai;
	}
	
	@Length(min=0, max=255, message="其他要求长度必须介于 0 和 255 之间")
	@ExcelField(title="其他要求", align=2, sort=12)
	public String getQitayaoqiu() {
		return qitayaoqiu;
	}

	public void setQitayaoqiu(String qitayaoqiu) {
		this.qitayaoqiu = qitayaoqiu;
	}
	
	@Length(min=0, max=255, message="是否接受驻点长度必须介于 0 和 255 之间")
	@ExcelField(title="是否接受驻点", align=2, sort=13)
	public String getShifoujieshouzhudian() {
		return shifoujieshouzhudian;
	}

	public void setShifoujieshouzhudian(String shifoujieshouzhudian) {
		this.shifoujieshouzhudian = shifoujieshouzhudian;
	}
	
	@Length(min=0, max=255, message="可驻点区域长度必须介于 0 和 255 之间")
	@ExcelField(title="可驻点区域", align=2, sort=14)
	public String getKezhudianquyu() {
		return kezhudianquyu;
	}

	public void setKezhudianquyu(String kezhudianquyu) {
		this.kezhudianquyu = kezhudianquyu;
	}
	
	@Length(min=0, max=255, message="邀约情况长度必须介于 0 和 255 之间")
	@ExcelField(title="邀约情况", align=2, sort=15)
	public String getYaoyueqingkuang() {
		return yaoyueqingkuang;
	}

	public void setYaoyueqingkuang(String yaoyueqingkuang) {
		this.yaoyueqingkuang = yaoyueqingkuang;
	}
	
	@Length(min=0, max=255, message="推荐企业长度必须介于 0 和 255 之间")
	@ExcelField(title="推荐企业", align=2, sort=16)
	public String getTuijianqiye() {
		return tuijianqiye;
	}

	public void setTuijianqiye(String tuijianqiye) {
		this.tuijianqiye = tuijianqiye;
	}
	
	@Length(min=0, max=255, message="预计到岗时间长度必须介于 0 和 255 之间")
	@ExcelField(title="预计到岗时间", align=2, sort=17)
	public String getYujidaogangshijian() {
		return yujidaogangshijian;
	}

	public void setYujidaogangshijian(String yujidaogangshijian) {
		this.yujidaogangshijian = yujidaogangshijian;
	}
	
	@Length(min=0, max=255, message="面试结果长度必须介于 0 和 255 之间")
	@ExcelField(title="面试结果", align=2, sort=18)
	public String getMianshijieguo() {
		return mianshijieguo;
	}

	public void setMianshijieguo(String mianshijieguo) {
		this.mianshijieguo = mianshijieguo;
	}
	
	@Length(min=0, max=255, message="其他说明长度必须介于 0 和 255 之间")
	@ExcelField(title="其他说明", align=2, sort=19)
	public String getQitashuoming() {
		return qitashuoming;
	}

	public void setQitashuoming(String qitashuoming) {
		this.qitashuoming = qitashuoming;
	}
	
}