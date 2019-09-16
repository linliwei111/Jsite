/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.zb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.zb.entity.Zhibiaoxit;
import com.jsite.modules.zb.dao.ZhibiaoxitDao;

/**
 * 指标系统Service
 * @author 林鹏群
 * @version 2019-09-10
 */
@Service
@Transactional(readOnly = true)
public class ZhibiaoxitService extends CrudService<ZhibiaoxitDao, Zhibiaoxit> {

	public Zhibiaoxit get(String id) {
		return super.get(id);
	}
	
	public List<Zhibiaoxit> findList(Zhibiaoxit zhibiaoxit) {
		return super.findList(zhibiaoxit);
	}
	
	public Page<Zhibiaoxit> findPage(Page<Zhibiaoxit> page, Zhibiaoxit zhibiaoxit) {
		return super.findPage(page, zhibiaoxit);
	}
	
	@Transactional(readOnly = false)
	public void save(Zhibiaoxit zhibiaoxit) {
		super.save(zhibiaoxit);
	}
	
	@Transactional(readOnly = false)
	public void delete(Zhibiaoxit zhibiaoxit) {
		super.delete(zhibiaoxit);
	}
	
}