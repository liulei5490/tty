package com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.bean.Respond;
import com.blog.mapper.IRespondMapper;
import com.blog.service.IRespondService;



@Service
public class RespnodServiceImpl implements IRespondService{
	
	@Autowired
	private IRespondMapper respond;

	@Override
	public List<Respond> selectAll(int bokeid) {
		// TODO Auto-generated method stub
		return respond.selectAll(bokeid);
	}

	@Override
	public int addOne(Respond rspond) {
		// TODO Auto-generated method stub
		return respond.addOne(rspond);
	}
	
	
	
	
}
