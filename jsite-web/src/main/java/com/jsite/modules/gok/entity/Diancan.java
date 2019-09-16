/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 点餐信息Entity
 * @author 点餐信息
 * @version 2019-04-11
 */
public class Diancan extends DataEntity<Diancan> {
	
	private static final long serialVersionUID = 1L;
	private String yonghuming;		// 用户名
	private String shoujihao;		// 手机号
	private String bumen;		// 部门
	private String yunxingzhi;		// 运行值
	private String zaocan;		// 早餐
	private String wucan;		// 午餐
	private String wancan;		// 晚餐
	private String yexiao;		// 夜宵
	
	public Diancan() {
		super();
	}

	public Diancan(String id){
		super(id);
	}

	@Length(min=0, max=255, message="用户名长度必须介于 0 和 255 之间")
	@ExcelField(title="用户名", align=2, sort=1)
	public String getYonghuming() {
		return yonghuming;
	}

	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	@Length(min=0, max=255, message="手机号长度必须介于 0 和 255 之间")
	@ExcelField(title="手机号", align=2, sort=2)
	public String getShoujihao() {
		return shoujihao;
	}

	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	
	@Length(min=0, max=255, message="部门长度必须介于 0 和 255 之间")
	@ExcelField(title="部门", align=2, sort=3)
	public String getBumen() {
		return bumen;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	
	@Length(min=0, max=255, message="运行值长度必须介于 0 和 255 之间")
	@ExcelField(title="运行值", align=2, sort=4)
	public String getYunxingzhi() {
		return yunxingzhi;
	}

	public void setYunxingzhi(String yunxingzhi) {
		this.yunxingzhi = yunxingzhi;
	}
	
	@Length(min=0, max=255, message="早餐长度必须介于 0 和 255 之间")
	@ExcelField(title="早餐", align=2, sort=5)
	public String getZaocan() {
		return zaocan;
	}

	public void setZaocan(String zaocan) {
		this.zaocan = zaocan;
	}
	
	@Length(min=0, max=255, message="午餐长度必须介于 0 和 255 之间")
	@ExcelField(title="午餐", align=2, sort=6)
	public String getWucan() {
		return wucan;
	}

	public void setWucan(String wucan) {
		this.wucan = wucan;
	}
	
	@Length(min=0, max=255, message="晚餐长度必须介于 0 和 255 之间")
	@ExcelField(title="晚餐", align=2, sort=7)
	public String getWancan() {
		return wancan;
	}

	public void setWancan(String wancan) {
		this.wancan = wancan;
	}
	
	@Length(min=0, max=255, message="夜宵长度必须介于 0 和 255 之间")
	@ExcelField(title="夜宵", align=2, sort=8)
	public String getYexiao() {
		return yexiao;
	}

	public void setYexiao(String yexiao) {
		this.yexiao = yexiao;
	}
	
}