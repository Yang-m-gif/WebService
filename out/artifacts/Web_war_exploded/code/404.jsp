<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>404</title>
    <script src="<%=basePath%>bootstrap/js/jquery-3.2.1.js"></script>

    <style type="text/css">
        .page404 {
            background: #000;
            /* 		background-image:none; */
            color: #fff;
            position: absolute;
            width: 100%;
            height: 100%;
            /* 	overflow:hidden; */
            overflow-X: hidden
        }

        .page404 div.txt404 {
            z-index: 999;
            position: relative;
            height: 400px;
            text-align: center;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            font: bold 300px/1 "microsoft yahei";
        }

        .page404 span {
            font: bold 50px "microsoft yahei";
            position: absolute;
        }

        .page404 span.opacityAnimateShow {
            animation: opacityAnimateShow 0.5s;
        }

        .page404 span.opacityAnimateHide {
            animation: opacityAnimateHide 0.5s;
        }

        @
        keyframes opacityAnimateShow {

        from {
            opacity: 0;

        }

        to {
            opacity: 1;
        }

        }
        @
        keyframes opacityAnimateHide {

        from {
            opacity: 1;

        }

        to {
            opacity: 0;
        }

        }

    </style>

<body class="page404">

<input type="button" style="float: right; margin-right: 1em; background-color: black;border: 0"
       onclick="naver('weizhi')" value="test"/>
<div class="txt404">666</div>
<div id="weizhi" style="margin-top: 80em;display: none">
    <h1 id="pro" class="box">${customMessage}</h1>
    <label style="color:red;font-size:x-large;">${ex} <br/><br/> ${object } </label>
    <br/>
    <br/>
    <br/>
    <br/>
    <c:forEach var="stc" items="${stackTrace}">${stc}</c:forEach>
</div>
<br>
<br>
</body>
<script>
    //设置锚点
    function naver(id) {
        $("#weizhi").show();
        var obj = document.getElementById(id);
        var oPos = obj.offsetTop;
        return window.scrollTo(0, oPos - 36);
    }
</script>
<script>

    var txtArr = [404, "就这样我失去了你", "哎哟我去,什么情况啊", "页面报错啦？打死你个“gui sui”", "哎呦跑啦页面",
            "快去打开正确的地方", "不！臣妾做不到！"], colorArr = [1, 2, 3, 4, 5, 6, 7, 8, 9,
            "a", "b", "c", "d", "e", "f"], clientW = document.body.clientWidth
        || document.documentElement.clientWidth, //可视区域宽
        clientH = document.body.clientHeight
            || document.documentElement.clientHeight, //可视区域高
        colorVal = "#", i = 0;

    function randomShowSpan() {
        var randomNum = Math.floor(Math.random() * txtArr.length), // 文字随机数
            randomX = Math.floor(Math.random() * clientW), // X萦随机数
            randomY = Math.floor(Math.random() * clientH), // Y轴随机数
            oSpan = document.createElement('span');
        document.body.appendChild(oSpan);
        while (i < 6) {
            var randomColor = Math.floor(Math.random() * colorArr.length); // 颜色随机数
            colorVal += String(colorArr[randomColor]);
            i++;
        }
        var spans = document.getElementsByTagName('span'), spanThis = spans[spans.length - 1];

        spanThis.style.left = randomX + "px";
        spanThis.style.top = randomY + "px";
        spanThis.style.color = colorVal;
        spanThis.style.fontSize = Math.ceil(Math.random() * 60 + 12) + "px"; // 字体最大为60
        spanThis.innerHTML = txtArr[randomNum];
        spanThis.className = "opacityAnimateShow";
        // 初始化颜色值和i
        colorVal = "#";
        i = 0;
    }

    function randomHideSpan() {
        document.getElementsByTagName('span')[1].className = "opacityAnimateHide";
        setTimeout(
            "document.getElementsByTagName('span')[0].parentNode.removeChild(document.getElementsByTagName('span')[0])",
            250);
    }

    setInterval("randomShowSpan()", 200);
    setInterval("randomHideSpan()", 250);
</script>
</body>
</html>
