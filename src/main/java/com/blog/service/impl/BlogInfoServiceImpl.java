package com.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.bean.BlogInfo;
import com.blog.mapper.IBlogInfoMapper;
import com.blog.mapper.ITypeInfoMapper;
import com.blog.service.IBlogInfoService;
import com.blog.util.StringUtil;


@Service
public class BlogInfoServiceImpl implements IBlogInfoService{
	
	@Autowired
	private IBlogInfoMapper mapper;
	
	@Autowired
	private ITypeInfoMapper typemapper;

	
	@Override
	public int add(BlogInfo bf) {
		if (StringUtil.isNull(bf.getUserid(),bf.getPics())){
			return -1;
		}
		return mapper.add(bf);
	}



	@Override
	public List<BlogInfo> findAll() {
		return mapper.findAll();
	}

	

	

	@Override
	public List<BlogInfo> getRand(BlogInfo bf) {
		return mapper.getRand(bf);
	}

	@Override
	public int getAllTotalExceptSelf(BlogInfo bf) {
		// TODO Auto-generated method stub
		return mapper.getAllTotalExceptSelf(bf);
	}

	@Override
	public List<BlogInfo> recentUpdata(BlogInfo blog) {
		// TODO Auto-generated method stub
		return mapper.recentUpdata(blog);
	}

	@Override
	public int getSelfBlogTotal(BlogInfo bf) {
		// TODO Auto-generated method stub
		return mapper.getSelfBlogTotal(bf);
	}

	@Override
	public List<BlogInfo> clicRankList(int limitNum) {
		// TODO Auto-generated method stub
		return mapper.clicRankList(limitNum);
	}

	

	@Override
	public Map<String, Object> finds(Integer blogid) {
		return mapper.finds(blogid);
	}

	@Override
	public int addread(int blogid) {
		return mapper.addread(blogid);
	}




	@Override
	public List<BlogInfo> findByType(Integer userid, int page, int rows) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",(page-1)*rows);
		map.put("rows", rows);
		map.put("userid", userid);
		return mapper.findByType(map);
	}



	@Override
	public List<BlogInfo> findByBlogid(Integer userid, int page, int rows) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",(page-1)*rows);
		map.put("rows", rows);
		map.put("tno", userid);
		
		return mapper.findByType(map);
	}



	@Override
	public Map<String, Object> findByFirst(Integer userid, int page, int rows) {
		List<BlogInfo> blog = this.findByType(userid, page, rows);
		int total = mapper.getTotalByUserId(userid);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("blog", blog);
		resultMap.put("total", total);
		return resultMap;
	}



	@Override
	public int getTotalByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return mapper.getTotalByUserId(userid);
	}

}
