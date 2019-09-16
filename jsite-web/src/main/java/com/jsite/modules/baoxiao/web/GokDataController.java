/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.baoxiao.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsite.common.lang.DateUtils;
import com.jsite.common.utils.excel.ExportExcel;
import com.jsite.modules.sys.entity.User;
import com.jsite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jsite.common.config.Global;
import com.jsite.common.persistence.Page;
import com.jsite.common.web.BaseController;
import com.jsite.common.lang.StringUtils;
import com.jsite.modules.baoxiao.entity.GokData;
import com.jsite.modules.baoxiao.service.GokDataService;

/**
 * 有票报销Controller
 * @author 有票报销
 * @version 2019-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/baoxiao/gokData")
public class GokDataController extends BaseController {

	@Autowired
	private GokDataService gokDataService;
	
	@ModelAttribute
	public GokData get(@RequestParam(required=false) String id) {
		GokData entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gokDataService.get(id);
		}
		if (entity == null){
			entity = new GokData();
		}
		return entity;
	}
	
	@RequiresPermissions("baoxiao:gokData:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/baoxiao/gokDataList";
	}
	
	@RequiresPermissions("baoxiao:gokData:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GokData> listData(GokData gokData, HttpServletRequest request, HttpServletResponse response) {
		Page<GokData> page = gokDataService.findPage(new Page<>(request, response), gokData);
		return page;
	}

	@RequiresPermissions("baoxiao:gokData:view")
	@RequestMapping(value = "form")
	public String form(GokData gokData, Model model) {

		if (gokData.getOffice()==null || gokData.getOffice().getId()==null){
			gokData.setOffice(UserUtils.getUser().getOffice());
		}

		if (StringUtils.isBlank(gokData.getBaoxiaoren())){
			gokData.setBaoxiaoren(UserUtils.getUser().getName());
		}
		model.addAttribute("gokData", gokData);
		return "modules/baoxiao/gokDataForm";
	}

	@RequiresPermissions("baoxiao:gokData:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(GokData gokData) {
		gokDataService.save(gokData);
		return renderResult(Global.TRUE, "保存有票报销成功");
	}
	
	@RequiresPermissions("baoxiao:gokData:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GokData gokData) {
		gokDataService.delete(gokData);
		return renderResult(Global.TRUE, "删除有票报销成功");
	}


	/**
	 * 导出有票数据
	 * @param gokData
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("baoxiao:gokData:view")
	@RequestMapping(value = "export", method= RequestMethod.GET)
	public void exportFile(GokData gokData, HttpServletRequest request, HttpServletResponse response) {
		try {
			String fileName = "有票数据"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
			Page<GokData> page = gokDataService.findPage(new Page<GokData>(request, response, -1), gokData);
			new ExportExcel("有票报销", GokData.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}