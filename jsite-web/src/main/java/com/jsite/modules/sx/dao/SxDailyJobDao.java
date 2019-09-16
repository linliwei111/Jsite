package com.jsite.modules.sx.dao;

import com.jsite.common.persistence.TreeDao;
import com.jsite.common.persistence.annotation.MyBatisDao;
import com.jsite.modules.sx.entity.SxDailyJob;

import java.util.List;

/**
 * 实训攻略DAO接口
 * @author 林鹏群
 * @version 2019-09-04
 */
@MyBatisDao
public interface SxDailyJobDao extends TreeDao<SxDailyJob> {

    public int updateSort(SxDailyJob sxDailyJob);

    public List<SxDailyJob> findSubSxDailyJobListByPid(SxDailyJob oldParent);

    public int updateScore(SxDailyJob sxDailyJob);
}
