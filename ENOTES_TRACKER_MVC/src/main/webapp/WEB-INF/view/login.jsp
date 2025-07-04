<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<%@ include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body style="background-color: #f0f0f0">
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center">
						<h3>Login Page</h3>

						<%
						String msg = (String) session.getAttribute("msg");
						if (msg != null) {
						%>
						<div class="alert alert-danger text-center"><%=msg%></div>
						<%
						session.removeAttribute("msg"); // Remove after displaying
						}
						%>


					</div>
					<div class="card-body">
						<form action="loginUser" method="post">

							<div class="mb-3">
								<label>Enter Email</label> <input type="email" name="email"
									class="form-control" />
							</div>
							<div class="mb-3">
								<label>Enter Password</label> <input type="password"
									name="password" class="form-control" />
							</div>
							<button class="bn btn-primary col-md-12">Register</button>
						</form>
					</div>
					<div class="card-footer text-center ">
						<p class="fs-6">
							Don't have an account? <a href="register"
								class="text-decoration-none">Register</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>