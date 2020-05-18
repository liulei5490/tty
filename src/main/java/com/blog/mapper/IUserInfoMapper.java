package com.blog.mapper;

import java.util.List;
import java.util.Map;

import com.blog.bean.UserInfo;


public interface IUserInfoMapper {
	/**
	 * 注册用户
	 * @param uf
	 * @return
	 */
	public int  add (UserInfo uf);
	
	/**
	 * 用户登录
	 * @param uf
	 * @return
	 */
	public UserInfo login(UserInfo uf);
	
	/**
	 * 用户显示
	 * @param userid
	 * @return
	 */
	public UserInfo findAll(Integer userid);
	/**
	 * 用户修改
	 * @param uf
	 * @return
	 */
	public int update(UserInfo uf);
	
	//添加评论
		public int addComment(Map<String, Object> map);
		//博客评论数加一
		public int Updatecontent(int id);
		
		//添加回复
		public int addReply(Map<String, Object> map);
		//评论回复数加一
		public int commentUpdate(int id);
		
		//点赞
		public int addStar(Map<String, Object> map);
		public int insertStar(Map<String, Object> map);
		
		//取消赞
		public int subtractStar(Map<String, Object> map);
		public int deleteStar(Map<String, Object> map);
		
		/*//获取用户回复
		public List<Message> getReply(int id);
		//获取用户点赞
		public List<Message> getGreat(int id);
		//获取系统通知
		public List<Message> getSys_notice();*/
		
		//修改消息为已读
		public int updateMessage(Map<String, Object> map);
}
