package com.jsite.modules.sx.service;

import com.jsite.common.lang.StringUtils;
import com.jsite.common.service.TreeService;
import com.jsite.modules.sx.dao.SxDailyJobDao;
import com.jsite.modules.sx.entity.SxDailyJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实训攻略Service
 * @author 林鹏群
 * @version 2019-09-04
 */
@Service
@Transactional(readOnly = true)
public class SxDailyJobService extends TreeService<SxDailyJobDao, SxDailyJob> {
	@Autowired
	private SxDailyJobDao sxDailyJobDao;

	public SxDailyJob get(String id) {
		return super.get(id);
	}

	public List<SxDailyJob> findList(SxDailyJob sxDailyJob) {
		if (StringUtils.isNotBlank(sxDailyJob.getParentIds())){
			sxDailyJob.setParentIds(","+sxDailyJob.getParentIds()+",");
		}
		return super.findList(sxDailyJob);
	}

	@Transactional(readOnly = false)
	public void save(SxDailyJob sxDailyJob) {
		// 获取父节点实体
		SxDailyJob parent = this.getSxDailyJob(sxDailyJob.getParent().getId());
		String oldParentId = "";
		String oldParentIds = "";
		int oldParentTLevel = 0;

		if (sxDailyJob.getIsNewRecord()) {
			if (parent == null) {// 新增的根节点
				sxDailyJob.setTreeLeaf("1");
				sxDailyJob.setTreeLevel(0);
			} else {//新增的下级菜单
				sxDailyJob.setTreeLeaf("1");
				sxDailyJob.setTreeLevel(parent.getTreeLevel() + 1);
				if (parent.getIsTreeLeaf()) {
					parent.setTreeLeaf("0");
					sxDailyJobDao.update(parent);
				}
			}
		} else {
			// 数据库中当前的sxDailyJob的ParentId，还未更新
			oldParentId = getSxDailyJob(sxDailyJob.getId()).getParent().getId();
			// 获取修改前的parentIds，用于更新子节点的parentIds
			oldParentIds = sxDailyJob.getParentIds();

			SxDailyJob oldParent = getSxDailyJob(oldParentId);
			oldParentTLevel = oldParent == null ? -1 : oldParent.getTreeLevel();
		}

		// 设置新的父节点串
		sxDailyJob.setParentIds(parent == null ? "0," : (parent.getParentIds() + sxDailyJob.getParent().getId() + ","));

		// 保存或更新实体
		if (StringUtils.isBlank(sxDailyJob.getId())) {
			sxDailyJob.preInsert();
			sxDailyJobDao.insert(sxDailyJob);
		} else {
			sxDailyJob.preUpdate();
			sxDailyJobDao.update(sxDailyJob);

			// 判断sxDailyJob父节点是否发生了改变
			// 1.sxDailyJob修改父节点的情况： 如果原来的父节点只有一个子节点，sxDailyJob修改了父节点之后，
			//   原来的父节点没有子节点了，对应的需要修改原来的父节点的treeLeaf属性为1
			// 2.如果sxDailyJob父节点发生了改变，sxDailyJob的所有子节点的parentIds、treeLevel都需要更新
			if (!oldParentId.equals(sxDailyJob.getParent().getId())) {
				// 第一步：判断原来的父节点下还有没有子菜单
				SxDailyJob oldParent = getSxDailyJob(oldParentId);
				if (oldParent != null) {
					List<SxDailyJob> list1 = sxDailyJobDao.findSubSxDailyJobListByPid(oldParent);
					// 原来的父节点下没有子节点了，并且节点treeleaf属性不等于1
					if (list1.size() <= 0 && !oldParent.getIsTreeLeaf()) {
						oldParent.setTreeLeaf("1");
						sxDailyJobDao.update(oldParent);
					}
				}

				// 第二步：1.更新子节点 parentIds
				// 2.sxDailyJob修改了父节点，则需要根据修改后的父节点treeLevel，
				//   更新sxDailyJob及sxDailyJob子节点的treelevel值，这样才能保证树结构的层级
				SxDailyJob m = new SxDailyJob();
				m.setParentIds("%," + sxDailyJob.getId() + ",%");
				List<SxDailyJob> list2 = sxDailyJobDao.findByParentIdsLike(m);

				SxDailyJob newParent = getSxDailyJob(sxDailyJob.getParent().getId());
				int diffValue = newParent.getTreeLevel() - oldParentTLevel;

				// 更新sxDailyJob的treelevel值
				sxDailyJob.setTreeLevel(sxDailyJob.getTreeLevel() + diffValue);
				sxDailyJobDao.update(sxDailyJob);

				for (SxDailyJob e : list2) {
					// 更新子节点 parentIds
					e.setParentIds(e.getParentIds().replace(oldParentIds, sxDailyJob.getParentIds()));
					// 更新sxDailyJob子节点的treelevel值
					e.setTreeLevel(e.getTreeLevel() + diffValue);
					sxDailyJobDao.updateParentIds(e);
				}

				// 第三步：新父节点如果treeLeaf==1，则需要更新treeLeaf==0
				if (newParent.getIsTreeLeaf()) {
					newParent.setTreeLeaf("0");
					sxDailyJobDao.update(newParent);
				}
			}
		}
	}

	private SxDailyJob getSxDailyJob(String id) {
		return sxDailyJobDao.get(id);
	}

	@Transactional(readOnly = false)
	public void delete(SxDailyJob sxDailyJob) {
		super.delete(sxDailyJob);
	}

	@Transactional(readOnly = false)
    public void updateSxDailyJobSort(SxDailyJob sxDailyJob) {
		sxDailyJobDao.updateSort(sxDailyJob);
    }
	@Transactional(readOnly = false)
	public void updateSxDailyJobScore(SxDailyJob sxDailyJob) {
		sxDailyJobDao.updateScore(sxDailyJob);
	}
}
