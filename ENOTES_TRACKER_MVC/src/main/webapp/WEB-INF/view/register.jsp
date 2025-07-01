<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<%@ include file="/WEB-INF/resources/component/all_link.jsp" %>
</head>
<body style="background-color: #f0f0f0">
<%@include file="/WEB-INF/resources/component/navbar.jsp" %>
<div class="container mt-5">
<div class="row">
<div class="col-md-6 offset-md-3">
  <div class="card">
    <div class="card-header text-center">
      <h3>Register Page</h3>

    </div>
    <div class="card-body">
      <form action="registerUser" method="post">
       <div class="mb-3">
         <label>Enter Full Name</label>
         <input type="text" name="fullName" class="form-control"/>
       </div>
       <div class="mb-3">
         <label>Enter Qualification</label>
         <input type="text" name="qualification" class="form-control"/>
       </div>
        <div class="mb-3">
         <label>Enter Email</label>
         <input type="email" name="email" class="form-control"/>
       </div>
        <div class="mb-3">
         <label>Enter Password</label>
         <input type="password" name="password" class="form-control"/>
       </div>
       <button class="bn btn-primary col-md-12">Register</button>
      </form>
    </div>
  </div>
</div>
</div>
</div>
</body>
</html>