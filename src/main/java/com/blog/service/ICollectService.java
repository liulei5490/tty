package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.bean.Collect;


public interface ICollectService {
	/**
	 * 点击收藏博客
	 * @param cl
	 * @return
	 */
	public int addBlog(Collect cl);
	
	
	/**
	 * 查询所有收藏博客
	 * @return
	 */
	public List<Map<String,Object>> finds(Integer page,Integer rows);
	
	/**
	 * 根据收藏ID分页查询
	 * @param map
	 * @return
	 */
	public List<Collect> findByType (Integer blogid, int page, int rows);
	
	/**
	 * 根据收藏博客编号，查询搜藏博客信息
	 * @param blogid
	 * @return
	 */
	public List<Collect> findByCid(Collect collect);
	
	public Map<String, Object> findByFirst(Integer blogid, int page, int rows);
	
	/**
	 * 根据类型获取博客数量
	 * @param type
	 * @return
	 */
	public Integer getTotalByCid();
	
	public int addCollect(Collect collect);
	
	public int delCollect(Collect collect);
	
	public List<Collect> findAll(int userid);

}
