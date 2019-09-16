/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.zb.web;

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
import com.jsite.modules.zb.entity.Zhibiaoxit;
import com.jsite.modules.zb.service.ZhibiaoxitService;

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
 * 指标系统Controller
 * @author 林鹏群
 * @version 2019-09-10
 */
@Controller
@RequestMapping(value = "${adminPath}/zb/zhibiaoxit")
public class ZhibiaoxitController extends BaseController {

	@Autowired
	private ZhibiaoxitService zhibiaoxitService;
	
	@ModelAttribute
	public Zhibiaoxit get(@RequestParam(required=false) String id) {
		Zhibiaoxit entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zhibiaoxitService.get(id);
		}
		if (entity == null){
			entity = new Zhibiaoxit();
		}
		return entity;
	}
	
	@RequiresPermissions("zb:zhibiaoxit:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/zb/zhibiaoxitList";
	}
	
	@RequiresPermissions("zb:zhibiaoxit:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Zhibiaoxit> listData(Zhibiaoxit zhibiaoxit, HttpServletRequest request, HttpServletResponse response) {
		Page<Zhibiaoxit> page = zhibiaoxitService.findPage(new Page<>(request, response), zhibiaoxit);
		return page;
	}

	@RequiresPermissions("zb:zhibiaoxit:view")
	@RequestMapping(value = "form")
	public String form(Zhibiaoxit zhibiaoxit, Model model) {
		model.addAttribute("zhibiaoxit", zhibiaoxit);
		return "modules/zb/zhibiaoxitForm";
	}

	@RequiresPermissions("zb:zhibiaoxit:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(Zhibiaoxit zhibiaoxit) {
		zhibiaoxitService.save(zhibiaoxit);
		return renderResult(Global.TRUE, "保存指标系统成功");
	}
	
	@RequiresPermissions("zb:zhibiaoxit:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Zhibiaoxit zhibiaoxit) {
		zhibiaoxitService.delete(zhibiaoxit);
		return renderResult(Global.TRUE, "删除指标系统成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("zb:zhibiaoxit:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(Zhibiaoxit zhibiaoxit, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "指标系统数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Zhibiaoxit> page = zhibiaoxitService.findPage(new Page<Zhibiaoxit>(request, response, -1), zhibiaoxit);
    		new ExportExcel("指标系统数据", Zhibiaoxit.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("zb:zhibiaoxit:edit")
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
            List<Zhibiaoxit> list = ei.getDataList(Zhibiaoxit.class);
            for (Zhibiaoxit zhibiaoxit : list) {
                try {
                    if (true) {
                        zhibiaoxitService.save(zhibiaoxit);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条指标系统，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条指标系统" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入指标系统失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("zb:zhibiaoxit:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "指标系统数据导入模板.xlsx";
    		List<Zhibiaoxit> list = Lists.newArrayList();
    		list.add(new Zhibiaoxit());
    		new ExportExcel("指标系统数据", Zhibiaoxit.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/zb/zhibiaoxit/list";
    }

}