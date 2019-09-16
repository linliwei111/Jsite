/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.gok.entity.Zhoubao;
import com.jsite.modules.gok.dao.ZhoubaoDao;

/**
 * 周报Service
 * @author 周报
 * @version 2019-04-26
 */
@Service
@Transactional(readOnly = true)
public class ZhoubaoService extends CrudService<ZhoubaoDao, Zhoubao> {

	public Zhoubao get(String id) {
		return super.get(id);
	}
	
	public List<Zhoubao> findList(Zhoubao zhoubao) {
		return super.findList(zhoubao);
	}
	
	public Page<Zhoubao> findPage(Page<Zhoubao> page, Zhoubao zhoubao) {
		return super.findPage(page, zhoubao);
	}
	
	@Transactional(readOnly = false)
	public void save(Zhoubao zhoubao) {
		super.save(zhoubao);
	}
	
	@Transactional(readOnly = false)
	public void delete(Zhoubao zhoubao) {
		super.delete(zhoubao);
	}
	
}