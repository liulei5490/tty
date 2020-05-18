package com.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.bean.Collect;
import com.blog.bean.UserInfo;
import com.blog.service.ICollectService;


@RestController
@RequestMapping("/collect")
@ResponseBody
public class CollectController {
	
	@Autowired
	private ICollectService service;
	
	@RequestMapping("/finds")
	public List<Map<String, Object>> finds(Integer page){
		int rows = 5;
		return service.finds(page,rows);
	}
	
	@RequestMapping("/addBlog")
	public int addBlog(Collect cl) {
		return service.addBlog(cl);
	}
	
	@RequestMapping("/findByType")
	public List<Collect> findByType (Integer blogid, int page, int rows ){
			return service.findByType(blogid, page, rows);
		
	}
	
	@RequestMapping("/findByFirst")
	public Map<String, Object> findByFirst(Integer blogid, int page, int rows){
		System.out.println("blogid=" + blogid);
		return service.findByFirst(blogid, page, rows);
		
	}
	@RequestMapping("/total")
	public Integer getTotalByCid(){
		return service.getTotalByCid();
	}
	
	@RequestMapping("/isLogin")
	public int isLogin (HttpSession session){
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		if (userInfo == null){
			return -1;
		}
		return 1;
	}
}
