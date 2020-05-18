package com.blog.service;

import java.util.List;

import com.blog.bean.Respond;


/**
 * 回复表的service层
 * @author Xsj
 *
 */
public interface IRespondService {
	
	public List<Respond> selectAll(int bokeid);
	
	public int addOne(Respond rspond);
	
}
