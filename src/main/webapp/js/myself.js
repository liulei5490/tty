function findAll(data) {
		$.post("blog/findAll",null, function(data){
			var str = '';
			$.each(data,function(index, item){
				str += '<div class="sy"><img src="../'+item.pics+'"><p>'+item.title
				+'</p></div><span class="dateview">'+item.editordate+'</span> ';
				
			}, "json");
			console.info(data);

			$("#boxlist").html("").append($(str));
		});
		
	}