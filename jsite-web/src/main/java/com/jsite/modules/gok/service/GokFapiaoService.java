/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.gok.entity.GokFapiao;
import com.jsite.modules.gok.dao.GokFapiaoDao;

/**
 * 发票记录Service
 * @author 发票记录
 * @version 2019-04-03
 */
@Service
@Transactional(readOnly = true)
public class GokFapiaoService extends CrudService<GokFapiaoDao, GokFapiao> {

	public GokFapiao get(String id) {
		return super.get(id);
	}
	
	public List<GokFapiao> findList(GokFapiao gokFapiao) {
		return super.findList(gokFapiao);
	}
	
	public Page<GokFapiao> findPage(Page<GokFapiao> page, GokFapiao gokFapiao) {
		return super.findPage(page, gokFapiao);
	}
	
	@Transactional(readOnly = false)
	public void save(GokFapiao gokFapiao) {
		super.save(gokFapiao);
	}
	
	@Transactional(readOnly = false)
	public void delete(GokFapiao gokFapiao) {
		super.delete(gokFapiao);
	}
	
}