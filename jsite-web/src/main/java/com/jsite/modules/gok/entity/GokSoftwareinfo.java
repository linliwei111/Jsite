/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 软件信息Entity
 * @author 软件信息
 * @version 2019-04-13
 */
public class GokSoftwareinfo extends DataEntity<GokSoftwareinfo> {
	
	private static final long serialVersionUID = 1L;
	private String ruanjianmingcheng;		// 软件名称
	private String ruanjianleixing;		// 软件类型
	private String weihuren;		// 维护人
	private String waibudizhi;		// 外部地址
	private String neibudizhi;		// 内部地址
	private String fuwuqidizhi;		// 服务器地址
	private String zhanghao;		// 账号
	private String mima;		// 密码
	private String xiangmuyongtu;		// 项目用途
	private String xiangmujiafang;		// 项目甲方
	private String cunyouyuanma;		// 存有源码
	private String kuozhan1;		// 扩展1
	private String kuozhan2;		// 扩展2
	private String kuozhan3;		// 扩展3
	private String kuozhan4;		// 扩展4
	private String xiangmuguishu;		// 项目归属
	
	public GokSoftwareinfo() {
		super();
	}

	public GokSoftwareinfo(String id){
		super(id);
	}

	@Length(min=0, max=255, message="软件名称长度必须介于 0 和 255 之间")
	@ExcelField(title="软件名称", align=2, sort=1)
	public String getRuanjianmingcheng() {
		return ruanjianmingcheng;
	}

	public void setRuanjianmingcheng(String ruanjianmingcheng) {
		this.ruanjianmingcheng = ruanjianmingcheng;
	}
	
	@Length(min=0, max=255, message="软件类型长度必须介于 0 和 255 之间")
	@ExcelField(title="软件类型", align=2, sort=2)
	public String getRuanjianleixing() {
		return ruanjianleixing;
	}

	public void setRuanjianleixing(String ruanjianleixing) {
		this.ruanjianleixing = ruanjianleixing;
	}
	
	@Length(min=0, max=255, message="维护人长度必须介于 0 和 255 之间")
	@ExcelField(title="维护人", align=2, sort=3)
	public String getWeihuren() {
		return weihuren;
	}

	public void setWeihuren(String weihuren) {
		this.weihuren = weihuren;
	}
	
	@Length(min=0, max=255, message="外部地址长度必须介于 0 和 255 之间")
	@ExcelField(title="外部地址", align=2, sort=4)
	public String getWaibudizhi() {
		return waibudizhi;
	}

	public void setWaibudizhi(String waibudizhi) {
		this.waibudizhi = waibudizhi;
	}
	
	@Length(min=0, max=255, message="内部地址长度必须介于 0 和 255 之间")
	@ExcelField(title="内部地址", align=2, sort=5)
	public String getNeibudizhi() {
		return neibudizhi;
	}

	public void setNeibudizhi(String neibudizhi) {
		this.neibudizhi = neibudizhi;
	}
	
	@Length(min=0, max=255, message="服务器地址长度必须介于 0 和 255 之间")
	@ExcelField(title="服务器地址", align=2, sort=6)
	public String getFuwuqidizhi() {
		return fuwuqidizhi;
	}

	public void setFuwuqidizhi(String fuwuqidizhi) {
		this.fuwuqidizhi = fuwuqidizhi;
	}
	
	@Length(min=0, max=255, message="账号长度必须介于 0 和 255 之间")
	@ExcelField(title="账号", align=2, sort=7)
	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	@Length(min=0, max=255, message="密码长度必须介于 0 和 255 之间")
	@ExcelField(title="密码", align=2, sort=8)
	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}
	
	@Length(min=0, max=255, message="项目用途长度必须介于 0 和 255 之间")
	@ExcelField(title="项目用途", align=2, sort=9)
	public String getXiangmuyongtu() {
		return xiangmuyongtu;
	}

	public void setXiangmuyongtu(String xiangmuyongtu) {
		this.xiangmuyongtu = xiangmuyongtu;
	}
	
	@Length(min=0, max=255, message="项目甲方长度必须介于 0 和 255 之间")
	@ExcelField(title="项目甲方", align=2, sort=10)
	public String getXiangmujiafang() {
		return xiangmujiafang;
	}

	public void setXiangmujiafang(String xiangmujiafang) {
		this.xiangmujiafang = xiangmujiafang;
	}
	
	@Length(min=0, max=255, message="存有源码长度必须介于 0 和 255 之间")
	@ExcelField(title="存有源码", align=2, sort=11)
	public String getCunyouyuanma() {
		return cunyouyuanma;
	}

	public void setCunyouyuanma(String cunyouyuanma) {
		this.cunyouyuanma = cunyouyuanma;
	}
	
	@Length(min=0, max=255, message="扩展1长度必须介于 0 和 255 之间")
	@ExcelField(title="扩展1", align=2, sort=12)
	public String getKuozhan1() {
		return kuozhan1;
	}

	public void setKuozhan1(String kuozhan1) {
		this.kuozhan1 = kuozhan1;
	}
	
	@Length(min=0, max=255, message="扩展2长度必须介于 0 和 255 之间")
	@ExcelField(title="扩展2", align=2, sort=13)
	public String getKuozhan2() {
		return kuozhan2;
	}

	public void setKuozhan2(String kuozhan2) {
		this.kuozhan2 = kuozhan2;
	}
	
	@Length(min=0, max=255, message="扩展3长度必须介于 0 和 255 之间")
	@ExcelField(title="扩展3", align=2, sort=14)
	public String getKuozhan3() {
		return kuozhan3;
	}

	public void setKuozhan3(String kuozhan3) {
		this.kuozhan3 = kuozhan3;
	}
	
	@Length(min=0, max=255, message="扩展4长度必须介于 0 和 255 之间")
	@ExcelField(title="扩展4", align=2, sort=15)
	public String getKuozhan4() {
		return kuozhan4;
	}

	public void setKuozhan4(String kuozhan4) {
		this.kuozhan4 = kuozhan4;
	}
	
	@Length(min=0, max=255, message="项目归属长度必须介于 0 和 255 之间")
	@ExcelField(title="项目归属", align=2, sort=16)
	public String getXiangmuguishu() {
		return xiangmuguishu;
	}

	public void setXiangmuguishu(String xiangmuguishu) {
		this.xiangmuguishu = xiangmuguishu;
	}
	
}