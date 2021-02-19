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
<h2> 아래 내용을 삭제 진행하시겠습니까?</h2>
<form action="deleteServlet" method="post">
<table>
  	<td colspan="2" align="left">
	<input type="submit" value="삭제"></td>
	<td colspan="2" align="center">
	<td><a href = "MainServlet"> <input type="button" value="취소"></a></td>
</table>
<table>
	<tr>
	 <td> 번호  </td>
	 <td>
	 <input type="text" name="no" size="10" value="${member.no }" readonly></td>
	</tr>
	<tr>
	 <td> 이름   </td>
	 <td>
	 <input type="text" name="name" size="10" value="${member.name }" readonly></td>
	 </tr>
	<tr>
	 <td> 전화번호 </td>
	 <td>
	 <input type="text" name="phone1" size="4" value="${member.phone1 }" readonly/>
   	  - 
     <input type="text" name="phone2" size="4" value="${member.phone2 }" readonly/>
      - 
     <input type="text" name="phone3" size="4" value="${member.phone3 }" readonly/></td>
   	 </tr>
   	 <tr>
	 <tr>
	 <td> 그룹 </td>
	 <td>
	 <input type="text" name="groupcode" size="4" value="${member.groupcode}" readonly/></td>
   </tr>
   </table>
</form>
</body>
</html>


