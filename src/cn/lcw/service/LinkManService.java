package cn.lcw.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.lcw.domain.LinkMan;
import cn.lcw.utils.PageBean;

public interface LinkManService {
	//保存联系人
	void save(LinkMan linkMan);
	//联系人客户列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//根据id获得linkman对象
	LinkMan getById(Long lkm_id);
	void delete(LinkMan lm);
}
