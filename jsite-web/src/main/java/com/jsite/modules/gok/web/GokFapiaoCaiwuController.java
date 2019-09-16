/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsite.modules.sys.utils.UserUtils;
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
import com.jsite.modules.gok.entity.GokFapiaoCaiwu;
import com.jsite.modules.gok.service.GokFapiaoCaiwuService;

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
 * 财务发票记录Controller
 * @author 财务发票记录
 * @version 2019-04-08
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/gokFapiaoCaiwu")
public class GokFapiaoCaiwuController extends BaseController {

	@Autowired
	private GokFapiaoCaiwuService gokFapiaoCaiwuService;
	
	@ModelAttribute
	public GokFapiaoCaiwu get(@RequestParam(required=false) String id) {
		GokFapiaoCaiwu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gokFapiaoCaiwuService.get(id);
		}
		if (entity == null){
			entity = new GokFapiaoCaiwu();
		}
		return entity;
	}
	
	@RequiresPermissions("gok:gokFapiaoCaiwu:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/gokFapiaoCaiwuList";
	}
	
	@RequiresPermissions("gok:gokFapiaoCaiwu:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GokFapiaoCaiwu> listData(GokFapiaoCaiwu gokFapiaoCaiwu, HttpServletRequest request, HttpServletResponse response) {
		Page<GokFapiaoCaiwu> page = gokFapiaoCaiwuService.findPage(new Page<>(request, response), gokFapiaoCaiwu);
		return page;
	}

	@RequiresPermissions("gok:gokFapiaoCaiwu:view")
	@RequestMapping(value = "form")
	public String form(GokFapiaoCaiwu gokFapiaoCaiwu, Model model) {


		if (gokFapiaoCaiwu.getBaoxiaorenbumen()==null || gokFapiaoCaiwu.getBaoxiaorenbumen().getId()==null){
			gokFapiaoCaiwu.setBaoxiaorenbumen(UserUtils.getUser().getOffice());
		}
		if (gokFapiaoCaiwu.getFeiyongguishubumen()==null || gokFapiaoCaiwu.getFeiyongguishubumen().getId()==null){
			gokFapiaoCaiwu.setFeiyongguishubumen(UserUtils.getUser().getOffice());
		}

		if (StringUtils.isBlank(gokFapiaoCaiwu.getBaoxiaoren())){
			gokFapiaoCaiwu.setBaoxiaoren(UserUtils.getUser().getName());
		}
//		if (StringUtils.isBlank(gokFapiaoCaiwu.getXuhao())){
//			gokFapiaoCaiwu.setXuhao(DateUtils.getDate());
//		}


		if (StringUtils.isBlank(gokFapiaoCaiwu.getId())){
			List<GokFapiaoCaiwu> list = Lists.newArrayList();
			String maxXuhao = gokFapiaoCaiwuService.findMaxXuhao();
			if (StringUtils.isNotBlank(maxXuhao)){
				gokFapiaoCaiwu.setXuhao(Integer.valueOf(maxXuhao) + 1+"");
			}else {
				gokFapiaoCaiwu.setXuhao("1");
			}
		}


		model.addAttribute("gokFapiaoCaiwu", gokFapiaoCaiwu);
		return "modules/gok/gokFapiaoCaiwuForm";
	}

	@RequiresPermissions("gok:gokFapiaoCaiwu:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(GokFapiaoCaiwu gokFapiaoCaiwu) {
		gokFapiaoCaiwuService.save(gokFapiaoCaiwu);
		return renderResult(Global.TRUE, "保存财务发票记录成功");
	}
	
	@RequiresPermissions("gok:gokFapiaoCaiwu:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GokFapiaoCaiwu gokFapiaoCaiwu) {
		gokFapiaoCaiwuService.delete(gokFapiaoCaiwu);
		return renderResult(Global.TRUE, "删除财务发票记录成功");
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("gok:gokFapiaoCaiwu:view")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public void exportFile(GokFapiaoCaiwu gokFapiaoCaiwu, HttpServletRequest request, HttpServletResponse response) {
		try {
            String fileName = "财务发票记录数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<GokFapiaoCaiwu> page = gokFapiaoCaiwuService.findPage(new Page<GokFapiaoCaiwu>(request, response, -1), gokFapiaoCaiwu);
    		new ExportExcel("财务发票记录数据", GokFapiaoCaiwu.class).setDataList(page.getList()).write(response, fileName).dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * 导入数据
	 */
	@RequiresPermissions("gok:gokFapiaoCaiwu:edit")
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
            List<GokFapiaoCaiwu> list = ei.getDataList(GokFapiaoCaiwu.class);
            for (GokFapiaoCaiwu gokFapiaoCaiwu : list) {
                try {
                    if (true) {
                        gokFapiaoCaiwuService.save(gokFapiaoCaiwu);
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
                failureMsg.insert(0, "，失败 " + failureNum + " 条财务发票记录，导入信息如下：");
            }
            return renderResult(Global.TRUE, "已成功导入 " + successNum + " 条财务发票记录" + failureMsg);
        } catch (Exception e) {
            return renderResult(Global.FALSE, "导入财务发票记录失败！失败信息：" + e.getMessage());
        }
    }

	/**
	 * 下载导入数据模板
	 */
	@RequiresPermissions("gok:gokFapiaoCaiwu:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response) {
		try {
            String fileName = "财务发票记录数据导入模板.xlsx";
    		List<GokFapiaoCaiwu> list = Lists.newArrayList();
    		list.add(new GokFapiaoCaiwu());
    		new ExportExcel("财务发票记录数据", GokFapiaoCaiwu.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/gok/gokFapiaoCaiwu/list";
    }

}