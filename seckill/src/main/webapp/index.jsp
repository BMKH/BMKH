<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!-- 引入jstl -->
<%@include file="../WEB-INF/common/tag.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>交易平台</title>
		<%@include file="../WEB-INF/common/head.jsp"%>
	</head>
	<body>
		<!-- 网址导航栏 -->
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">导航栏</a>
				</div>
				<form action="#" class="navbar-form navbar-left" role="search">
					<div class="form-group">
		                <input type="text" class="form-control" placeholder="Search">
		            </div>
		            <button type="submit" class="btn btn-default">提交按钮</button>
				</form>
				 <ul class="nav navbar-nav" style="margin-left:120px;">
		            <li class="active"><a href="#">首页</a></li>
		            <li class="dropdown">
		            	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
		            		我的网站
		                    <b class="caret"></b>
		            	</a>
		            	<ul class="dropdown-menu">
		            		<li><a href="#">我的购买</a></li>
		            		<li class="divider"></li>
		            		<li><a href="#">我的收藏</a></li>
		            		<li class="divider"></li>
		            		<li><a href="#">我的出售</a></li>
		            		<li class="divider"></li>
		            		<li><a href="#">。。。。</a></li>
		            	</ul>
		            </li>
		            <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                    	客服中心
		                    <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">帮助中心</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">安全中心</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">我要咨询</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">投诉建议</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">异常处理</a></li>
		                </ul>
		            </li>
		            <li><a href="#">充值</a></li>
		            <li><a href="#">提现</a></li>
		            <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                    	关注我们
		                    <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">。。。。</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">。。。。</a></li>
		                </ul>
		            </li>
		            <li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                    	网站导航
		                    <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">。。。。</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">。。。。</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">。。。。</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">。。。。</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">。。。。</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">。。。。</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">。。。。</a></li>
		                    <li class="divider"></li>
		                    <li><a href="#">。。。。</a></li>
		                </ul>
		            </li>
		        </ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>注册</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>登录</a></li>
				</ul>
			</div>
		</nav>
		
		<!-- 图片轮播插件 -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width:350px;">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="/seckill/resource/images/liuyifei.jpg" alt="First slide" style="width:100%;">
				</div>
				<div class="item">
					<img src="/seckill/resource/images/wangzuxian.jpg" alt="Second slide" style="width:100%;">
				</div>
				<div class="item">
					<img src="/seckill/resource/images/zhaomin.jpg" alt="Third slide" style="width:100%;">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div> 
	</body>
	<script src="/seckill/resource/script/libs/jquery.min.js"></script>
	<script src="/seckill/resource/script/libs/bootstrap.min.js"></script>
</html>