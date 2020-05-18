package com.blog.service;

import java.util.List;

import com.blog.bean.AdminInfo;


public interface IAdminInfoService {
	public List<AdminInfo> findAll();
	
	public AdminInfo login(AdminInfo af);
}
