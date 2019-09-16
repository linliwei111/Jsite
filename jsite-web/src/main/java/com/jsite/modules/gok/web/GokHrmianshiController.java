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
import com.jsite.modules.gok.entity.GokHrmianshi;
import com.jsite.modules.gok.service.GokHrmianshiService;

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
 * 人事面试记录Controller
 * @author 人事面试记录
 * @version 2019-04-13
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/gokHrmianshi")
public class GokHrmianshiController extends BaseController {

	@Autowired
	private GokHrmianshiService gokHrmianshiService;
	
	@ModelAttribute
	public GokHrmianshi get(@RequestParam(required=false) String id) {
		GokHrmianshi entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gokHrmianshiService.get(id);
		}
		if (entity == null){
			entity = new GokHrmianshi();
		}
		return entity;
	}
	
	@RequiresPermissions("gok:gokHrmianshi:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/gokHrmianshiList";
	}
	
	@RequiresPermissions("gok:gokHrmianshi:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GokHrmianshi> listData(GokHrmianshi gokHrmianshi, HttpServletRequest request, HttpServletResponse response) {
		Page<GokHrmianshi> page = gokHrmianshiService.findPage(new Page<>(request, response), gokHrmianshi);
		return page;
	}

	@RequiresPermissions("gok:gokHrmianshi:view")
	@RequestMapping(value = "form")
	public String form(GokHrmianshi gokHrmianshi, Model model) {
		model.addAttribute("gokHrmianshi", gokHrmianshi);
		return "modules/gok/gokHrmianshiForm";
	}

	@RequiresPermissions("gok:gokHrmianshi:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(GokHrmianshi gokHrmianshi) {
		gokHrmianshiService.save(gokHrmianshi);
		return renderResult(Global.TRUE, "保存人事面试记录成功");
	}
	
	@RequiresPermissions("gok:gokHrmianshi:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GokHrmianshi gokHrmianshi) {
		gokHrmianshiService.delete(gokHrmianshi);
		return renderResult(Global.TRUE, "删除人事面试记录成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("gok:gokHrmianshi:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(GokHrmianshi gokHrmianshi, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "人事面试记录数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<GokHrmianshi> page = gokHrmianshiService.findPage(new Page<GokHrmianshi>(request, response, -1), gokHrmianshi);
    		new ExportExcel("人事面试记录数据", GokHrmianshi.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("gok:gokHrmianshi:edit")
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
            List<GokHrmianshi> list = ei.getDataList(GokHrmianshi.class);
            for (GokHrmianshi gokHrmianshi : list) {
                try {
                    if (true) {
                        gokHrmianshiService.save(gokHrmianshi);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条人事面试记录，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条人事面试记录" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入人事面试记录失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("gok:gokHrmianshi:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "人事面试记录数据导入模板.xlsx";
    		List<GokHrmianshi> list = Lists.newArrayList();
    		list.add(new GokHrmianshi());
    		new ExportExcel("人事面试记录数据", GokHrmianshi.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/gok/gokHrmianshi/list";
    }

}