<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 관리</title>
</head>
<body>
<h1>연락처 관리 프로그램</h1>
<div class="shadow p-3 mb-5 bg-body rounded"> ${name } 님의 연락처 목록</div>
<table>
		<td colspan="2" align="right"><a href = "InsertServlet">
	    <button type="button" class="btn btn-success">리스트 추가</button></a></td> 
	</table> 
<table class="table" width="600">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">이름</th>
      <th scope="col">연락처</th>
      <th scope="col">그룹코드</th>
      <th scope="col">수정</th>
      <th scope="col">삭제</th>
    </tr>
  </thead>
     <tbody>
     <tr>
   <c:forEach items="${members }" var="member" varStatus="mn"></br>
      <tr>
         <td class="align-middle">${member.no }</td>
         <td class="align-middle">${member.name }</td>
         <td class="align-middle">${member.phone1 }-${member.phone2 }-${member.phone3 }</td>
         <td class="align-middle">${member.groupcode }</td>
         <td class="align-middle"><a href = "ModifyServlet2?no=${member.no}"> 
          <button type="button" class="text-primary">수정</button></a>
         <td class="align-middle"><a href = "deleteServlet?no=${member.no}">
         <button type="button" class="btn btn-outline-primary">삭제</button></a>
        <tr>
      </tr>
   </c:forEach>
   </tbody>
</table>
<br>
<td><a href="LogoutServlet">로그아웃</a></td>
<td><a href="UpdateServlet">정보수정</a></td>
</body>
</html>


