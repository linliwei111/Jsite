/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.work.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.common.config.Global;
import com.jsite.common.persistence.Page;
import com.jsite.common.web.BaseController;
import com.jsite.common.lang.StringUtils;
import com.jsite.modules.work.entity.TaskTime;
import com.jsite.modules.work.service.TaskTimeService;

/**
 * 工时表Controller
 * @author 工时表
 * @version 2019-01-23
 */
@Controller
@RequestMapping(value = "${adminPath}/work/taskTime")
public class TaskTimeController extends BaseController {

	@Autowired
	private TaskTimeService taskTimeService;
	
	@ModelAttribute
	public TaskTime get(@RequestParam(required=false) String id) {
		TaskTime entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = taskTimeService.get(id);
		}
		if (entity == null){
			entity = new TaskTime();
		}
		return entity;
	}
	
	@RequiresPermissions("work:taskTime:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/work/taskTimeList";
	}
	
	@RequiresPermissions("work:taskTime:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TaskTime> listData(TaskTime taskTime, HttpServletRequest request, HttpServletResponse response) {
		Page<TaskTime> page = taskTimeService.findPage(new Page<>(request, response), taskTime);
		return page;
	}

	@RequiresPermissions("work:taskTime:view")
	@RequestMapping(value = "form")
	public String form(TaskTime taskTime, Model model) {
		model.addAttribute("taskTime", taskTime);
		return "modules/work/taskTimeForm";
	}

	@RequiresPermissions("work:taskTime:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(TaskTime taskTime) {
		taskTimeService.save(taskTime);
		return renderResult(Global.TRUE, "保存工时表成功");
	}
	
	@RequiresPermissions("work:taskTime:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TaskTime taskTime) {
		taskTimeService.delete(taskTime);
		return renderResult(Global.TRUE, "删除工时表成功");
	}

}