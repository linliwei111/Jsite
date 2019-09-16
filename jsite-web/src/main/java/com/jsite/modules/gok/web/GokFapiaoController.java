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
import com.jsite.modules.gok.entity.GokFapiao;
import com.jsite.modules.gok.service.GokFapiaoService;

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
 * 发票记录Controller
 * @author 发票记录
 * @version 2019-04-03
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/gokFapiao")
public class GokFapiaoController extends BaseController {

	@Autowired
	private GokFapiaoService gokFapiaoService;
	
	@ModelAttribute
	public GokFapiao get(@RequestParam(required=false) String id) {
		GokFapiao entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gokFapiaoService.get(id);
		}
		if (entity == null){
			entity = new GokFapiao();
		}
		return entity;
	}
	
	@RequiresPermissions("gok:gokFapiao:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/gokFapiaoList";
	}
	
	@RequiresPermissions("gok:gokFapiao:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GokFapiao> listData(GokFapiao gokFapiao, HttpServletRequest request, HttpServletResponse response) {
		Page<GokFapiao> page = gokFapiaoService.findPage(new Page<>(request, response), gokFapiao);
		return page;
	}

	@RequiresPermissions("gok:gokFapiao:view")
	@RequestMapping(value = "form")
	public String form(GokFapiao gokFapiao, Model model) {
		model.addAttribute("gokFapiao", gokFapiao);
		return "modules/gok/gokFapiaoForm";
	}

	@RequiresPermissions("gok:gokFapiao:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(GokFapiao gokFapiao) {
		gokFapiaoService.save(gokFapiao);
		return renderResult(Global.TRUE, "保存发票记录成功");
	}
	
	@RequiresPermissions("gok:gokFapiao:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GokFapiao gokFapiao) {
		gokFapiaoService.delete(gokFapiao);
		return renderResult(Global.TRUE, "删除发票记录成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("gok:gokFapiao:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(GokFapiao gokFapiao, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "发票记录数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<GokFapiao> page = gokFapiaoService.findPage(new Page<GokFapiao>(request, response, -1), gokFapiao);
    		new ExportExcel("发票记录数据", GokFapiao.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("gok:gokFapiao:edit")
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
            List<GokFapiao> list = ei.getDataList(GokFapiao.class);
            for (GokFapiao gokFapiao : list) {
                try {
                    if (true) {
                        gokFapiaoService.save(gokFapiao);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条发票记录，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条发票记录" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入发票记录失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("gok:gokFapiao:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "发票记录数据导入模板.xlsx";
    		List<GokFapiao> list = Lists.newArrayList();
    		list.add(new GokFapiao());
    		new ExportExcel("发票记录数据", GokFapiao.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/gok/gokFapiao/list";
    }

}