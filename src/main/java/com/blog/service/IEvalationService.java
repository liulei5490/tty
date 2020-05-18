package com.blog.service;

import java.util.List;

import com.blog.bean.Evaluation;


/**
 * 评价表的service层
 * @author Xsj
 *
 */
public interface IEvalationService {
	
	public List<Evaluation> selectAll(int bokeid);
	
}
