/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.gok.entity.Diancan;
import com.jsite.modules.gok.dao.DiancanDao;

/**
 * 点餐信息Service
 * @author 点餐信息
 * @version 2019-04-11
 */
@Service
@Transactional(readOnly = true)
public class DiancanService extends CrudService<DiancanDao, Diancan> {

	public Diancan get(String id) {
		return super.get(id);
	}
	
	public List<Diancan> findList(Diancan diancan) {
		return super.findList(diancan);
	}
	
	public Page<Diancan> findPage(Page<Diancan> page, Diancan diancan) {
		return super.findPage(page, diancan);
	}
	
	@Transactional(readOnly = false)
	public void save(Diancan diancan) {
		super.save(diancan);
	}
	
	@Transactional(readOnly = false)
	public void delete(Diancan diancan) {
		super.delete(diancan);
	}
	
}