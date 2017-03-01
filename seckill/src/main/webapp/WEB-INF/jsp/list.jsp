<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!-- 引入jstl -->
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>秒杀商品列表</title>
		<!-- 静态包含(一个servlet) 动态包含(多个servlet)引入bootstrap样式 -->
		<%@include file="../common/head.jsp" %>
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="/seckill/resource/script/libs/jquery.min.js"></script>
		<script src="/seckill/resource/script/libs/bootstrap.min.js"></script>
	</head>
	<body>
		<!-- 页面显示部分 -->
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading text-center">
					<h2>秒杀列表</h2>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>名称</th>
								<th>库存</th>
								<th>开始时间</th>
								<th>结束时间</th>
								<th>创建时间</th>
								<th>详情页</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="sk">
								<tr>
									<td>${sk.name }</td>
									<td>${sk.number }</td>
									<td>
			                            <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss" />
			                        </td>
			                        <td>
			                            <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss" />
			                        </td>
			                        <td>
			                            <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
			                        </td>
			                        <td><a class="btn btn-info" href="../seckill/${sk.seckillId}/detail" target="_blank">详情</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>