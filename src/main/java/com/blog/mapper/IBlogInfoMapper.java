package com.blog.mapper;

import java.util.List;
import java.util.Map;


import com.blog.bean.BlogInfo;


public interface IBlogInfoMapper {
	/**
	 * 添加博客
	 * @param bf
	 * @return
	 */
	public int add(BlogInfo bf);
	
	/**
	 * 查询所有博客
	 * @return
	 */
	public List<BlogInfo> findAll();
	
	/**
	 * 根据博客类型分页查询
	 * @param map
	 * @return
	 */
	public List<BlogInfo> findByType (Map<String, Integer> map);
	
	/**
	 * 根据博客编号，查询博客信息
	 * @param bokeid
	 * @return
	 */
	public List<BlogInfo> findByBlogid(Integer userid, int page, int rows);
	
	public List<BlogInfo> findByFirst(Integer userid, int page, int rows);
	
	/**
	 * 根据类型获取博客数量
	 * @param type
	 * @return
	 */
	public int getTotalByUserId(Integer userid);
	
	
	/**
	 * 根据用户id查询出最近更新的几条博客
	 * @param bokeid
	 * @return
	 */
	public List<BlogInfo> recentUpdata(BlogInfo boke);
	
	
	/**
	 * 根据查询出点击量最高的几条博客
	 * @param 
	 * @return
	 */
	public List<BlogInfo> clicRankList(int limitNum);
	
	/**
	 * 根据类型获取博客数量
	 * @param type
	 * @return
	 */
	public int getTotal(Integer type);
	
	
	/**
	 * 获取除自己的博客之外之外博客数量
	 * @param type
	 * @return
	 */
	public int getAllTotalExceptSelf(BlogInfo bf);
	
	
	/**
	 * 获取自己的博客数量
	 * @param type
	 * @return
	 */
	public int getSelfBlogTotal(BlogInfo bf);
	
	/**
	 * 随机查询出多条记录
	 * @param topNum	查询出记录的值
	 * @return	查询出的记录
	 */
	public List<BlogInfo> getRand(BlogInfo bf);
	
	
	
	
	/**
	 * 根据博客编号，查询博客信息
	 * @param bokeid
	 * @return
	 */
	public List<BlogInfo> findByBlogid(int bokeid, int page, int rows);
	
	
	/**
	 * 多表查询
	 * @return
	 */
	public  Map<String,Object> finds(Integer bokeid);
	
	public int addread(int bokeid);
}
