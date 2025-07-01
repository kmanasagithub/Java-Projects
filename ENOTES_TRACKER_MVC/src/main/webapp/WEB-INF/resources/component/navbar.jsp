
<%@ page import="com.pro.entity.User" %>
<%
    User user = (User) session.getAttribute("userObj");  // ✅ use "userObj"
%>

<!-- Start navbar -->
 
 <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><i class="fa-solid fa-note-sticky me-1"></i>ENotes</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath() %>/home"><i class="fa-solid fa-house me-1"></i>Home</a>
        </li>
        <% if (user != null) { %>
     
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath() %>/user/addNotes">Add Notes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath() %>/user/viewNotes">View Notes</a>
        </li>
        <% } %>
      </ul>
      <form class="d-flex">
  <% if (user != null) { %>
      <div class="d-flex align-items-center">
      <span class="me-3 text-light">
        <i class="fa-solid fa-user"></i> Welcome, <%= user.getFullName() %>
      </span>
    <a href="<%= request.getContextPath() %>/user/logout" class="btn btn-light">Logout</a>
    </div>
  <% } else { %>
    <a href=" <%= request.getContextPath() %>/login" class="btn btn-light me-2">Login</a>
    <a href="<%= request.getContextPath() %>/register" class="btn btn-light">Register</a>
  <% } %>

      </form>
    </div>
  </div>
</nav>
 <!-- End navbar -->

