package cn.lcw.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.lcw.domain.Customer;
import cn.lcw.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存客户方法
	void save(Customer customer);
	//根据id获得客户对象
	Customer getById(Long cust_id);
	

}
