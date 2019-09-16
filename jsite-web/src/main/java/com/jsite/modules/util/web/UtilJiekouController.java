/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.util.web;

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
import com.jsite.modules.util.entity.UtilJiekou;
import com.jsite.modules.util.service.UtilJiekouService;

import com.jsite.common.utils.UploadUtils4;
import com.jsite.common.utils.excel.ExportExcel;
import com.jsite.common.utils.excel.ImportExcel;
import org.apache.commons.fileupload.FileItem;
import com.jsite.common.lang.DateUtils;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

/**
 * 接口测试Controller
 * @author 接口测试
 * @version 2019-04-03
 */
@Controller
@RequestMapping(value = "${adminPath}/util/utilJiekou")
public class UtilJiekouController extends BaseController {

	@Autowired
	private UtilJiekouService utilJiekouService;
	
	@ModelAttribute
	public UtilJiekou get(@RequestParam(required=false) String id) {
		UtilJiekou entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = utilJiekouService.get(id);
		}
		if (entity == null){
			entity = new UtilJiekou();
		}
		return entity;
	}
	
	@RequiresPermissions("util:utilJiekou:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/util/utilJiekouList";
	}
	
	@RequiresPermissions("util:utilJiekou:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UtilJiekou> listData(UtilJiekou utilJiekou, HttpServletRequest request, HttpServletResponse response) {
		Page<UtilJiekou> page = utilJiekouService.findPage(new Page<>(request, response), utilJiekou);
		return page;
	}

	@RequiresPermissions("util:utilJiekou:view")
	@RequestMapping(value = "form")
	public String form(UtilJiekou utilJiekou, Model model) {
		model.addAttribute("utilJiekou", utilJiekou);
		return "modules/util/utilJiekouForm";
	}

	@RequiresPermissions("util:utilJiekou:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(UtilJiekou utilJiekou) {
		utilJiekouService.save(utilJiekou);
		return renderResult(Global.TRUE, "保存接口测试成功");
	}
	
	@RequiresPermissions("util:utilJiekou:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UtilJiekou utilJiekou) {
		utilJiekouService.delete(utilJiekou);
		return renderResult(Global.TRUE, "删除接口测试成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("util:utilJiekou:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(UtilJiekou utilJiekou, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "接口测试数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<UtilJiekou> page = utilJiekouService.findPage(new Page<UtilJiekou>(request, response, -1), utilJiekou);
    		new ExportExcel("接口测试数据", UtilJiekou.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("util:utilJiekou:edit")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    @ResponseBody
    public String importFile(HttpServletRequest request) {
        if (Global.isDemoMode()) {
            return renderResult(Global.FALSE, "演示模式，不允许操作！");
        }

        try {
            int successNum = 0;
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();
            Map<String, Object> fieldsMap = UploadUtils4.getInstance().initFields(request);
            FileItem fileItem = ((List<FileItem>) fieldsMap.get(UploadUtils4.FILE_FIELDS)).get(0);
            ImportExcel ei = new ImportExcel(fileItem, 1, 0);
            List<UtilJiekou> list = ei.getDataList(UtilJiekou.class);
            for (UtilJiekou utilJiekou : list) {
                try {
                    if (true) {
                        utilJiekouService.save(utilJiekou);
                        successNum++;
                    } else {
                        failureMsg.append(" 已存在; ");
                        failureNum++;
                    }
                } catch (Exception ex) {
                    failureMsg.append(" 导入失败：" + ex.getMessage());
                     failureNum++;

                }
            }
            if (failureNum > 0) {
                failureMsg.insert(0, "，失败 " + failureNum + " 条接口测试，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条接口测试" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入接口测试失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("util:utilJiekou:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "接口测试数据导入模板.xlsx";
    		List<UtilJiekou> list = Lists.newArrayList();
    		list.add(new UtilJiekou());
    		new ExportExcel("接口测试数据", UtilJiekou.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/util/utilJiekou/list";
    }

}