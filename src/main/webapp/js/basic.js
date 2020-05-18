function out(){
	$.post("userInfo/exit", null, function(data) {
		data = parseInt($.trim(data));
		if (data > 0) {
			setTimeout(function() {
				location.href='login.html';
			},500);
		}
	}, "json");
}






$(function(){
	$.post("userInfo/check",null,function(data){
		console.info(data);
		
		var str = "";
		
		if(data.userid){
			str += '<li><a href="#">['+ data.username +']</a></li><li><a href="#" onclick="out()">退出登录</a></li>';
		}else{
			str += '<li><a href="login.html">登录or注册</a></li>';
		}
		
		str += ' <li><a href="index.html" >首页</a></li>';
		str += ' <li><a href="writen.jsp">编辑</a></li>';
		str += '<li><a href="collect.html">收藏</a></li>';
		str += '<li><a href="myself.html">个人博客</a></li>';
		str += '<li><a href="comment.jsp">个人信息</a></li>';
		

		
		
		$("#star").append($(str));
	
		
	},"json");
	
	
})