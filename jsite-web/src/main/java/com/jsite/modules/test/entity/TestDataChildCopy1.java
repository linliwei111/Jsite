/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.jsite.common.persistence.DataEntity;
import com.jsite.common.utils.excel.annotation.ExcelField;

/**
 * 主子表生成测试Entity
 * @author liuruijun
 * @version 2019-04-09
 */
public class TestDataChildCopy1 extends DataEntity<TestDataChildCopy1> {
	
	private static final long serialVersionUID = 1L;
	private String testDataMainId;		// 业务主表ID 父类
	private String name;		// 名称
	
	public TestDataChildCopy1() {
		super();
	}

	public TestDataChildCopy1(String id){
		super(id);
	}

	public TestDataChildCopy1(TestDataMain testDataMainId){
		this.testDataMainId = testDataMainId.getId();
	}

	@Length(min=0, max=64, message="业务主表ID长度必须介于 0 和 64 之间")
	@ExcelField(title="业务主表ID", align=2, sort=1)
	public String getTestDataMainId() {
		return testDataMainId;
	}

	public void setTestDataMainId(TestDataMain testDataMainId) {
		this.testDataMainId = testDataMainId.getId();
	}
	
	@Length(min=0, max=100, message="名称长度必须介于 0 和 100 之间")
	@ExcelField(title="名称", align=2, sort=2)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}