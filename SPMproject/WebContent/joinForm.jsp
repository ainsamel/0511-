<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>회원가입</title>
</head>
<body>

	<div class="card-body">
		<h3 align="center">회원가입</h3>
	</div>

	<div class="card-body">
		<form method="post" action="InsertUserCtrl" novalidate>
			<table class="table">
				<tr>
					<td>아이디:</td>
					<td>
						<input type="text" name="userid" value="아이디 입력" size="50" onkeydown="inputIdChk()">&nbsp;&nbsp;
						<input type="button" value="중복확인" onclick="window.open('TestingView.jsp','중복확인','height=400,width=500,top=200,left=500')">
						<%-- onclick="location.href='TestingView.jsp'    idCheck(${id}) --%>
						<input type="hidden" name="inDuplication" value="idUncheck">
					</td>
					
				</tr>
				<tr>
					<td>패스워드:</td>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<td>이름:</td>
					<td><input type="text" name="username" size="30" maxlength="10"></td>
				</tr>
				<tr>
					<td>전화번호:</td>
					<td><input type="text" name="tel"></td>
				</tr>
				<tr>
					<td>E-Mail:</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td><input type="text" name="address" placeholder="서울시 "></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="전송"> 
						<%-- <input type="reset" value="리셋"> --%>
					</td>
				</tr>
			</table>

		</form>
	</div>

</body>
</html>