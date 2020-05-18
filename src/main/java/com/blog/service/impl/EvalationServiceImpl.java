package com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.bean.Evaluation;
import com.blog.mapper.IEvalationMapper;
import com.blog.service.IEvalationService;



@Service
public class EvalationServiceImpl implements IEvalationService{
	
	@Autowired
	private IEvalationMapper evaluation;

	@Override
	public List<Evaluation> selectAll(int bokeid) {
		// TODO Auto-generated method stub
		return evaluation.selectAll(bokeid);
	}
	
	
	
	
}
