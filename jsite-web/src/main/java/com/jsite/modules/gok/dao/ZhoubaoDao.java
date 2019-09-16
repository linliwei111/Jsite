/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.gok.entity.Zhoubao;

/**
 * 周报DAO接口
 * @author 周报
 * @version 2019-04-26
 */
@MyBatisDao
public interface ZhoubaoDao extends CrudDao<Zhoubao> {
	
}