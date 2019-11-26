package cn.lcw.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lcw.domain.User;
import cn.lcw.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();

	private UserService userService;

	private Object checkcode;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		//获取Action的请求request
		HttpServletRequest request = ServletActionContext.getRequest();
		//request中获取表单数据
		String code_enter = request.getParameter("checkcode");
		//获取session中正确的验证码
		String code = (String) ActionContext.getContext().getSession().get("verificationCode");
		System.out.println(code);
		//比对结果，如果为假抛出异常
		if(code ==null || !code.equals(code_enter)){
			throw new RuntimeException("验证码错误");
		}
		System.out.println("confirm pass");
		//1 调用Service执行登陆逻辑
		User u = userService.getUserByCodePassword(user);
		//2 将返回的User对象放入session域
		ActionContext.getContext().getSession().put("user", u);
		//3 重定向到项目首页			
		return "toHome";
	}

	public String regist() throws Exception {
		// 1 调用Service执保存注册用户
		try {
			userService.regist(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		// 重定向到登录页面
		return "toLogin";
	}

	@Override
	public User getModel() {
		return user;
	}

}
