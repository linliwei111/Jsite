package com.jsite.modules.sx.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.common.config.Global;
import com.jsite.common.lang.StringUtils;
import com.jsite.common.web.BaseController;
import com.jsite.modules.sx.entity.SxDailyJob;
import com.jsite.modules.sx.service.SxDailyJobService;
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

/**
 * 实训攻略Controller
 * @author 林鹏群
 * @version 2019-09-04
 */
@Controller
@RequestMapping(value = "${adminPath}/sx/sxDailyJob")
public class SxDailyJobController extends BaseController {

	@Autowired
	private SxDailyJobService sxDailyJobService;

	@ModelAttribute
	public SxDailyJob get(@RequestParam(required=false) String id, @RequestParam(required=false) String parentId) {
		SxDailyJob entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sxDailyJobService.get(id);
		}
		if (entity == null){
			entity = new SxDailyJob();
		}

		if(StringUtils.isNotBlank(parentId)) {
			entity.setParent(sxDailyJobService.get(parentId));
		}
		return entity;
	}

	@RequiresPermissions("sx:sxDailyJob:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "modules/sx/sxDailyJobList";
	}

    @RequiresPermissions("sx:sxDailyJob:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public List<SxDailyJob> listData(SxDailyJob sxDailyJob) {

        if (sxDailyJob.getParent() == null || StringUtils.isBlank(sxDailyJob.getParent().getId())) {
            sxDailyJob.setParent(new SxDailyJob("0"));
        }
	    return sxDailyJobService.findList(sxDailyJob);
	}

	@RequiresPermissions("sx:sxDailyJob:view")
	@RequestMapping(value = "form")
	public String form(SxDailyJob sxDailyJob, Model model) {
		if (sxDailyJob.getParent() == null) {
            sxDailyJob.setParent(new SxDailyJob(SxDailyJob.getRootId()));
        }

		// 获取排序号，最末节点排序号+30
		if (StringUtils.isBlank(sxDailyJob.getId())){
			List<SxDailyJob> list = Lists.newArrayList();
			List<SxDailyJob> sourcelist = sxDailyJobService.findList(new SxDailyJob());
			SxDailyJob.sortList(list, sourcelist, sxDailyJob.getParent().getId(), false);
			if (list.size() > 0){
				sxDailyJob.setSort(list.get(list.size()-1).getSort() + 10);
			}
		}
		model.addAttribute("sxDailyJob", sxDailyJob);
		return "modules/sx/sxDailyJobForm";
	}

	@RequiresPermissions("sx:sxDailyJob:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(SxDailyJob sxDailyJob) {
		sxDailyJobService.save(sxDailyJob);
		return renderResult(Global.TRUE, "保存实训攻略成功");
	}

	@RequiresPermissions("sx:sxDailyJob:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SxDailyJob sxDailyJob) {
		if (sxDailyJob.getIsRoot()){
            return renderResult(Global.FALSE, "删除实训攻略失败, 不允许删除顶级实训攻略或编号为空");
		}

		sxDailyJobService.delete(sxDailyJob);
		return  renderResult(Global.TRUE, "删除实训攻略成功");
	}

	@RequiresPermissions("user")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<SxDailyJob> list = sxDailyJobService.findList(new SxDailyJob());
		for (int i=0; i<list.size(); i++){
			SxDailyJob e = list.get(i);
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


	/**
	 * 批量修改菜单排序
	 */
	@RequiresPermissions("sx:sxDailyJob:edit")
	@RequestMapping(value = "updateSort")
	@ResponseBody
	public String updateSort(String[] ids, Integer[] sorts, String[] targets) {
		if(Global.isDemoMode()){
			return renderResult(Global.FALSE, "演示模式，不允许操作！");
		}

		for (int i = 0; i < ids.length; i++) {
			SxDailyJob sxDailyJob = new SxDailyJob(ids[i]);
			sxDailyJob.setSort(sorts[i]);
			sxDailyJobService.updateSxDailyJobSort(sxDailyJob);
		}
		for (int i = 0; i < ids.length; i++) {
			SxDailyJob sxDailyJob = new SxDailyJob(ids[i]);
			sxDailyJob.setTarget(targets[i]);
			sxDailyJobService.updateSxDailyJobScore(sxDailyJob);
		}
		return renderResult(Global.TRUE, "保存菜单排序成功!");
	}
}
