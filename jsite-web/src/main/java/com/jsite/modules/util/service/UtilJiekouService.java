/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.util.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.util.entity.UtilJiekou;
import com.jsite.modules.util.dao.UtilJiekouDao;

/**
 * 接口测试Service
 * @author 接口测试
 * @version 2019-04-03
 */
@Service
@Transactional(readOnly = true)
public class UtilJiekouService extends CrudService<UtilJiekouDao, UtilJiekou> {

	public UtilJiekou get(String id) {
		return super.get(id);
	}
	
	public List<UtilJiekou> findList(UtilJiekou utilJiekou) {
		return super.findList(utilJiekou);
	}
	
	public Page<UtilJiekou> findPage(Page<UtilJiekou> page, UtilJiekou utilJiekou) {
		return super.findPage(page, utilJiekou);
	}
	
	@Transactional(readOnly = false)
	public void save(UtilJiekou utilJiekou) {
		super.save(utilJiekou);
	}
	
	@Transactional(readOnly = false)
	public void delete(UtilJiekou utilJiekou) {
		super.delete(utilJiekou);
	}
	
}