<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pro.entity.Notes"%>
<!-- import your Notes class -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Notes Page</title>
<%@ include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>
	<div class="container-fluid p-4">
		<h4 class="text-center">View All Notes</h4>
		<%
						String msg = (String) session.getAttribute("msg");
						if (msg != null) {
						%>
		<div class="container mt-3">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="alert alert-success text-center">
                    <%= msg %>
                </div>
            </div>
        </div>
    </div>
		<%
						session.removeAttribute("msg"); // Remove after displaying
						}
						%>
		<div class="row">
			<%
         List<Notes> notesList = (List<Notes>) request.getAttribute("list");
        if (notesList != null) {
        for (Notes note: notesList) {
        %>
			<div class="col-md-10 offset-md-1 mt-2">
				<div class="card mb-2">
					<div class="card-body">
						<div class="text-center">
							<img alt="viewPage"
								src="<%= request.getContextPath() %>/resources/img/note-taking.png"
								width="50px" height="45px">
						</div>
						<p><%= note.getTitle() %></p>
						<p><%= note.getDescription() %></p>
						<p><%= note.getDate() %></p>

						<div class="text-center">
							<a href="editNotes?id=<%= note.getId() %>" class="btn btn-primary btn-sm">Edit</a> 
							<a href="deleteNotes?id=<%= note.getId() %>" class="btn btn-danger btn-sm">Delete</a>
			
						</div>
					</div>
				</div>

			</div>
			<%
        }
    } else {
%>
    <p class="text-center">No notes found.</p>
<%
    }
%>
		</div>
	</div>
</body>
</html>