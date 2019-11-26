package cn.lcw.domain;


/*
 * CREATE TABLE `base_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class BaseDict {
	private String dict_id;
	private String dict_type_code;
	private String dict_type_name;
	private String dict_item_name;
	private String dict_item_code;
	private String dict_memo;
	private int dict_sort;
	private Character dict_enable;
	/**
	 * @return the dict_id
	 */
	public String getDict_id() {
		return dict_id;
	}
	/**
	 * @param dict_id the dict_id to set
	 */
	public void setDict_id(String dict_id) {
		this.dict_id = dict_id;
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
	 * @return the dict_type_name
	 */
	public String getDict_type_name() {
		return dict_type_name;
	}
	/**
	 * @param dict_type_name the dict_type_name to set
	 */
	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}
	/**
	 * @return the dict_item_name
	 */
	public String getDict_item_name() {
		return dict_item_name;
	}
	/**
	 * @param dict_item_name the dict_item_name to set
	 */
	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}
	/**
	 * @return the dict_item_code
	 */
	public String getDict_item_code() {
		return dict_item_code;
	}
	/**
	 * @param dict_item_code the dict_item_code to set
	 */
	public void setDict_item_code(String dict_item_code) {
		this.dict_item_code = dict_item_code;
	}
	/**
	 * @return the dict_memo
	 */
	public String getDict_memo() {
		return dict_memo;
	}
	/**
	 * @param dict_memo the dict_memo to set
	 */
	public void setDict_memo(String dict_memo) {
		this.dict_memo = dict_memo;
	}
	/**
	 * @return the dict_sort
	 */
	public int getDict_sort() {
		return dict_sort;
	}
	/**
	 * @param dict_sort the dict_sort to set
	 */
	public void setDict_sort(int dict_sort) {
		this.dict_sort = dict_sort;
	}
	/**
	 * @return the dict_enable
	 */
	public Character getDict_enable() {
		return dict_enable;
	}
	/**
	 * @param dict_enable the dict_enable to set
	 */
	public void setDict_enable(Character dict_enable) {
		this.dict_enable = dict_enable;
	}
	
	
}
