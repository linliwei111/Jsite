/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.gok.entity.GokSoftwareinfo;

/**
 * 软件信息DAO接口
 * @author 软件信息
 * @version 2019-04-13
 */
@MyBatisDao
public interface GokSoftwareinfoDao extends CrudDao<GokSoftwareinfo> {
	
}