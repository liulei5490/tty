$(function() {
	// 类别加载请求
	$.post("homePage/getAllType", null, function(data) {
		var type = "";
		for (var i = 0; i < data.length; i++) {
			type += '<li><a href="javascript:void(0)" onclick="gettypeid('
					+ data[i].type + ')" class="typeInfo">' + data[i].typename
					+ '</a></li>';
		}
		$(".type").html(type);
	}, "json")
	

	// 首页加载请求
	$.post("homePage/loading", null, function(data) {
		setContent(data);
	}, "json")
	
})

// 点击按照类别查询
function gettypeid(type) {
	$.post("homePage/loading", {
		type : type
	}, function(data) {
		setContent(data);
	}, "json")
}

// 设置推荐博客内容
function setContent(data) {
	console.log(data);
	var content = "";
	var bloglist = data["blogList"];
	var attention = data["attention"];
	var collect = data["collect"];
	var collectlist = data["collectList"];
	for (var i = 0; i < bloglist.length; i++) {
		content += '<div class="contentleft"><h4><a class="title" href="details.html?id='
			     + bloglist[i].blogid +'">'+ bloglist[i].title +'</a></h4><p><a class="label label-default">'
			     + bloglist[i].label +'</a></p><p><span class="count"><i class="glyphicon glyphicon-user"></i><a href="#">admin</a></span><span class="count"><i class="glyphicon glyphicon-eye-open"></i>阅读：' 
			     +bloglist[i].readnum+ '</span><span class="count"><i class="glyphicon glyphicon-comment"></i>评论:'
			     +bloglist[i].evaluate+ '</span><span class="count"><i class="glyphicon glyphicon-time"></i>'
			     +bloglist[i].editordate+'</span>';
		
		/*if (attention.length == 0) {
			content += '<span class="count"><span class="fd01 attention focus '+bloglist[i].userid+'" onclick="getUserid('+bloglist[i].userid+')">点击关注</span></span>';
		}else{
			for (var j = 0; j < attention.length; j++){
				if (bloglist[i].userid != attention[j].focususerid) {
					// 表示已经对该作者进行了关注
					content += '<span class="count"><span class="fd01 attention focus '+bloglist[i].userid+'" onclick="getUserid('+bloglist[i].userid+')">点击关注</span></span>';
				}else {
					content += '<span class="count"><span class="fd01 attention focus '+bloglist[i].userid+'" onclick="getUserid('+bloglist[i].userid+')">取消关注</span></span>';
				}
			}
			
		}*/
		
		
		var flag = false;
		if(collect.length == 0){
			content += '<span class="count"><span class="fd01 collect focus" onclick="getBlogid(this, '+bloglist[i].blogid+')">点击收藏</span> </span>';
		}else{
			for (var a = 0;  a < collect.length; a++){
				if (bloglist[i].blogid == collect[a].blogid) {
					flag = true;
				}
		}
		    
			if (flag) {
				// 表示已经对该作者进行了收藏
				content += '<span class="count"><span class="fd01 collect defocus" onclick="getBlogid(this, '+bloglist[i].blogid+')">取消收藏</span> </span>';
			} else {
				content += '<span class="count"><span class="fd01 collect focus" onclick="getBlogid(this, '+bloglist[i].blogid+')">点击收藏</span> </span>';
				// 表示未对该作者进行收藏
			}
		}
		 content += '</div><div class="contentImage"><div class="row"><a href="#" class="thumbnail w_thumbnail"><img' + 'src ="../' + bloglist[i].pics + '" '+ 'alt="..."></a></div></div>';
			
	}

	console.info(data);

		$(".bloglist").html(content);

}
		
	
// 关注||取消关注绑定的点击事件
function getUserid(userid) {
	if ($(".attention").hasClass("focus" + userid) == true) {
		addAttention(userid);
	}
	if ($(".attention").hasClass("delfocus" + userid) == true) {
		removeSAttention(userid);
	}
}



// 添加关注
function addAttention(userid) {
	$.post("homePage/addAttention", {
		userid : userid
	}, function(data) {
		if (data == 1) {
			// 表示关注成功
			$(".focus" + userid).text("取消关注");
			// 移除关注相关类名并添加取消关注相关类名
			$(".attention").removeClass("focus" + userid);
			$(".attention").addClass("delfocus" + userid);
		} else {
			// 表示关注失败
			alert("关注失败")
		}
		console.info(data);
	}, "json")
}

// 移除关注
function removeSAttention(userid) {
	$.post("homePage/delAttention", {
		userid : userid
	}, function(data) {
		if (data == 1) {
			// 表示取消关注成功
			$(".delfocus" + userid).text("关注作者");
			// 移除取消关注相关类名并添加关注相关类名
			$(".attention").removeClass("delfocus" + userid);
			$(".attention").addClass("focus" + userid);
		} else {
			//表示关注失败
			alert("关注失败")
		}

	}, "json")
}

//点击收藏
function addCollect(blogid) {
	$.post("homePage/addCollect",{blogid : blogid}, function(data){
		if (data == 1){
			//表示收藏成功
			$(".focus1 + blogid").text("取消收藏");
			//移除收藏相关类名并添加取消收藏相关类名
			$(".collect").removeClass("focus1" + blogid);
			$(".collect").addClass("delfocus1" + blogid);
		}else {
			//表示收藏失败
			alert("收藏失败")
		}
	},"json")
}

//移除收藏
function removeCollect(blogid){
	$.post("homePage/removeCollect",{blogid : blogid}, function(data){
		if (data == 1){
			//表示取消收藏成功
			$(".delfocus1" + blogid).text("点击收藏");
			//移除取消收藏相关类名并添加关注相关类名
			$(".collect").removeClass("delfocus1" + blogid);
			$(".collect").addClass("focus1" + blogid);
		}else {
			//表示失败
			alert("收藏失败")
		}
	},"json")
}

//收藏 ||取消收藏的点击事件
function getBlogid(obj, blogid){
	if ($(obj).hasClass("focus")) {
		$.post("homePage/addCollect",{blogid : blogid}, function(data){
			data = parseInt($.trim(data));
			if (data == 1){
				//表示收藏成功
				$(obj).removeClass("focus");
				$(obj).text("取消收藏");
				//移除收藏相关类名并添加取消收藏相关类名
				$(obj).addClass("delfocus");
			}else if(data == -1) {
				
				//表示失败
				alert("收藏失败")
			}else if(data == -2){
				alert("登录失败，请先登录");
				setTimeout(function(){ 
					location.href = "login.html";
				}, 1000);
			}
		},"json")
	} else if ($(obj).hasClass("delfocus")) {
		$.post("homePage/delCollect",{blogid : blogid}, function(data){
			data = parseInt($.trim(data));
			if (data == 1){
				//表示取消收藏成功
				$(obj).removeClass("delfocus");
				$(obj).text("点击收藏");
				//移除取消收藏相关类名并添加关注相关类名
				$(obj).addClass("focus");
			}else if(data == -1) {
				
				//表示失败
				alert("取消收藏失败")
			}else if(data == -2){
				alert("登录失败，请先登录");
				setTimeout(function(){ 
					location.href = "login.html";
				}, 1000);
			}
		},"json")
	}
}