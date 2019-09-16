/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.entity;

import com.jsite.modules.sys.entity.Office;
import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 能力标签Entity
 * @author 能力标签
 * @version 2019-04-10
 */
public class Nenglibiaoqian extends DataEntity<Nenglibiaoqian> {
	
	private static final long serialVersionUID = 1L;
	private Office bumen;		// 部门
	private String xingming;		// 姓名
	private String dianhua;		// 电话
	private String jinengbiaoqian1;		// 技能标签1
	private String biaoqiandengji1;		// 标签等级1
	private String biaoqianbeizhu1;		// 标签备注1
	private String jinengbiaoqian2;		// 技能标签2
	private String biaoqiandengji2;		// 标签等级2
	private String biaoqianbeizhu2;		// 标签备注2
	private String jinengbiaoqian3;		// 技能标签3
	private String biaoqiandengji3;		// 标签等级3
	private String biaoqianbeizhu3;		// 标签备注3
	private String jinengbiaoqian4;		// 技能标签4
	private String biaoqiandengji4;		// 标签等级4
	private String biaoqianbeizhu4;		// 标签备注4
	
	public Nenglibiaoqian() {
		super();
	}

	public Nenglibiaoqian(String id){
		super(id);
	}

	@ExcelField(title="部门", align=2, sort=1)
	public Office getBumen() {
		return bumen;
	}

	public void setBumen(Office bumen) {
		this.bumen = bumen;
	}
	
	@Length(min=0, max=255, message="姓名长度必须介于 0 和 255 之间")
	@ExcelField(title="姓名", align=2, sort=2)
	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	@Length(min=0, max=255, message="电话长度必须介于 0 和 255 之间")
	@ExcelField(title="电话", align=2, sort=3)
	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	
	@Length(min=0, max=255, message="技能标签1长度必须介于 0 和 255 之间")
	@ExcelField(title="技能标签1", align=2, sort=4)
	public String getJinengbiaoqian1() {
		return jinengbiaoqian1;
	}

	public void setJinengbiaoqian1(String jinengbiaoqian1) {
		this.jinengbiaoqian1 = jinengbiaoqian1;
	}
	
	@Length(min=0, max=255, message="标签等级1长度必须介于 0 和 255 之间")
	@ExcelField(title="标签等级1", align=2, sort=5)
	public String getBiaoqiandengji1() {
		return biaoqiandengji1;
	}

	public void setBiaoqiandengji1(String biaoqiandengji1) {
		this.biaoqiandengji1 = biaoqiandengji1;
	}
	
	@Length(min=0, max=255, message="标签备注1长度必须介于 0 和 255 之间")
	@ExcelField(title="标签备注1", align=2, sort=6)
	public String getBiaoqianbeizhu1() {
		return biaoqianbeizhu1;
	}

	public void setBiaoqianbeizhu1(String biaoqianbeizhu1) {
		this.biaoqianbeizhu1 = biaoqianbeizhu1;
	}
	
	@Length(min=0, max=255, message="技能标签2长度必须介于 0 和 255 之间")
	@ExcelField(title="技能标签2", align=2, sort=7)
	public String getJinengbiaoqian2() {
		return jinengbiaoqian2;
	}

	public void setJinengbiaoqian2(String jinengbiaoqian2) {
		this.jinengbiaoqian2 = jinengbiaoqian2;
	}
	
	@Length(min=0, max=255, message="标签等级2长度必须介于 0 和 255 之间")
	@ExcelField(title="标签等级2", align=2, sort=8)
	public String getBiaoqiandengji2() {
		return biaoqiandengji2;
	}

	public void setBiaoqiandengji2(String biaoqiandengji2) {
		this.biaoqiandengji2 = biaoqiandengji2;
	}
	
	@Length(min=0, max=255, message="标签备注2长度必须介于 0 和 255 之间")
	@ExcelField(title="标签备注2", align=2, sort=9)
	public String getBiaoqianbeizhu2() {
		return biaoqianbeizhu2;
	}

	public void setBiaoqianbeizhu2(String biaoqianbeizhu2) {
		this.biaoqianbeizhu2 = biaoqianbeizhu2;
	}
	
	@Length(min=0, max=255, message="技能标签3长度必须介于 0 和 255 之间")
	@ExcelField(title="技能标签3", align=2, sort=10)
	public String getJinengbiaoqian3() {
		return jinengbiaoqian3;
	}

	public void setJinengbiaoqian3(String jinengbiaoqian3) {
		this.jinengbiaoqian3 = jinengbiaoqian3;
	}
	
	@Length(min=0, max=255, message="标签等级3长度必须介于 0 和 255 之间")
	@ExcelField(title="标签等级3", align=2, sort=11)
	public String getBiaoqiandengji3() {
		return biaoqiandengji3;
	}

	public void setBiaoqiandengji3(String biaoqiandengji3) {
		this.biaoqiandengji3 = biaoqiandengji3;
	}
	
	@Length(min=0, max=255, message="标签备注3长度必须介于 0 和 255 之间")
	@ExcelField(title="标签备注3", align=2, sort=12)
	public String getBiaoqianbeizhu3() {
		return biaoqianbeizhu3;
	}

	public void setBiaoqianbeizhu3(String biaoqianbeizhu3) {
		this.biaoqianbeizhu3 = biaoqianbeizhu3;
	}
	
	@Length(min=0, max=255, message="技能标签4长度必须介于 0 和 255 之间")
	@ExcelField(title="技能标签4", align=2, sort=13)
	public String getJinengbiaoqian4() {
		return jinengbiaoqian4;
	}

	public void setJinengbiaoqian4(String jinengbiaoqian4) {
		this.jinengbiaoqian4 = jinengbiaoqian4;
	}
	
	@Length(min=0, max=255, message="标签等级4长度必须介于 0 和 255 之间")
	@ExcelField(title="标签等级4", align=2, sort=14)
	public String getBiaoqiandengji4() {
		return biaoqiandengji4;
	}

	public void setBiaoqiandengji4(String biaoqiandengji4) {
		this.biaoqiandengji4 = biaoqiandengji4;
	}
	
	@Length(min=0, max=255, message="标签备注4长度必须介于 0 和 255 之间")
	@ExcelField(title="标签备注4", align=2, sort=15)
	public String getBiaoqianbeizhu4() {
		return biaoqianbeizhu4;
	}

	public void setBiaoqianbeizhu4(String biaoqianbeizhu4) {
		this.biaoqianbeizhu4 = biaoqianbeizhu4;
	}
	
}