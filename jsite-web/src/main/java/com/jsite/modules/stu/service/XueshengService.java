/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.stu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.stu.entity.Xuesheng;
import com.jsite.modules.stu.dao.XueshengDao;

/**
 * 学生Service
 * @author 学生
 * @version 2019-05-23
 */
@Service
@Transactional(readOnly = true)
public class XueshengService extends CrudService<XueshengDao, Xuesheng> {

	public Xuesheng get(String id) {
		return super.get(id);
	}
	
	public List<Xuesheng> findList(Xuesheng xuesheng) {
		return super.findList(xuesheng);
	}
	
	public Page<Xuesheng> findPage(Page<Xuesheng> page, Xuesheng xuesheng) {
		return super.findPage(page, xuesheng);
	}
	
	@Transactional(readOnly = false)
	public void save(Xuesheng xuesheng) {
		super.save(xuesheng);
	}
	
	@Transactional(readOnly = false)
	public void delete(Xuesheng xuesheng) {
		super.delete(xuesheng);
	}
	
}