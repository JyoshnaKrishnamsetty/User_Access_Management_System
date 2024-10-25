<%@page import="com.Model.RequestForManager"%>
<%@ page import="java.util.List"%>
<%@ page import="com.Model.RequestAccessModel"%>

<html>
<head>
<title>pending Requests</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
.paddingtop {
	padding-top: 20px;
}
</style>
</head>
<body>
	<div class="container"></div>
	<h4 style="text-align: center;" class="paddingtop">
		<b>PENDING REQUESTS</b>
	</h4>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Employee Name</th>
				<th>Software Name</th>
				<th>Access Type</th>
				<th>Reason for Request</th>
				<th>Actions</th>
			</tr>
			<%
    List<RequestForManager> dataList = (List<RequestForManager>) request.getAttribute("ApprovalList");
    if (dataList != null && !dataList.isEmpty()) {
    for (RequestForManager data : dataList) {
    %>
			<tr>
				<td><%= data.getEmployename()%></td>
				<td><%= data.getSoftwarename() %></td>
				<td><%= data.getAccestype() %></td>
				<td><%= data.getReason() %></td>
				<td>
					<form action="ApprovalServlet" method="post">
						<input type="hidden" name="requestId" value="<%= data.getReqid()%>">
						<button type="submit" name="action" value="approve">Approve</button>
						<button type="submit" name="action" value="reject">Reject</button>
					</form>
				</td>
			</tr>
			<%
       }
    }
    %>
		</thead>

	</table>
	</div>
	<%
	String message=(String) request.getAttribute("Message"); 
	if(message!=null){
	%>
	<p style="color:green; text-align:center"><%= message%></p>
    <%
    }
    %>
</body>
</html>