<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:if test="${empty name }">
		<c:redirect url="login.jsp" />
	</c:if>
<!-- getBoardList.jsp -->
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GetBoardList</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div id="header" class="card-body">
		<h1>Main List</h1>
		<h3>${username }님 환영합니다.  <a href="logoutCtrl">Logout</a></h3>
	</div>

	<div id="content" class="card-body">
		<table class="table">
			<thead>
				<tr>
					<td><button>아우터</button></td>
				</tr>
			</thead>
			<tbody>
		
<c:forEach var="board" items="${boardList }">	
		<tr>
			<td>${board.seq}</td>
			<td><a href="getBoardCtrl?num=${board.seq}">${board.title}</a></td>
			<td>${board.nickname}</td>
			<td>${board.regdate}</td>
			<td>${board.cnt}</td>
		</tr>
</c:forEach>		
			<tr>
					<td colspan="5">
						<a href="addBoard.jsp">새 게시물 작성</a>
					</td>
				</tr>	
			</tbody>
		
		</table>
	
		
	</div>

	<div id="footer" class="card-body"></div>
</body>
</html>
