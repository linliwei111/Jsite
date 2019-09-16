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
import com.jsite.modules.gok.entity.GokSoftwareinfo;
import com.jsite.modules.gok.service.GokSoftwareinfoService;

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
 * 软件信息Controller
 * @author 软件信息
 * @version 2019-04-13
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/gokSoftwareinfo")
public class GokSoftwareinfoController extends BaseController {

	@Autowired
	private GokSoftwareinfoService gokSoftwareinfoService;
	
	@ModelAttribute
	public GokSoftwareinfo get(@RequestParam(required=false) String id) {
		GokSoftwareinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gokSoftwareinfoService.get(id);
		}
		if (entity == null){
			entity = new GokSoftwareinfo();
		}
		return entity;
	}
	
	@RequiresPermissions("gok:gokSoftwareinfo:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/gokSoftwareinfoList";
	}
	
	@RequiresPermissions("gok:gokSoftwareinfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GokSoftwareinfo> listData(GokSoftwareinfo gokSoftwareinfo, HttpServletRequest request, HttpServletResponse response) {
		Page<GokSoftwareinfo> page = gokSoftwareinfoService.findPage(new Page<>(request, response), gokSoftwareinfo);
		return page;
	}

	@RequiresPermissions("gok:gokSoftwareinfo:view")
	@RequestMapping(value = "form")
	public String form(GokSoftwareinfo gokSoftwareinfo, Model model) {
		model.addAttribute("gokSoftwareinfo", gokSoftwareinfo);
		return "modules/gok/gokSoftwareinfoForm";
	}

	@RequiresPermissions("gok:gokSoftwareinfo:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(GokSoftwareinfo gokSoftwareinfo) {
		gokSoftwareinfoService.save(gokSoftwareinfo);
		return renderResult(Global.TRUE, "保存软件信息成功");
	}
	
	@RequiresPermissions("gok:gokSoftwareinfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GokSoftwareinfo gokSoftwareinfo) {
		gokSoftwareinfoService.delete(gokSoftwareinfo);
		return renderResult(Global.TRUE, "删除软件信息成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("gok:gokSoftwareinfo:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(GokSoftwareinfo gokSoftwareinfo, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "软件信息数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<GokSoftwareinfo> page = gokSoftwareinfoService.findPage(new Page<GokSoftwareinfo>(request, response, -1), gokSoftwareinfo);
    		new ExportExcel("软件信息数据", GokSoftwareinfo.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("gok:gokSoftwareinfo:edit")
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
            List<GokSoftwareinfo> list = ei.getDataList(GokSoftwareinfo.class);
            for (GokSoftwareinfo gokSoftwareinfo : list) {
                try {
                    if (true) {
                        gokSoftwareinfoService.save(gokSoftwareinfo);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条软件信息，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条软件信息" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入软件信息失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("gok:gokSoftwareinfo:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "软件信息数据导入模板.xlsx";
    		List<GokSoftwareinfo> list = Lists.newArrayList();
    		list.add(new GokSoftwareinfo());
    		new ExportExcel("软件信息数据", GokSoftwareinfo.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/gok/gokSoftwareinfo/list";
    }

}