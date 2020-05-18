package com.blog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.bean.Evaluation;
import com.blog.bean.UserInfo;
import com.blog.service.IBlogInfoService;
import com.blog.service.IUserInfoService;
import com.blog.util.SendMailUtil;




@RestController
@RequestMapping("/userInfo")
@ResponseBody
public class UserInfoController {
	
	@Autowired
	private IUserInfoService service;
	
	@Autowired
	private IBlogInfoService bloginfoService;
	
	@Autowired
	private BlogInfoController bloginfoController;
	
	private SendMailUtil sendMailutil = new SendMailUtil("1293580602@qq.com", "dihpepdwtahlgefh");
	
	@RequestMapping("/code")
	public int code(String name,String email,HttpSession session){
		int result = -1;
		try {
			String code = "";
			Random rd = new Random();
			while(code.length() < 6 ){
				code += rd.nextInt(10);
			}
			if(sendMailutil.sendHtmlMail(email, name, code)){
				session.setAttribute("code", code);
				//启用一个定时任务，当3分钟后清空这个session中的值
				TimerTask task = new TimerTask(){
					@Override
					public void run() {
						session.removeAttribute("code");
					}
				};
				Timer timer = new Timer();
				timer.schedule(task, 180000);
				result = 1;
			}else{
				result = 0;
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 用户注册
	 * @param session
	 * @param uf
	 * @return
	 */
	@RequestMapping("/add")
	public int reg(HttpSession session,UserInfo uf){
		String code = (String) session.getAttribute("code");
		if(!uf.getCode().equals(code)){
			return -2;
		}
		return service.add(uf);
	}
	/**
	 * 用户登录
	 * @param session
	 * @param uf
	 * @return
	 */
	@RequestMapping("/login")
	public int login(HttpSession session, UserInfo uf){
		UserInfo userInfo = service.login(uf);
		System.out.print(userInfo);
		if (userInfo != null){
			session.setAttribute("loginUser", userInfo);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/check")
	public UserInfo checkLogin(HttpSession session){
		Object obj = session.getAttribute("loginUser");
		
		if (obj == null){
			return new UserInfo();
		}
		return (UserInfo) obj;
	}
	
	@RequestMapping("/exit")
	public int exit(HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute("loginUser");
		if (user == null) {
			return -1;
		}
		
		session.removeAttribute("loginUser");
		return 1;
	} 
	
	/*// 添加评论
		@RequestMapping("/addComment")
		public int addComment(int id, String content, HttpSession session) {
			UserInfo user = (UserInfo) session.getAttribute("loginUser");
			int usrid = user.getUserid();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(new Date());
			
			// 替换字符串，防止js注入攻击
			content = StringConvert.StrConvert(content);
			System.out.println("==================================================\n"+content);
			System.out.println("==================================================\n"+content);
			
			int result = service.addComment(uid, id, content, date);
			if (result > 0) {
				//博客评论数加一
				int result1 = service.Updatecontent(id);
				if (result1 == 0) {
					// 手动回滚
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					System.out.println("回滚数据。。。。。。。。。。。。");
					return 0;
				}
				//更新session中的comments
				List<Evaluation> comments = bloginfoService.getCommentAndReply(evaluationid, userid);
				session.setAttribute("comments", comments);
			}
			
			return result;
		}
		
		//添加回复
		@RequestMapping("/addReply")
		@Transactional
		public int addReply(int cid, int comment_id, int to_uid, String content, HttpSession session) {
			UserInfo user = (UserInfo) session.getAttribute("UserInfo");
			int from_id = UserInfo.getId();
			java.sql.Date date = new java.sql.Date(new Date().getTime());
			
			int result = service.addReply(cid, comment_id, to_uid, from_id, date, content);
			if (result > 0) {
				//评论回复数加一
				int result1 = service.commentUpdate(comment_id);
				if (result1 == 0) {
					// 手动回滚
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					System.out.println("回滚数据。。。。。。。。。。。。");
					return 0;
				}
				// 更新session中的comments
				List<Evaluation> comments = bloginfoService.getCommentAndReply(blogid, from_id);
				session.setAttribute("comments", comments);
			}
			return result;
		}*/
		
	/**
	 * 关于我页面查询
	 * @param session
	 * @param userid
	 * @return
	 */
	@RequestMapping("/findAll")
	public UserInfo findAll(HttpSession session,Integer userid){
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");

		if(userInfo != null) {
			return userInfo;
		}
		return null;
	}
	/**
	 * 修改用户信息
	 * @param session
	 * @param userid
	 * @return
	 */
	@RequestMapping("/update")
	public int update(HttpSession session,UserInfo uf){
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		uf.setUserid(userInfo.getUserid());
		return service.update(uf);
	}
}
