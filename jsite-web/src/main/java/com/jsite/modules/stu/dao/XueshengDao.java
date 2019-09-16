/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.stu.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.stu.entity.Xuesheng;

/**
 * 学生DAO接口
 * @author 学生
 * @version 2019-05-23
 */
@MyBatisDao
public interface XueshengDao extends CrudDao<Xuesheng> {
	
}