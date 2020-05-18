package com.blog.mapper;

import java.util.List;

import com.blog.bean.Evaluation;


/**
 * 评价表表mapper
 * @author Xsj
 */
public interface IEvalationMapper {
	
	public List<Evaluation> selectAll(int bokeid);
	
	
} 
