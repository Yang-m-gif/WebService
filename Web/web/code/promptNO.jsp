<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML>
<html lang="zh">
<head>
    <base href="<%=basePath%>">
    <title>提示信息</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>

    <!-- 引用 -->
    <!-- css -->
    <link href="<%=basePath%>assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="<%=basePath%>assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="<%=basePath%>assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"
          type="text/css"/>

    <link href="<%=basePath%>assets/global/css/components-rounded.min.css" rel="stylesheet" id="style_components"
          type="text/css"/>
    <link href="<%=basePath%>assets/global/css/plugins.min.css" rel="stylesheet" type="text/css"/>

    <link href="<%=basePath%>assets/pages/css/error.min.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="<%=basePath%>statics/img/icon-zdyh.png" type="image/x-icon">

    <!-- js -->
    <script src="<%=basePath%>assets/global/plugins/jquery.min.js" type="text/javascript"></script>

<body class=" page-500-full-page">
<div class="row">
    <div class="col-md-12 page-500">
        <div class=" number font-red"> NO！</div>
        <div class=" details">
            <h3>操作失败！</h3>
            <p>${message}
                <br/>
            </p>
            <a href="javascript:;" onclick="javascript:window.open('<%=basePath%>login.jsp','_top'); "
               class="btn red btn-outline"> 返回首页 </a>
        </div>
    </div>
</div>
</body>
</head>