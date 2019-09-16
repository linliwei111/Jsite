/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.stu.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 学生Entity
 * @author 学生
 * @version 2019-05-23
 */
public class Xuesheng extends DataEntity<Xuesheng> {
	
	private static final long serialVersionUID = 1L;
	private String kechengleibie;		// 课程类别
	private String kechengbianhao;		// 课程编号
	private String kechengmingcheng;		// 课程名称
	private String kaoshikaocha;		// 考试考查
	private String benzhuanyezhuyaokecheng;		// 本专业主要课程
	private String fuxiubenzhuanyekecheng;		// 辅修本专业课程
	private String xuefen;		// 学分
	private String xueshi;		// 学时
	
	public Xuesheng() {
		super();
	}

	public Xuesheng(String id){
		super(id);
	}

	@Length(min=0, max=255, message="课程类别长度必须介于 0 和 255 之间")
	@ExcelField(title="课程类别", align=2, sort=10)
	public String getKechengleibie() {
		return kechengleibie;
	}

	public void setKechengleibie(String kechengleibie) {
		this.kechengleibie = kechengleibie;
	}
	
	@Length(min=0, max=255, message="课程编号长度必须介于 0 和 255 之间")
	@ExcelField(title="课程编号", align=2, sort=20)
	public String getKechengbianhao() {
		return kechengbianhao;
	}

	public void setKechengbianhao(String kechengbianhao) {
		this.kechengbianhao = kechengbianhao;
	}
	
	@Length(min=0, max=255, message="课程名称长度必须介于 0 和 255 之间")
	@ExcelField(title="课程名称", align=2, sort=30)
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}

	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}
	
	@Length(min=0, max=255, message="考试考查长度必须介于 0 和 255 之间")
	@ExcelField(title="考试考查", align=2, sort=40)
	public String getKaoshikaocha() {
		return kaoshikaocha;
	}

	public void setKaoshikaocha(String kaoshikaocha) {
		this.kaoshikaocha = kaoshikaocha;
	}
	
	@Length(min=0, max=255, message="本专业主要课程长度必须介于 0 和 255 之间")
	@ExcelField(title="本专业主要课程", align=2, sort=50)
	public String getBenzhuanyezhuyaokecheng() {
		return benzhuanyezhuyaokecheng;
	}

	public void setBenzhuanyezhuyaokecheng(String benzhuanyezhuyaokecheng) {
		this.benzhuanyezhuyaokecheng = benzhuanyezhuyaokecheng;
	}
	
	@Length(min=0, max=255, message="辅修本专业课程长度必须介于 0 和 255 之间")
	@ExcelField(title="辅修本专业课程", align=2, sort=60)
	public String getFuxiubenzhuanyekecheng() {
		return fuxiubenzhuanyekecheng;
	}

	public void setFuxiubenzhuanyekecheng(String fuxiubenzhuanyekecheng) {
		this.fuxiubenzhuanyekecheng = fuxiubenzhuanyekecheng;
	}
	
	@Length(min=0, max=255, message="学分长度必须介于 0 和 255 之间")
	@ExcelField(title="学分", align=2, sort=70)
	public String getXuefen() {
		return xuefen;
	}

	public void setXuefen(String xuefen) {
		this.xuefen = xuefen;
	}
	
	@Length(min=0, max=255, message="学时长度必须介于 0 和 255 之间")
	@ExcelField(title="学时", align=2, sort=80)
	public String getXueshi() {
		return xueshi;
	}

	public void setXueshi(String xueshi) {
		this.xueshi = xueshi;
	}
	
}