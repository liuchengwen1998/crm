package cn.lcw.service;

import cn.lcw.domain.User;

public interface UserService {
	//登陆方法
	User getUserByCodePassword(User u);
	//注册用户
	void regist(User user);
}
