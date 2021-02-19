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

 <form action="InsertServlet" method="post">

<h2>리스트 추가</h2>

<table border="1" width="500" heigh="500">
<th style="background-color:lime;" colspan="50">나의 목록 추가</th>
</tr>
<tr >
<th style="background-color:lime;">아이디:</th>
<td><input type="text" name="id" size="20" value="${id }" readonly/></td>
</tr>
<tr>
<th style="background-color:lime;">번호:</th>
<td><input type="text" name="no" size="20" value="${member.no+1}" ></td>
</tr>
<tr>
<th style="background-color:lime;">이름:</th>
<td><input type="text" name="name" size="10" value="${member.name }" ></td>
</tr>
<tr>
<th style="background-color:lime;">전화번호:</th>
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
<th style="background-color:lime;">그룹:</th>
	 <td>
  	 <select name="groupcode">
      <option value=1>가족</option>
      <option value=2>친구</option>
      <option value=3>기타</option>
  	 </select>
  	 </tr>
</table>
<br>
<input type="submit" value="추가" />
<input type="reset" value="다시입력">

</form>
</center>
</body>
</html>


