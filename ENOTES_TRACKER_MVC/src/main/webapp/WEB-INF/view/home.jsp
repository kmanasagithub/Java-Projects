<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<%@ include file="/WEB-INF/resources/component/all_link.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/resources/component/navbar.jsp" %>
 <div class="container-fluid p-0 m-0">
   <img alt="notes_img" src="<%= request.getContextPath() %>/resources/img/homeImg.jpg" width="100%" height="673px">
   
 </div>
</body>
</html>