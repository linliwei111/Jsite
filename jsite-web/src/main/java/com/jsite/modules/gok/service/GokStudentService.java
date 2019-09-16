/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.gok.entity.GokStudent;
import com.jsite.modules.gok.dao.GokStudentDao;

/**
 * 学生信息Service
 * @author 学生信息
 * @version 2019-03-28
 */
@Service
@Transactional(readOnly = true)
public class GokStudentService extends CrudService<GokStudentDao, GokStudent> {

	public GokStudent get(String id) {
		return super.get(id);
	}
	
	public List<GokStudent> findList(GokStudent gokStudent) {
		return super.findList(gokStudent);
	}
	
	public Page<GokStudent> findPage(Page<GokStudent> page, GokStudent gokStudent) {
		return super.findPage(page, gokStudent);
	}
	
	@Transactional(readOnly = false)
	public void save(GokStudent gokStudent) {
		super.save(gokStudent);
	}
	
	@Transactional(readOnly = false)
	public void delete(GokStudent gokStudent) {
		super.delete(gokStudent);
	}
	
}