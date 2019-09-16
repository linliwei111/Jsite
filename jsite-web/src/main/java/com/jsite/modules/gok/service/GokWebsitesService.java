package com.jsite.modules.gok.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.common.service.TreeService;
import com.jsite.common.lang.StringUtils;
import com.jsite.modules.gok.entity.GokWebsites;
import com.jsite.modules.gok.dao.GokWebsitesDao;

/**
 * 网站集锦Service
 * @author 网站集锦
 * @version 2019-03-29
 */
@Service
@Transactional(readOnly = true)
public class GokWebsitesService extends TreeService<GokWebsitesDao, GokWebsites> {

	public GokWebsites get(String id) {
		return super.get(id);
	}
	
	public List<GokWebsites> findList(GokWebsites gokWebsites) {
		if (StringUtils.isNotBlank(gokWebsites.getParentIds())){
			gokWebsites.setParentIds(","+gokWebsites.getParentIds()+",");
		}
		return super.findList(gokWebsites);
	}
	
	@Transactional(readOnly = false)
	public void save(GokWebsites gokWebsites) {
		super.save(gokWebsites);
	}
	
	@Transactional(readOnly = false)
	public void delete(GokWebsites gokWebsites) {
		super.delete(gokWebsites);
	}
	
}