package cn.lcw.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lcw.dao.LinkManDao;
import cn.lcw.domain.Customer;
import cn.lcw.domain.LinkMan;
import cn.lcw.service.LinkManService;
import cn.lcw.utils.PageBean;

public class LinkManServiceImpl implements LinkManService{

	private LinkManDao lmd;
	
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1调用dao查询总记录数
		int totalCount = lmd.getTotalCount(dc); 
		//2创建pagebean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3调用dao查询分页列表数据
		List<LinkMan> list = lmd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4列表数据放置pagebean中，并返回
		pb.setList(list);
		return pb;

	}
	
	//保存联系人
	public void save(LinkMan linkMan) {
		lmd.saveOrUpdate(linkMan);
	}
	//删除联系人
	public void delete(LinkMan lm) {
		lmd.delete(lm);
	}


	/**
	 * @return the lmd
	 */
	public LinkManDao getLmd() {
		return lmd;
	}


	/**
	 * @param lmd the lmd to set
	 */
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	@Override
	public LinkMan getById(Long lkm_id) {
		return lmd.getById(lkm_id);
	}


	
	
}
