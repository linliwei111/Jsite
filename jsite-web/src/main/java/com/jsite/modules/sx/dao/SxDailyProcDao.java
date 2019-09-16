package com.jsite.modules.sx.dao;

import com.jsite.common.persistence.TreeDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.sx.entity.SxDailyProc;

/**
 * 实训流程DAO接口
 * @author 林鹏群
 * @version 2019-09-07
 */
@MyBatisDao
public interface SxDailyProcDao extends TreeDao<SxDailyProc> {
	
}