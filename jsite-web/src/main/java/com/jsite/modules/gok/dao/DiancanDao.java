/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.gok.entity.Diancan;

/**
 * 点餐信息DAO接口
 * @author 点餐信息
 * @version 2019-04-11
 */
@MyBatisDao
public interface DiancanDao extends CrudDao<Diancan> {
	
}