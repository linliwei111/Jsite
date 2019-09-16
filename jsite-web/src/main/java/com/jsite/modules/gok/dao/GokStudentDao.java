/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.gok.entity.GokStudent;

/**
 * 学生信息DAO接口
 * @author 学生信息
 * @version 2019-03-28
 */
@MyBatisDao
public interface GokStudentDao extends CrudDao<GokStudent> {
	
}