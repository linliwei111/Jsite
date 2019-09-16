package com.jsite.modules.gok.web;

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
import com.jsite.modules.gok.entity.GokWebsites;
import com.jsite.modules.gok.service.GokWebsitesService;

/**
 * 网站集锦Controller
 * @author 网站集锦
 * @version 2019-03-29
 */
@Controller
@RequestMapping(value = "${adminPath}/gok/gokWebsites")
public class GokWebsitesController extends BaseController {

	@Autowired
	private GokWebsitesService gokWebsitesService;
	
	@ModelAttribute
	public GokWebsites get(@RequestParam(required=false) String id, @RequestParam(required=false) String parentId) {
		GokWebsites entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gokWebsitesService.get(id);
		}
		if (entity == null){
			entity = new GokWebsites();
		}

		if(StringUtils.isNotBlank(parentId)) {
			entity.setParent(gokWebsitesService.get(parentId));
		}
		return entity;
	}
	
	@RequiresPermissions("gok:gokWebsites:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/gok/gokWebsitesList";
	}

    @RequiresPermissions("gok:gokWebsites:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public List<GokWebsites> listData(GokWebsites gokWebsites) {

        if (gokWebsites.getParent() == null || StringUtils.isBlank(gokWebsites.getParent().getId())) {
            gokWebsites.setParent(new GokWebsites("0"));
        }
	    return gokWebsitesService.findList(gokWebsites);
	}

	@RequiresPermissions("gok:gokWebsites:view")
	@RequestMapping(value = "form")
	public String form(GokWebsites gokWebsites, Model model) {
		if (gokWebsites.getParent() == null) {
            gokWebsites.setParent(new GokWebsites(GokWebsites.getRootId()));
        }
		model.addAttribute("gokWebsites", gokWebsites);
		return "modules/gok/gokWebsitesForm";
	}

	@RequiresPermissions("gok:gokWebsites:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(GokWebsites gokWebsites) {
		gokWebsitesService.save(gokWebsites);
		return renderResult(Global.TRUE, "保存网站集锦成功");
	}
	
	@RequiresPermissions("gok:gokWebsites:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GokWebsites gokWebsites) {
		if (gokWebsites.getIsRoot()){
            return renderResult(Global.FALSE, "删除网站集锦失败, 不允许删除顶级网站集锦或编号为空");
		}

		gokWebsitesService.delete(gokWebsites);
		return  renderResult(Global.TRUE, "删除网站集锦成功");
	}

	@RequiresPermissions("user")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<GokWebsites> list = gokWebsitesService.findList(new GokWebsites());
		for (int i=0; i<list.size(); i++){
			GokWebsites e = list.get(i);
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