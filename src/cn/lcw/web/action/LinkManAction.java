package cn.lcw.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lcw.domain.Customer;
import cn.lcw.domain.LinkMan;
import cn.lcw.service.LinkManService;
import cn.lcw.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkMan linkMan = new LinkMan();
	
	public LinkManService lms;
	
	private Integer currentPage;
	private Integer pageSize;
	
	
	public String list() throws Exception{
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		//判断并封装参数
		
		if(StringUtils.isNoneBlank(linkMan.getLkm_name())) {
			  dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		 
		if(linkMan.getCustomer()!=null &&linkMan.getCustomer().getCust_id()!=null) {
			  dc.add(Restrictions.eq("customer.cust_id",linkMan.getCustomer().getCust_id() ));
		}
		
		//调用service查询分页数据pageBean
		PageBean pb = lms.getPageBean(dc, currentPage, pageSize);
		//将pagebean放到request域，转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	
	public String add() throws Exception {
		//调用service
		lms.save(linkMan);
		//重定向到联系人列表
		return "toList";
	}

	
	public String toEdit() throws Exception {
		//调用service,，查询linkMan
		LinkMan lm = lms.getById(linkMan.getLkm_id());
		//将查询的linkMan对象放入request域,转发到添加页面
		ActionContext.getContext().put("linkMan", lm);
		return "add";
	}

	
	public String delete() throws Exception {
		//调用service,，查询linkMan
		LinkMan lm = lms.getById(linkMan.getLkm_id());

		lms.delete(lm);
		return "toList";
	}


	/**
	 * @param lms the lms to set
	 */
	public void setLms(LinkManService lms) {
		this.lms = lms;
	}




	@Override
	public LinkMan getModel() {
		
		return linkMan;
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
