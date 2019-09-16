/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.work.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.work.entity.TaskTime;

/**
 * 工时表DAO接口
 * @author 工时表
 * @version 2019-01-23
 */
@MyBatisDao
public interface TaskTimeDao extends CrudDao<TaskTime> {
	
}