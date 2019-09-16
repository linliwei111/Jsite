/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.gok.entity.Nenglibiaoqian;
import com.jsite.modules.gok.dao.NenglibiaoqianDao;

/**
 * 能力标签Service
 * @author 能力标签
 * @version 2019-04-10
 */
@Service
@Transactional(readOnly = true)
public class NenglibiaoqianService extends CrudService<NenglibiaoqianDao, Nenglibiaoqian> {

	public Nenglibiaoqian get(String id) {
		return super.get(id);
	}
	
	public List<Nenglibiaoqian> findList(Nenglibiaoqian nenglibiaoqian) {
		return super.findList(nenglibiaoqian);
	}
	
	public Page<Nenglibiaoqian> findPage(Page<Nenglibiaoqian> page, Nenglibiaoqian nenglibiaoqian) {
		return super.findPage(page, nenglibiaoqian);
	}
	
	@Transactional(readOnly = false)
	public void save(Nenglibiaoqian nenglibiaoqian) {
		super.save(nenglibiaoqian);
	}
	
	@Transactional(readOnly = false)
	public void delete(Nenglibiaoqian nenglibiaoqian) {
		super.delete(nenglibiaoqian);
	}
	
}