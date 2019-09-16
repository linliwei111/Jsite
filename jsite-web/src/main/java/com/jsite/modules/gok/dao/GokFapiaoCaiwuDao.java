/**
 * Copyright &copy; 2017-2019 <a href="https://gitee.com/baseweb/JSite">JSite</a> All rights reserved.
 */
package com.jsite.modules.gok.dao;

import com.jsite.common.persistence.CrudDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.gok.entity.GokFapiaoCaiwu;

/**
 * 财务发票记录DAO接口
 * @author 财务发票记录
 * @version 2019-04-08
 */
@MyBatisDao
public interface GokFapiaoCaiwuDao extends CrudDao<GokFapiaoCaiwu> {
    public String findMaxXuhao();
}