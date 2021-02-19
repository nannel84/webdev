<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 프로그램</title>
</head>
<body>
<!-- 수정 입력할 수 있는 폼 -->
<h2> ${member.id }의 리스트</h2>
<form action="ModifyServlet2" method="post">
<table class="table table-bordered">
	<tr>
	 <td> 번호  </td>
	 <td>
	 <input type="text" name="no" size="10" value="${member.no }" readonly></td>
	</tr>
	<tr>
	 <td> 이름   </td>
	 <td>
	 <input type="text" name="name" size="10" value="${member.name }" readonly ></td>
	 </tr>
	<tr>
	 <td> 전화번호 </td>
	 <td>
  	 <select name="phone1">
      <option value="010">010</option>
      <option value="011">011</option>
      <option value="016">016</option>
      <option value="017">017</option>
  	 </select>
   	  - 
     <input type="text" name="phone2" size="4" value="${member.phone2 }"/>
      - 
     <input type="text" name="phone3" size="4" value="${member.phone3 }"/></td>
   	 </tr>
   	 <tr>
	 <tr>
	 <td> 그룹 </td>
	 <td>
  	 <select name="groupcode">
      <option value=1>가족</option>
      <option value=2>친구</option>
      <option value=3>기타</option>
  	 </select>
   </tr>
   </table>
   <input type="submit" value="회원수정" />
</form>
</body>
</html>

