package cn.lcw.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lcw.dao.CustomerDao;
import cn.lcw.domain.Customer;
import cn.lcw.service.CustomerService;
import cn.lcw.utils.PageBean;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao cd;

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1调用dao查询总记录数
		int totalCount = cd.getTotalCount(dc); 
		//2创建pagebean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3调用dao查询分页列表数据
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4列表数据放置pagebean中，并返回
		pb.setList(list);
		return pb;

	}
	
	//保存客户
	public void save(Customer customer) {
		//维护customer与数据字典的关系，由于struts2的参数封装，会将参数封装到数据字典的id属性，
		//无需手动维护关系，直接进行下一步。
		//调用dao保存客户
		cd.saveOrUpdate(customer);
	}
	public Customer getById(Long cust_id) {
		
		return cd.getById(cust_id);
	}

	/**
	 * @param cd the cd to set
	 */
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}


	

	
}
