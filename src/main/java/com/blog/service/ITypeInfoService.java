package com.blog.service;

import java.util.List;

import com.blog.bean.TypeInfo;


public interface ITypeInfoService {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<TypeInfo> findAll();
	
	/**
	 * 查询所有
	 * type
	 * @return
	 */
	public List<TypeInfo> finds();
}
