package cn.lcw.service.impl;

import java.util.List;

import cn.lcw.dao.BaseDictDao;
import cn.lcw.domain.BaseDict;
import cn.lcw.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService{

	private BaseDictDao bdd;
	
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		
		return bdd.getListByTypeCode(dict_type_code);
	}

	/**
	 * @return the bdd
	 */
	public BaseDictDao getBdd() {
		return bdd;
	}

	/**
	 * @param bdd the bdd to set
	 */
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}


	
}
