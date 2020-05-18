package com.blog.service;

import java.sql.Date;

import com.blog.bean.UserInfo;

public interface IUserInfoService {
	/**
	 * 用户登录
	 * @param uf
	 * @return
	 */
	public UserInfo login(UserInfo uf);
	
	/**
	 * 用户注册
	 * @param uf
	 * @return
	 */
	public int add(UserInfo uf);
	/**
	 * 用户显示
	 * @param userid
	 * @return
	 */
	public UserInfo findAll(Integer userid);
	/**用户修改
	 * 
	 * @param uf
	 * @return
	 */
	public int update(UserInfo uf);
	
	//添加评论
		public int addComment(int userid, int blogid, String content, String date);
		//博客评论数加一
		public int Updatecontent(int evaluationid);
		
		//添加回复
		public int addReply(int blogid, int eid, int to_id, int from_id, Date date, String content);
		//评论回复数加一
		public int commentUpdate(int id);
		
		//点赞
		public int addStar(int id, int type);
		public int insertStar(int uid, int cid, int type_id, int type, Date date);
		
		//取消赞
		public int subtractStar(int id, int type);
		public int deleteStar(int uid, int type_id, int type);
}
