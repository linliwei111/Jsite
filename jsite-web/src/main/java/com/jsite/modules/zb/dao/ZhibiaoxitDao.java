/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.zb.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.zb.entity.Zhibiaoxit;

/**
 * 指标系统DAO接口
 * @author 林鹏群
 * @version 2019-09-10
 */
@MyBatisDao
public interface ZhibiaoxitDao extends CrudDao<Zhibiaoxit> {
	
}