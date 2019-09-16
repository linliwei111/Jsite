/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.gok.entity.GokHrmianshi;

/**
 * 人事面试记录DAO接口
 * @author 人事面试记录
 * @version 2019-04-13
 */
@MyBatisDao
public interface GokHrmianshiDao extends CrudDao<GokHrmianshi> {
	
}