package com.jsite.modules.sx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.service.TreeService;
import com.jsite.common.lang.StringUtils;
import com.jsite.modules.sx.entity.SxDailyProc;
import com.jsite.modules.sx.dao.SxDailyProcDao;

/**
 * 实训流程Service
 * @author 林鹏群
 * @version 2019-09-07
 */
@Service
@Transactional(readOnly = true)
public class SxDailyProcService extends TreeService<SxDailyProcDao, SxDailyProc> {

	public SxDailyProc get(String id) {
		return super.get(id);
	}
	
	public List<SxDailyProc> findList(SxDailyProc sxDailyProc) {
		if (StringUtils.isNotBlank(sxDailyProc.getParentIds())){
			sxDailyProc.setParentIds(","+sxDailyProc.getParentIds()+",");
		}
		return super.findList(sxDailyProc);
	}
	
	@Transactional(readOnly = false)
	public void save(SxDailyProc sxDailyProc) {
		super.save(sxDailyProc);
	}
	
	@Transactional(readOnly = false)
	public void delete(SxDailyProc sxDailyProc) {
		super.delete(sxDailyProc);
	}
	
}