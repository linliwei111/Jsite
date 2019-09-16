/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.gok.entity.GokSoftwareinfo;
import com.jsite.modules.gok.dao.GokSoftwareinfoDao;

/**
 * 软件信息Service
 * @author 软件信息
 * @version 2019-04-13
 */
@Service
@Transactional(readOnly = true)
public class GokSoftwareinfoService extends CrudService<GokSoftwareinfoDao, GokSoftwareinfo> {

	public GokSoftwareinfo get(String id) {
		return super.get(id);
	}
	
	public List<GokSoftwareinfo> findList(GokSoftwareinfo gokSoftwareinfo) {
		return super.findList(gokSoftwareinfo);
	}
	
	public Page<GokSoftwareinfo> findPage(Page<GokSoftwareinfo> page, GokSoftwareinfo gokSoftwareinfo) {
		return super.findPage(page, gokSoftwareinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(GokSoftwareinfo gokSoftwareinfo) {
		super.save(gokSoftwareinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(GokSoftwareinfo gokSoftwareinfo) {
		super.delete(gokSoftwareinfo);
	}
	
}