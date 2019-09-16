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
import com.jsite.modules.gok.entity.Diancan;
import com.jsite.modules.gok.service.DiancanService;

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
 * 点餐信息Controller
 * @author 点餐信息
 * @version 2019-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/diancan")
public class DiancanController extends BaseController {

	@Autowired
	private DiancanService diancanService;
	
	@ModelAttribute
	public Diancan get(@RequestParam(required=false) String id) {
		Diancan entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = diancanService.get(id);
		}
		if (entity == null){
			entity = new Diancan();
		}
		return entity;
	}
	
	@RequiresPermissions("gok:diancan:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/diancanList";
	}
	
	@RequiresPermissions("gok:diancan:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Diancan> listData(Diancan diancan, HttpServletRequest request, HttpServletResponse response) {
		Page<Diancan> page = diancanService.findPage(new Page<>(request, response), diancan);
		return page;
	}

	@RequiresPermissions("gok:diancan:view")
	@RequestMapping(value = "form")
	public String form(Diancan diancan, Model model) {
		model.addAttribute("diancan", diancan);
		return "modules/gok/diancanForm";
	}

	@RequiresPermissions("gok:diancan:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(Diancan diancan) {
		diancanService.save(diancan);
		return renderResult(Global.TRUE, "保存点餐信息成功");
	}
	
	@RequiresPermissions("gok:diancan:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Diancan diancan) {
		diancanService.delete(diancan);
		return renderResult(Global.TRUE, "删除点餐信息成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("gok:diancan:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(Diancan diancan, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "点餐信息数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Diancan> page = diancanService.findPage(new Page<Diancan>(request, response, -1), diancan);
    		new ExportExcel("点餐信息数据", Diancan.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("gok:diancan:edit")
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
            List<Diancan> list = ei.getDataList(Diancan.class);
            for (Diancan diancan : list) {
                try {
                    if (true) {
                        diancanService.save(diancan);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条点餐信息，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条点餐信息" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入点餐信息失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("gok:diancan:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "点餐信息数据导入模板.xlsx";
    		List<Diancan> list = Lists.newArrayList();
    		list.add(new Diancan());
    		new ExportExcel("点餐信息数据", Diancan.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/gok/diancan/list";
    }

}