/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.web;

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
import com.jsite.modules.gok.entity.Nenglibiaoqian;
import com.jsite.modules.gok.service.NenglibiaoqianService;

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
 * 能力标签Controller
 * @author 能力标签
 * @version 2019-04-10
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/nenglibiaoqian")
public class NenglibiaoqianController extends BaseController {

	@Autowired
	private NenglibiaoqianService nenglibiaoqianService;
	
	@ModelAttribute
	public Nenglibiaoqian get(@RequestParam(required=false) String id) {
		Nenglibiaoqian entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nenglibiaoqianService.get(id);
		}
		if (entity == null){
			entity = new Nenglibiaoqian();
		}
		return entity;
	}
	
	@RequiresPermissions("gok:nenglibiaoqian:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/nenglibiaoqianList";
	}
	
	@RequiresPermissions("gok:nenglibiaoqian:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Nenglibiaoqian> listData(Nenglibiaoqian nenglibiaoqian, HttpServletRequest request, HttpServletResponse response) {
		Page<Nenglibiaoqian> page = nenglibiaoqianService.findPage(new Page<>(request, response), nenglibiaoqian);
		return page;
	}

	@RequiresPermissions("gok:nenglibiaoqian:view")
	@RequestMapping(value = "form")
	public String form(Nenglibiaoqian nenglibiaoqian, Model model) {
		model.addAttribute("nenglibiaoqian", nenglibiaoqian);
		return "modules/gok/nenglibiaoqianForm";
	}

	@RequiresPermissions("gok:nenglibiaoqian:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(Nenglibiaoqian nenglibiaoqian) {
		nenglibiaoqianService.save(nenglibiaoqian);
		return renderResult(Global.TRUE, "保存能力标签成功");
	}
	
	@RequiresPermissions("gok:nenglibiaoqian:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Nenglibiaoqian nenglibiaoqian) {
		nenglibiaoqianService.delete(nenglibiaoqian);
		return renderResult(Global.TRUE, "删除能力标签成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("gok:nenglibiaoqian:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(Nenglibiaoqian nenglibiaoqian, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "能力标签数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Nenglibiaoqian> page = nenglibiaoqianService.findPage(new Page<Nenglibiaoqian>(request, response, -1), nenglibiaoqian);
    		new ExportExcel("能力标签数据", Nenglibiaoqian.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("gok:nenglibiaoqian:edit")
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
            List<Nenglibiaoqian> list = ei.getDataList(Nenglibiaoqian.class);
            for (Nenglibiaoqian nenglibiaoqian : list) {
                try {
                    if (true) {
                        nenglibiaoqianService.save(nenglibiaoqian);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条能力标签，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条能力标签" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入能力标签失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("gok:nenglibiaoqian:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "能力标签数据导入模板.xlsx";
    		List<Nenglibiaoqian> list = Lists.newArrayList();
    		list.add(new Nenglibiaoqian());
    		new ExportExcel("能力标签数据", Nenglibiaoqian.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/gok/nenglibiaoqian/list";
    }

}