package cn.lcw.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.lcw.domain.BaseDict;
import cn.lcw.service.BaseDictService;
import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport{

	private String dict_type_code;
	private BaseDictService baseDictService;
	public String execute() throws Exception{
		
		//调用Service根据typecode获得数据字典对象list
		List<BaseDict> list =  baseDictService.getListByTypeCode(dict_type_code);
		//将list转化为json格式
		String json = JSONArray.fromObject(list).toString();
		
		//将json发送给服务器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;//告诉struts2不需要进行任何处理
		
	}
	/**
	 * @return the dict_type_code
	 */
	public String getDict_type_code() {
		return dict_type_code;
	}
	/**
	 * @param dict_type_code the dict_type_code to set
	 */
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	/**
	 * @return the baseDictService
	 */
	public BaseDictService getBaseDictService() {
		return baseDictService;
	}
	/**
	 * @param baseDictService the baseDictService to set
	 */
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}


	
	
}
