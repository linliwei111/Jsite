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
import com.jsite.modules.gok.entity.GokStudent;
import com.jsite.modules.gok.service.GokStudentService;

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
 * 学生信息Controller
 * @author 学生信息
 * @version 2019-03-28
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/gokStudent")
public class GokStudentController extends BaseController {

	@Autowired
	private GokStudentService gokStudentService;
	
	@ModelAttribute
	public GokStudent get(@RequestParam(required=false) String id) {
		GokStudent entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gokStudentService.get(id);
		}
		if (entity == null){
			entity = new GokStudent();
		}
		return entity;
	}
	
	@RequiresPermissions("gok:gokStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/gokStudentList";
	}
	
	@RequiresPermissions("gok:gokStudent:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GokStudent> listData(GokStudent gokStudent, HttpServletRequest request, HttpServletResponse response) {
		Page<GokStudent> page = gokStudentService.findPage(new Page<>(request, response), gokStudent);
		return page;
	}

	@RequiresPermissions("gok:gokStudent:view")
	@RequestMapping(value = "form")
	public String form(GokStudent gokStudent, Model model) {
		model.addAttribute("gokStudent", gokStudent);
		return "modules/gok/gokStudentForm";
	}

	@RequiresPermissions("gok:gokStudent:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(GokStudent gokStudent) {
		gokStudentService.save(gokStudent);
		return renderResult(Global.TRUE, "保存学生信息成功");
	}
	
	@RequiresPermissions("gok:gokStudent:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GokStudent gokStudent) {
		gokStudentService.delete(gokStudent);
		return renderResult(Global.TRUE, "删除学生信息成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("gok:gokStudent:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(GokStudent gokStudent, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "学生信息数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<GokStudent> page = gokStudentService.findPage(new Page<GokStudent>(request, response, -1), gokStudent);
    		new ExportExcel("学生信息数据", GokStudent.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("gok:gokStudent:edit")
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
            List<GokStudent> list = ei.getDataList(GokStudent.class);
            for (GokStudent gokStudent : list) {
                try {
                    if (true) {
                        gokStudentService.save(gokStudent);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条学生信息，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条学生信息" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入学生信息失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("gok:gokStudent:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "学生信息数据导入模板.xlsx";
    		List<GokStudent> list = Lists.newArrayList();
    		list.add(new GokStudent());
    		new ExportExcel("学生信息数据", GokStudent.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/gok/gokStudent/list";
    }

}