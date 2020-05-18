package com.blog.service.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.bean.Collect;
import com.blog.mapper.ICollectMapper;
import com.blog.service.ICollectService;


@Service
public class CollectServiceImpl implements ICollectService{

	@Autowired
	private ICollectMapper mapper;
	
	
	@Override
	public int addBlog(Collect cl) {
		return mapper.addBlog(cl);
	}

	

	@Override
	public List<Collect> findByType(Integer bokeid, int page, int rows) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		map.put("bokeid", bokeid);
		return mapper.findByType(map);
	}

	@Override
	public List<Map<String, Object>> finds(Integer page,Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		return mapper.finds(map);
	}



	@Override
	public Map<String, Object> findByFirst(Integer bokeid, int page, int rows) {
		return null;
	}



	@Override
	public Integer getTotalByCid() {
		return mapper.getTotalByCid();
	}



	@Override
	public List<Collect> findByCid(Collect collect) {
		return mapper.findByCid(collect);
	}



	@Override
	public int addCollect(Collect collect) {
		// TODO Auto-generated method stub
		return mapper.addCollect(collect);
	}



	@Override
	public int delCollect(Collect collect) {
		// TODO Auto-generated method stub
		return mapper.delCollect(collect);
	}



	@Override
	public List<Collect> findAll(int userid) {
		return mapper.findAll(userid);
	}





	

	
	

}
