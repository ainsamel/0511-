<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>새글등록</title>
</head>
<body>
	<div align="center" style="margin: auto auto" class="card-body">
		<h3>
			글 수정............<a href="logoutCtrl">LOG-OUT</a>
		</h3>
		<hr>
		<form action="updateBoardCtrl" method="post">
	
		<input type="hidden" name="num" class="form-control" value="${board.seq }"/>	
		
			<table class="table" style="width: 800px">
				<tr>
					<td>제목</td>
					<td align="left">
						<input type="text" name="title" class="form-control" value="${board.title }"/>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left">${board.username }
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10" class="form-control">${board.content }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value=" 글 수정" class="btn btn-primary"/>
					</td>
				</tr>
			</table>
		</form>
		<hr>
	</div>
</body>
</html>