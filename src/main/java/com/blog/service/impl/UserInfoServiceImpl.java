package com.blog.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.bean.UserInfo;
import com.blog.mapper.IUserInfoMapper;
import com.blog.service.IUserInfoService;
import com.blog.util.StringUtil;


@Service
public class UserInfoServiceImpl implements IUserInfoService{
	
	@Autowired
	private IUserInfoMapper mapper;
	
	@Override
	public UserInfo login(UserInfo uf) {
		if (StringUtil.isNull(uf.getUsername(),uf.getUserpass())){
			return null;
		}
		return mapper.login(uf);
	}

	@Override
	public int add(UserInfo uf) {
		 if (StringUtil.isNull(uf.getUsername(),uf.getUserpass(),uf.getRealname(),uf.getContackway(),uf.getBirthday(),uf.getSex(),uf.getAddress(),uf.getWork(),uf.getEmail())){
			 return -1;
		 }
		return mapper.add(uf);
	}
	
	

	@Override
	public int addComment(int uid, int cid, String content, String date) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("cid", cid);
		map.put("content", content);
		map.put("date", date);
		return mapper.addComment(map);
	}
	
	
	//点赞
	@Override
	public int addStar(int id, int type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("type", type);
		return mapper.addStar(map);
	}
	
	@Override
	public int insertStar(int uid, int cid, int type_id, int type, Date date) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("cid", cid);
		map.put("type_id", type_id);
		map.put("type", type);
		map.put("date", date);
		return mapper.insertStar(map);
	}

	//取消赞
	@Override
	public int subtractStar(int id, int type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("type", type);
		return mapper.subtractStar(map);
	}
	
	@Override
	public int deleteStar(int uid, int type_id, int type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("type_id", type_id);
		map.put("type", type);
		return mapper.deleteStar(map);
	}

	@Override
	public int Updatecontent(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addReply(int cid, int comment_id, int to_uid, int from_uid, Date date, String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("comment_id", comment_id);
		map.put("to_uid", to_uid);
		map.put("from_uid", from_uid);
		map.put("date", date);
		map.put("content", content);
		return mapper.addReply(map);
	}

	@Override
	public int commentUpdate(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo findAll(Integer userid) {
		if (StringUtil.isNull(userid)) {
			return null;
		}
		return mapper.findAll(userid);
	}

	@Override
	public int update(UserInfo uf) {

		return mapper.update(uf);
	}

	
	

}
