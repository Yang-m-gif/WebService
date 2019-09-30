		//页面监控
/*		 var count = 0;
		 var outTime = 0.1;
		 window.setInterval(go,1000);
		 function go() {
			  count++;
			  //该页面3000秒没有任何操作跳转到轮播图页面
			  if(count == outTime*600) {
                  var curWwwPath=window.document.location.href;
                  var pathName=window.document.location.pathname;
                  var pos=curWwwPath.indexOf(pathName);
                  var localhostPaht=curWwwPath.substring(0,pos);

			   /!* alert("因您长时间未进行操作导致页面过期"); *!/
			     window.location.href = localhostPaht+"/wphScreensaver/selectScreenSaverByStatus";
			  }
		 };
		 
	    var x;
		var y;*/
		//监听鼠标
/*		document.onmousemove = function (event) {
		 var x1 = event.clientX;
		 var y1 = event.clientY;
			  if(x != x1 || y != y1){
			   count = 0;
			  }
		 x = x1;
		 y = y1;
		 count = 0;
		};*/
		
		//监听键盘 	
/*
		document.onkeydown = function () {
			count = 0;
		};*/
