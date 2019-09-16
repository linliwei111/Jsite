/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.baoxiao.service;

import java.util.List;

import com.jsite.modules.sys.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.baoxiao.entity.GokData;
import com.jsite.modules.baoxiao.dao.GokDataDao;

/**
 * 有票报销Service
 * @author 有票报销
 * @version 2019-03-21
 */
@Service
@Transactional(readOnly = true)
public class GokDataService extends CrudService<GokDataDao, GokData> {


	@Autowired
	private GokDataDao gokDataDao;

	public GokData get(String id) {
		return super.get(id);
	}

	public List<GokData> findList(GokData gokData) {
		return super.findList(gokData);
	}

	public Page<GokData> findPage(Page<GokData> page, GokData gokData) {

		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
	    gokData.getSqlMap().put("dsf", dataScopeFilter(gokData.getCurrentUser(), "o8", "u1"));
		// 设置分页参数
		gokData.setPage(page);
		// 执行分页查询
		List<GokData> gokDataList = gokDataDao.findList(gokData);
		page.setList(gokDataList);

		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(GokData gokData) {
		super.save(gokData);
	}
	
	@Transactional(readOnly = false)
	public void delete(GokData gokData) {
		super.delete(gokData);
	}
	
}