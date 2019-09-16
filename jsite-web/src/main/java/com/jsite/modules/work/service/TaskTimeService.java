/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.work.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.persistence.Page;
import com.jsite.common.service.CrudService;
import com.jsite.modules.work.entity.TaskTime;
import com.jsite.modules.work.dao.TaskTimeDao;

/**
 * 工时表Service
 * @author 工时表
 * @version 2019-01-23
 */
@Service
@Transactional(readOnly = true)
public class TaskTimeService extends CrudService<TaskTimeDao, TaskTime> {

	public TaskTime get(String id) {
		return super.get(id);
	}
	
	public List<TaskTime> findList(TaskTime taskTime) {
		return super.findList(taskTime);
	}
	
	public Page<TaskTime> findPage(Page<TaskTime> page, TaskTime taskTime) {
		return super.findPage(page, taskTime);
	}
	
	@Transactional(readOnly = false)
	public void save(TaskTime taskTime) {
		super.save(taskTime);
	}
	
	@Transactional(readOnly = false)
	public void delete(TaskTime taskTime) {
		super.delete(taskTime);
	}
	
}