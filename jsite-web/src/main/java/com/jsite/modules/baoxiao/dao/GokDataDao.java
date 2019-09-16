/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.baoxiao.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.baoxiao.entity.GokData;

/**
 * 有票报销DAO接口
 * @author 有票报销
 * @version 2019-03-21
 */
@MyBatisDao
public interface GokDataDao extends CrudDao<GokData> {
	
}