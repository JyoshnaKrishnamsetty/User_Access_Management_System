<%@ page import="java.util.List"%>
<%@ page import="com.Model.SoftwareModel"%>

<html>
<head>
<title>Request Access</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
.paddingbottom {
	padding-bottom: 30px;
}

.paddingtop {
	padding-top: 20px;
}

.customoutline {
	outline: 2px solid lightblue;
	border-radius: 10px;
}

.style {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row paddingbottom">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form class="form-group" name="requestaccesspage" method="post"
					action=" RequestServlet" onsubmit="return fun1()">
					<h3 class="paddingbottom paddingtop style">
						<b>REQUEST ACCESS</b>
					</h3>
					<input type="hidden" name="userId" id="userId"
						value="<%= session.getAttribute("userId") %>">
					<div class="row paddingbottom">
						<div class="col-md-12">
							<label><b>Software Name:</b></label> <select
								class="form-control customoutline" name="softwareId"
								id="softwareId">
								<%List<SoftwareModel> softwareList = (List<SoftwareModel>) request.getAttribute("softwareList");
								if (softwareList != null && !softwareList.isEmpty()) {  
								for (SoftwareModel software : softwareList) {
									
                                 %>
								<option value="<%= software.getId() %>"><%= software.getName() %></option>
								<%
                                  } } else {
                                 %>
                                 <option>No software available</option>
                                <% } %>
							</select>
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12">
							<label><b>Access Type:</b></label> <select
								class="form-control customoutline" name="accessType"
								id="accessType">
								<option value="Read">Read</option>
								<option value="Write">Write</option>
								<option value="Admin">Admin</option>
							</select>
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12">
							<label><b>Reason for Request:</b></label>
							<textarea class="form-control customoutline" name="reason"
								id="reason" rows="5" cols="50"></textarea>
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12 style">
							<button type="submit" class="btn btn-success">ACCESS
								REQUEST</button>
							<p id="sub"></P>
							<%
	String message=(String) request.getAttribute("Message"); 
	if(message!=null){
	%>
	<p style="color:red; text-align:center"><%= message%></p>
    <%
    }
    %>
   
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	
</body>
</html>
