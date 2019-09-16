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
import com.jsite.modules.gok.entity.Zhoubao;
import com.jsite.modules.gok.service.ZhoubaoService;

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
 * 周报Controller
 * @author 周报
 * @version 2019-04-26
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/zhoubao")
public class ZhoubaoController extends BaseController {

	@Autowired
	private ZhoubaoService zhoubaoService;
	
	@ModelAttribute
	public Zhoubao get(@RequestParam(required=false) String id) {
		Zhoubao entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zhoubaoService.get(id);
		}
		if (entity == null){
			entity = new Zhoubao();
		}
		return entity;
	}
	
	@RequiresPermissions("gok:zhoubao:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/zhoubaoList";
	}
	
	@RequiresPermissions("gok:zhoubao:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Zhoubao> listData(Zhoubao zhoubao, HttpServletRequest request, HttpServletResponse response) {
		Page<Zhoubao> page = zhoubaoService.findPage(new Page<>(request, response), zhoubao);
		return page;
	}

	@RequiresPermissions("gok:zhoubao:view")
	@RequestMapping(value = "form")
	public String form(Zhoubao zhoubao, Model model) {
		model.addAttribute("zhoubao", zhoubao);
		return "modules/gok/zhoubaoForm";
	}

	@RequiresPermissions("gok:zhoubao:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(Zhoubao zhoubao) {
		zhoubaoService.save(zhoubao);
		return renderResult(Global.TRUE, "保存周报成功");
	}
	
	@RequiresPermissions("gok:zhoubao:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Zhoubao zhoubao) {
		zhoubaoService.delete(zhoubao);
		return renderResult(Global.TRUE, "删除周报成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("gok:zhoubao:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(Zhoubao zhoubao, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "周报数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Zhoubao> page = zhoubaoService.findPage(new Page<Zhoubao>(request, response, -1), zhoubao);
    		new ExportExcel("周报数据", Zhoubao.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("gok:zhoubao:edit")
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
            List<Zhoubao> list = ei.getDataList(Zhoubao.class);
            for (Zhoubao zhoubao : list) {
                try {
                    if (true) {
                        zhoubaoService.save(zhoubao);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条周报，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条周报" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入周报失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("gok:zhoubao:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "周报数据导入模板.xlsx";
    		List<Zhoubao> list = Lists.newArrayList();
    		list.add(new Zhoubao());
    		new ExportExcel("周报数据", Zhoubao.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/gok/zhoubao/list";
    }

}