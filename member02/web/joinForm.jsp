<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로그램</title>
</head>
<body>
<center>

<form action="JoinServlet" method="post" name="joinform">

<h2>회원가입</h2>

<table border="1" width="500" heigh="500">
<th style="background-color:skyblue" colspan="50">회원 기본 정보</th>
</tr>
<tr>
<th style="background-color:#B2EBF4">이름:</th>
<td><input type="text" name="name" size="20" value="${member.name }"/></td>
</tr>
<tr >
<th style="background-color:#B2EBF4">아이디:</th>
<td><input type="text" name="id" size="20"/><span style="color:red">${msg }</span></td>
</tr>

<tr>
<th style="background-color:#B2EBF4">비밀번호:</th>
<td><input type="password" name="pw" size="20" /><span style="color:red;">${msg }</span></td>
</tr>
<tr>
<th style="background-color:#B2EBF4">전화번호:</th>
<td> <select name="phone1">
     <option value="010">010</option>
     <option value="011">011</option>
     <option value="016">016</option>
     <option value="017">017</option>
     </select>
     -
      <input type="text" name="phone2" size="4" value="${member.phone2 }">
      - 
      <input type="text" name="phone3" size="4" value="${member.phone3 }">
     </td>
</tr>

<tr>
<th style="background-color:#B2EBF4">성별:</th>
<td><input type="radio" name="gender" value="man">남 
    <input type="radio" name="gender" value="woman">여</td>
</tr>
</table>
<br>
<input type="submit" value="회원가입">
<input type="reset" value="다시입력">

</form>
</center>
</body>
</html>

