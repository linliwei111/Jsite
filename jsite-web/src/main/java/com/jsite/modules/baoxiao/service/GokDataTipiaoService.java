/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.baoxiao.service;

import java.util.List;

import com.jsite.modules.baoxiao.dao.GokDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.baoxiao.entity.GokDataTipiao;
import com.jsite.modules.baoxiao.dao.GokDataTipiaoDao;

/**
 * 替票报销Service
 * @author 替票报销
 * @version 2019-03-21
 */
@Service
@Transactional(readOnly = true)
public class GokDataTipiaoService extends CrudService<GokDataTipiaoDao, GokDataTipiao> {


	@Autowired
	private GokDataTipiaoDao gokDataTipiaoDao;

	public GokDataTipiao get(String id) {
		return super.get(id);
	}

	public List<GokDataTipiao> findList(GokDataTipiao gokDataTipiao) {
		return super.findList(gokDataTipiao);
	}

	public Page<GokDataTipiao> findPage(Page<GokDataTipiao> page, GokDataTipiao gokDataTipiao) {

		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		gokDataTipiao.getSqlMap().put("dsf", dataScopeFilter(gokDataTipiao.getCurrentUser(), "o10", "u1"));
		// 设置分页参数
		gokDataTipiao.setPage(page);
		// 执行分页查询
		List<GokDataTipiao> gokDataTipiaoList = gokDataTipiaoDao.findList(gokDataTipiao);
		page.setList(gokDataTipiaoList);

		return super.findPage(page, gokDataTipiao);
	}
	
	@Transactional(readOnly = false)
	public void save(GokDataTipiao gokDataTipiao) {
		super.save(gokDataTipiao);
	}
	
	@Transactional(readOnly = false)
	public void delete(GokDataTipiao gokDataTipiao) {
		super.delete(gokDataTipiao);
	}
	
}