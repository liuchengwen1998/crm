package cn.lcw.service;

import java.util.List;

import cn.lcw.domain.BaseDict;

public interface BaseDictService {

	//根据数字字典类型字段获得数据字典对象
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
