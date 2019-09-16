package com.jsite.modules.sx.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.common.config.Global;
import com.jsite.common.lang.StringUtils;
import com.jsite.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import com.jsite.modules.sx.entity.SxDailyProc;
import com.jsite.modules.sx.service.SxDailyProcService;

/**
 * 实训流程Controller
 * @author 林鹏群
 * @version 2019-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/sx/sxDailyProc")
public class SxDailyProcController extends BaseController {

	@Autowired
	private SxDailyProcService sxDailyProcService;
	
	@ModelAttribute
	public SxDailyProc get(@RequestParam(required=false) String id, @RequestParam(required=false) String parentId) {
		SxDailyProc entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sxDailyProcService.get(id);
		}
		if (entity == null){
			entity = new SxDailyProc();
		}

		if(StringUtils.isNotBlank(parentId)) {
			entity.setParent(sxDailyProcService.get(parentId));
		}
		return entity;
	}
	
	@RequiresPermissions("sx:sxDailyProc:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/sx/sxDailyProcList";
	}

    @RequiresPermissions("sx:sxDailyProc:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public List<SxDailyProc> listData(SxDailyProc sxDailyProc) {

        if (sxDailyProc.getParent() == null || StringUtils.isBlank(sxDailyProc.getParent().getId())) {
            sxDailyProc.setParent(new SxDailyProc("0"));
        }
	    return sxDailyProcService.findList(sxDailyProc);
	}

	@RequiresPermissions("sx:sxDailyProc:view")
	@RequestMapping(value = "form")
	public String form(SxDailyProc sxDailyProc, Model model) {
		if (sxDailyProc.getParent() == null) {
            sxDailyProc.setParent(new SxDailyProc(SxDailyProc.getRootId()));
        }
		model.addAttribute("sxDailyProc", sxDailyProc);
		return "modules/sx/sxDailyProcForm";
	}

	@RequiresPermissions("sx:sxDailyProc:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(SxDailyProc sxDailyProc) {
		sxDailyProcService.save(sxDailyProc);
		return renderResult(Global.TRUE, "保存实训流程成功");
	}
	
	@RequiresPermissions("sx:sxDailyProc:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SxDailyProc sxDailyProc) {
		if (sxDailyProc.getIsRoot()){
            return renderResult(Global.FALSE, "删除实训流程失败, 不允许删除顶级实训流程或编号为空");
		}

		sxDailyProcService.delete(sxDailyProc);
		return  renderResult(Global.TRUE, "删除实训流程成功");
	}

	@RequiresPermissions("user")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<SxDailyProc> list = sxDailyProcService.findList(new SxDailyProc());
		for (int i=0; i<list.size(); i++){
			SxDailyProc e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParent().getId());
				map.put("pIds", e.getParentIds());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}