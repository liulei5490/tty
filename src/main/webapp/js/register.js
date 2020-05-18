
//获取验证码
$("#getCode").click(function(){
	console.log("aaaaaaaaa");
	var email = $("#email").val();
	var username = $("#username").val();
	console.log(email+ " " +username);
	if(email == ""){
		$("#email").blur();
		return;
	}
	if(username == ""){
		$("#username").blur();
		return;
	}
	
	$.post("userInfo/code",{email:email,name:username},function(data){
		console.info(data);
		data = parseInt($.trim(data));
		if(data > 0){
			$("#getCode").attr("disabled","true");
			//倒计时
			var time  = 180;
			var timeTask = setInterval(function(){
				if(time >0 ){
					time --;
					$("#getCode").val( time + "S");
				}else{
					$("#getCode").removeAttr("disabled").val("重新发送");
					clearInterval(timeTask);
				}
			},1000);
		}else{
			$("#getCode").removeAttr("disabled").val("重新获取");
			$("#getCode").next().next().html("验证码发送失败");
		}
	},"text");              
})



//注册
function reg(){
	var username =$.trim($("#username").val());
	var userpass =$.trim($("#pwd").val());
	var realName =$.trim($("#realName").val());
	var birthday =$.trim($("#birthday").val());
	var sex =$.trim($("#sex").val());
	var contackway =$.trim($("#contackway").val());
	var address =$.trim($("#address").val());
	var work =$.trim($("#work").val());
	var code =$.trim($("#code").val());
	var email =$.trim($("#email").val());
	$.post("userInfo/add",$("#myform").serialize(),function(data){
		console.info(data);
		data = parseInt($.trim(data));
		if(data == -2){
			//$("#yzm").next().next().text("验证码错误").show();
		}else if(data > 0){
			$("#myform")[0].reset();
			alert("注册成功,请登录...");
			location.href='login.html';
		}else{
			alert("注册失败,请稍后重试...");
		}
	},"text");
}

	
	
	