/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 学生信息Entity
 * @author 学生信息
 * @version 2019-03-28
 */
public class GokStudent extends DataEntity<GokStudent> {
	
	private static final long serialVersionUID = 1L;
	private String xuhao;		// 序号
	private String baomingshijian;		// 报名时间
	private String xingming;		// 姓名
	private String shenfenzheng;		// 身份证
	private String xuexiao;		// 学校
	private String nianji;		// 年级
	private String zhuanye;		// 专业
	private String sushelou;		// 宿舍楼
	private String shoujihaoma;		// 手机号码
	private String qq;		// QQ
	private String xingbie;		// 性别
	private String taocan;		// 套餐
	private String shengri;		// 生日
	private String hujisuozaidi;		// 户籍所在地
	private String shichangchengjiaorenyuan;		// 市场成交人员
	private String shifousongshu;		// 是否送书
	private String lingshujilu;		// 领书记录
	private String yishangkecheng;		// 已上课程
	private String zhengzaishangkecheng;		// 正在上课程
	private String beizhu;		// 备注
	
	public GokStudent() {
		super();
	}

	public GokStudent(String id){
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
	
	@Length(min=0, max=255, message="报名时间长度必须介于 0 和 255 之间")
	@ExcelField(title="报名时间", align=2, sort=2)
	public String getBaomingshijian() {
		return baomingshijian;
	}

	public void setBaomingshijian(String baomingshijian) {
		this.baomingshijian = baomingshijian;
	}
	
	@Length(min=0, max=255, message="姓名长度必须介于 0 和 255 之间")
	@ExcelField(title="姓名", align=2, sort=3)
	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	@Length(min=0, max=255, message="身份证长度必须介于 0 和 255 之间")
	@ExcelField(title="身份证", align=2, sort=4)
	public String getShenfenzheng() {
		return shenfenzheng;
	}

	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	
	@Length(min=0, max=255, message="学校长度必须介于 0 和 255 之间")
	@ExcelField(title="学校", align=2, sort=5)
	public String getXuexiao() {
		return xuexiao;
	}

	public void setXuexiao(String xuexiao) {
		this.xuexiao = xuexiao;
	}
	
	@Length(min=0, max=255, message="年级长度必须介于 0 和 255 之间")
	@ExcelField(title="年级", align=2, sort=6)
	public String getNianji() {
		return nianji;
	}

	public void setNianji(String nianji) {
		this.nianji = nianji;
	}
	
	@Length(min=0, max=255, message="专业长度必须介于 0 和 255 之间")
	@ExcelField(title="专业", align=2, sort=7)
	public String getZhuanye() {
		return zhuanye;
	}

	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	
	@Length(min=0, max=255, message="宿舍楼长度必须介于 0 和 255 之间")
	@ExcelField(title="宿舍楼", align=2, sort=8)
	public String getSushelou() {
		return sushelou;
	}

	public void setSushelou(String sushelou) {
		this.sushelou = sushelou;
	}
	
	@Length(min=0, max=255, message="手机号码长度必须介于 0 和 255 之间")
	@ExcelField(title="手机号码", align=2, sort=9)
	public String getShoujihaoma() {
		return shoujihaoma;
	}

	public void setShoujihaoma(String shoujihaoma) {
		this.shoujihaoma = shoujihaoma;
	}
	
	@Length(min=0, max=255, message="QQ长度必须介于 0 和 255 之间")
	@ExcelField(title="QQ", align=2, sort=10)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Length(min=0, max=255, message="性别长度必须介于 0 和 255 之间")
	@ExcelField(title="性别", align=2, sort=11)
	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	@Length(min=0, max=255, message="套餐长度必须介于 0 和 255 之间")
	@ExcelField(title="套餐", align=2, sort=12)
	public String getTaocan() {
		return taocan;
	}

	public void setTaocan(String taocan) {
		this.taocan = taocan;
	}
	
	@Length(min=0, max=255, message="生日长度必须介于 0 和 255 之间")
	@ExcelField(title="生日", align=2, sort=13)
	public String getShengri() {
		return shengri;
	}

	public void setShengri(String shengri) {
		this.shengri = shengri;
	}
	
	@Length(min=0, max=255, message="户籍所在地长度必须介于 0 和 255 之间")
	@ExcelField(title="户籍所在地", align=2, sort=14)
	public String getHujisuozaidi() {
		return hujisuozaidi;
	}

	public void setHujisuozaidi(String hujisuozaidi) {
		this.hujisuozaidi = hujisuozaidi;
	}
	
	@Length(min=0, max=255, message="市场成交人员长度必须介于 0 和 255 之间")
	@ExcelField(title="市场成交人员", align=2, sort=15)
	public String getShichangchengjiaorenyuan() {
		return shichangchengjiaorenyuan;
	}

	public void setShichangchengjiaorenyuan(String shichangchengjiaorenyuan) {
		this.shichangchengjiaorenyuan = shichangchengjiaorenyuan;
	}
	
	@Length(min=0, max=255, message="是否送书长度必须介于 0 和 255 之间")
	@ExcelField(title="是否送书", align=2, sort=16)
	public String getShifousongshu() {
		return shifousongshu;
	}

	public void setShifousongshu(String shifousongshu) {
		this.shifousongshu = shifousongshu;
	}
	
	@Length(min=0, max=255, message="领书记录长度必须介于 0 和 255 之间")
	@ExcelField(title="领书记录", align=2, sort=17)
	public String getLingshujilu() {
		return lingshujilu;
	}

	public void setLingshujilu(String lingshujilu) {
		this.lingshujilu = lingshujilu;
	}
	
	@Length(min=0, max=255, message="已上课程长度必须介于 0 和 255 之间")
	@ExcelField(title="已上课程", align=2, sort=18)
	public String getYishangkecheng() {
		return yishangkecheng;
	}

	public void setYishangkecheng(String yishangkecheng) {
		this.yishangkecheng = yishangkecheng;
	}
	
	@Length(min=0, max=255, message="正在上课程长度必须介于 0 和 255 之间")
	@ExcelField(title="正在上课程", align=2, sort=19)
	public String getZhengzaishangkecheng() {
		return zhengzaishangkecheng;
	}

	public void setZhengzaishangkecheng(String zhengzaishangkecheng) {
		this.zhengzaishangkecheng = zhengzaishangkecheng;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	@ExcelField(title="备注", align=2, sort=20)
	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}