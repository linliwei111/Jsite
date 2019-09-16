/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.gok.entity.GokHrmianshi;
import com.jsite.modules.gok.dao.GokHrmianshiDao;

/**
 * 人事面试记录Service
 * @author 人事面试记录
 * @version 2019-04-13
 */
@Service
@Transactional(readOnly = true)
public class GokHrmianshiService extends CrudService<GokHrmianshiDao, GokHrmianshi> {

	public GokHrmianshi get(String id) {
		return super.get(id);
	}
	
	public List<GokHrmianshi> findList(GokHrmianshi gokHrmianshi) {
		return super.findList(gokHrmianshi);
	}
	
	public Page<GokHrmianshi> findPage(Page<GokHrmianshi> page, GokHrmianshi gokHrmianshi) {
		return super.findPage(page, gokHrmianshi);
	}
	
	@Transactional(readOnly = false)
	public void save(GokHrmianshi gokHrmianshi) {
		super.save(gokHrmianshi);
	}
	
	@Transactional(readOnly = false)
	public void delete(GokHrmianshi gokHrmianshi) {
		super.delete(gokHrmianshi);
	}
	
}