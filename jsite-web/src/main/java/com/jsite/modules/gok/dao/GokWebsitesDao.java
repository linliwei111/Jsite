package com.jsite.modules.gok.dao;

import com.jsite.common.persistence.TreeDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.gok.entity.GokWebsites;

/**
 * 网站集锦DAO接口
 * @author 网站集锦
 * @version 2019-03-29
 */
@MyBatisDao
public interface GokWebsitesDao extends TreeDao<GokWebsites> {
	
}