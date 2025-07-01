<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes Page</title>
<%@ include file="/WEB-INF/resources/component/all_link.jsp" %>
</head>
<body style="background-color: #f0f0f0">
<%@include file="/WEB-INF/resources/component/navbar.jsp" %>
<div class="container mt-5">
<div class="row">
<div class="col-md-10 offset-md-1">
  <div class="card">
    <div class="card-header text-center">
      <h3>Add Your Notes</h3>
    </div>
    <div class="card-body">
      <form action="saveNotes" method="post">
       <div class="mb-3">
         <label>Enter Title</label>
         <input type="text" name="title" class="form-control"/>
       </div>
       <div class="mb-3">
         <label>Enter Description</label>
         <textarea rows="6" cols="" class="form-control" name="description"></textarea>
       </div>
       <button class="btn btn-primary mt-2 text-center">Save</button>
      </form>
    </div>
  </div>
</div>
</div>
</div>
</body>
</html>