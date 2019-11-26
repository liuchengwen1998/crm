package cn.lcw.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {

	//增或修改
	void saveOrUpdate(T t);
	//增
	void save(T t);
	//删
	void delete(T t);
	//删		所有作为id的类型都是Serializable的实现类
	void delete(Serializable id);
	//改
	void update(T t);
	//查  根据id
	T getById(Serializable id);
	//查询符合条件的总记录数
	Integer getTotalCount(DetachedCriteria dc);
	//查 查询分页列表数据
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
}
