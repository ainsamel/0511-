<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>로그인</title>
</head>
<body>
   <div align="center" style="margin: auto auto" class="card-body">
      <h1>로그인</h1>
      <hr>
      <form method="post" action="loginCtrl">
         <table class="table" style="width:400px">
            <tr>
               <td>아이디</td>
               <td><input type="text" class="form-control" name="userid" value="guest" /></td>
            </tr>
            <tr>
               <td>비밀번호</td>
               <td><input type="password" name="password" value="guest123"/></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
                  <input type="submit" value="로그인" class="btn btn-primary"/>
               </td>
            </tr>
         </table>
      </form>
      <button class="btn btn-primary" onclick="location='joinForm.jsp'">회원가입</button>
      <%-- 누르면 다른 페이지 가서 입력 -> 물고 db 저장 --%>
      <hr>
   </div>
</body>
</html>