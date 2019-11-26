package cn.lcw.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.lcw.dao.UserDao;
import cn.lcw.domain.User;
import cn.lcw.service.UserService;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{
	
	private UserDao ud;
	
	@Override
	public User getUserByCodePassword(User u) {
			//1 根据登陆名称查询登陆用户
			User existU = ud.getByUserCode(u.getUser_code());
			//2 判断用户是否存在.不存在=>抛出异常,提示用户名不存在
			if(existU==null){
				throw new RuntimeException("用户名不存在!");
			}
			//3 判断用户密码是否正确=>不正确=>抛出异常,提示密码错误
			if(!existU.getUser_password().equals(u.getUser_password())){
				throw new RuntimeException("密码错误!");
			}
			//4 返回查询到的用户对象
		
		return existU;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void regist(User user) {
		//1调用dao根据注册的用户名获得用户对象
		User existU = ud.getByUserCode(user.getUser_code());
		//如果获得到user对象，用户名已经存在
		if(existU!=null) {
			throw new RuntimeException("用户名已经存在");
		}
		//调用dao执行保存
		ud.save(user);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
