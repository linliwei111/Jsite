/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.baoxiao.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsite.common.lang.DateUtils;
import com.jsite.common.utils.excel.ExportExcel;
import com.jsite.modules.baoxiao.entity.GokData;
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
import com.jsite.modules.baoxiao.entity.GokDataTipiao;
import com.jsite.modules.baoxiao.service.GokDataTipiaoService;

/**
 * 替票报销Controller
 * @author 替票报销
 * @version 2019-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/baoxiao/gokDataTipiao")
public class GokDataTipiaoController extends BaseController {

	@Autowired
	private GokDataTipiaoService gokDataTipiaoService;
	
	@ModelAttribute
	public GokDataTipiao get(@RequestParam(required=false) String id) {
		GokDataTipiao entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gokDataTipiaoService.get(id);
		}
		if (entity == null){
			entity = new GokDataTipiao();
		}
		return entity;
	}
	
	@RequiresPermissions("baoxiao:gokDataTipiao:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/baoxiao/gokDataTipiaoList";
	}
	
	@RequiresPermissions("baoxiao:gokDataTipiao:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GokDataTipiao> listData(GokDataTipiao gokDataTipiao, HttpServletRequest request, HttpServletResponse response) {
		Page<GokDataTipiao> page = gokDataTipiaoService.findPage(new Page<>(request, response), gokDataTipiao);
		return page;
	}

	@RequiresPermissions("baoxiao:gokDataTipiao:view")
	@RequestMapping(value = "form")
	public String form(GokDataTipiao gokDataTipiao, Model model) {
		if (gokDataTipiao.getOffice()==null || gokDataTipiao.getOffice().getId()==null){
			gokDataTipiao.setOffice(UserUtils.getUser().getOffice());
		}

		if (StringUtils.isBlank(gokDataTipiao.getBaoxiaoren())){
			gokDataTipiao.setBaoxiaoren(UserUtils.getUser().getName());
		}

		model.addAttribute("gokDataTipiao", gokDataTipiao);
		return "modules/baoxiao/gokDataTipiaoForm";
	}

	@RequiresPermissions("baoxiao:gokDataTipiao:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(GokDataTipiao gokDataTipiao) {
		gokDataTipiaoService.save(gokDataTipiao);
		return renderResult(Global.TRUE, "保存替票报销成功");
	}
	
	@RequiresPermissions("baoxiao:gokDataTipiao:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GokDataTipiao gokDataTipiao) {
		gokDataTipiaoService.delete(gokDataTipiao);
		return renderResult(Global.TRUE, "删除替票报销成功");
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
	public void exportFile(GokDataTipiao gokData, HttpServletRequest request, HttpServletResponse response) {
		try {
			String fileName = "替票数据"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
			Page<GokDataTipiao> page = gokDataTipiaoService.findPage(new Page<GokDataTipiao>(request, response, -1), gokData);
			new ExportExcel("替票报销", GokDataTipiao.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}