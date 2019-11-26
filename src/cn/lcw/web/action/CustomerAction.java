package cn.lcw.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lcw.domain.Customer;
import cn.lcw.service.CustomerService;
import cn.lcw.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	public Customer customer = new Customer();
	public CustomerService cs;
	private Integer currentPage;
	private Integer pageSize;
	
	
	public String list() throws Exception{
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if(StringUtils.isNoneBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		//调用service查询分页数据pageBean
		PageBean pb = cs.getPageBean(dc, currentPage, pageSize);
		//将pagebean放到request域，转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add() throws Exception{
		//1调用service保存customer对象
		cs.save(customer);
		//重定向到客户列表action
		return "toList";
	}

	
	
	
	public String toEdit() throws Exception{
		//调用service根据id获得客户对象
		Customer c = cs.getById(customer.getCust_id());
		//将客户对象放到request域，并转发到编辑页面
		ActionContext.getContext().put("customer", c);
		return "edit";
	}

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}


	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	/**
	 * @return the cs
	 */
	public CustomerService getCs() {
		return cs;
	}


	/**
	 * @param cs the cs to set
	 */
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}


	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}


	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}


	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
