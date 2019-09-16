/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.gok.entity.GokFapiaoCaiwu;
import com.jsite.modules.gok.dao.GokFapiaoCaiwuDao;

/**
 * 财务发票记录Service
 * @author 财务发票记录
 * @version 2019-04-08
 */
@Service
@Transactional(readOnly = true)
public class GokFapiaoCaiwuService extends CrudService<GokFapiaoCaiwuDao, GokFapiaoCaiwu> {

	@Autowired
	private  GokFapiaoCaiwuDao gokFapiaoCaiwuDao;
	public GokFapiaoCaiwu get(String id) {
		return super.get(id);
	}
	
	public List<GokFapiaoCaiwu> findList(GokFapiaoCaiwu gokFapiaoCaiwu) {
		return super.findList(gokFapiaoCaiwu);
	}
	
	public Page<GokFapiaoCaiwu> findPage(Page<GokFapiaoCaiwu> page, GokFapiaoCaiwu gokFapiaoCaiwu) {
		return super.findPage(page, gokFapiaoCaiwu);
	}
	
	@Transactional(readOnly = false)
	public void save(GokFapiaoCaiwu gokFapiaoCaiwu) {
		super.save(gokFapiaoCaiwu);
	}
	
	@Transactional(readOnly = false)
	public void delete(GokFapiaoCaiwu gokFapiaoCaiwu) {
		super.delete(gokFapiaoCaiwu);
	}

	public String findMaxXuhao(){
		return  gokFapiaoCaiwuDao.findMaxXuhao();
	}
	
}