/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.stu.web;

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
import com.jsite.modules.stu.entity.Xuesheng;
import com.jsite.modules.stu.service.XueshengService;

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
 * 学生Controller
 * @author 学生
 * @version 2019-05-23
 */
@Controller
@RequestMapping(value = "${adminPath}/stu/xuesheng")
public class XueshengController extends BaseController {

	@Autowired
	private XueshengService xueshengService;
	
	@ModelAttribute
	public Xuesheng get(@RequestParam(required=false) String id) {
		Xuesheng entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xueshengService.get(id);
		}
		if (entity == null){
			entity = new Xuesheng();
		}
		return entity;
	}
	
	@RequiresPermissions("stu:xuesheng:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/stu/xueshengList";
	}
	
	@RequiresPermissions("stu:xuesheng:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Xuesheng> listData(Xuesheng xuesheng, HttpServletRequest request, HttpServletResponse response) {
		Page<Xuesheng> page = xueshengService.findPage(new Page<>(request, response), xuesheng);
		return page;
	}

	@RequiresPermissions("stu:xuesheng:view")
	@RequestMapping(value = "form")
	public String form(Xuesheng xuesheng, Model model) {
		model.addAttribute("xuesheng", xuesheng);
		return "modules/stu/xueshengForm";
	}

	@RequiresPermissions("stu:xuesheng:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(Xuesheng xuesheng) {
		xueshengService.save(xuesheng);
		return renderResult(Global.TRUE, "保存学生成功");
	}
	
	@RequiresPermissions("stu:xuesheng:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Xuesheng xuesheng) {
		xueshengService.delete(xuesheng);
		return renderResult(Global.TRUE, "删除学生成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("stu:xuesheng:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(Xuesheng xuesheng, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "学生数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Xuesheng> page = xueshengService.findPage(new Page<Xuesheng>(request, response, -1), xuesheng);
    		new ExportExcel("学生数据", Xuesheng.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("stu:xuesheng:edit")
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
            List<Xuesheng> list = ei.getDataList(Xuesheng.class);
            for (Xuesheng xuesheng : list) {
                try {
                    if (true) {
                        xueshengService.save(xuesheng);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条学生，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条学生" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入学生失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("stu:xuesheng:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "学生数据导入模板.xlsx";
    		List<Xuesheng> list = Lists.newArrayList();
    		list.add(new Xuesheng());
    		new ExportExcel("学生数据", Xuesheng.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/stu/xuesheng/list";
    }

}