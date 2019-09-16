/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.gok.entity.GokFapiao;

/**
 * 发票记录DAO接口
 * @author 发票记录
 * @version 2019-04-03
 */
@MyBatisDao
public interface GokFapiaoDao extends CrudDao<GokFapiao> {
	
}