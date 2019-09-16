/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.util.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.util.entity.UtilJiekou;

/**
 * 接口测试DAO接口
 * @author 接口测试
 * @version 2019-04-03
 */
@MyBatisDao
public interface UtilJiekouDao extends CrudDao<UtilJiekou> {
	
}