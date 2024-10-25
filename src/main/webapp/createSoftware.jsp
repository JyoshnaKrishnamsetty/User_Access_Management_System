<html>
<head>
<title>Create Software</title>
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
<script>
	function fun1() {
		let softwarename = document.getElementById("softwarename").value;
		let description = document.getElementById("description").value;
		let readCheckbox = document.getElementById("read");
		let writeCheckbox = document.getElementById("write");
		let adminCheckbox = document.getElementById("admin");
		let atLeastOneChecked = readCheckbox.checked || writeCheckbox.checked
				|| adminCheckbox.checked;
		if (softwarename === "" || description === ""
				|| atLeastOneChecked === "") {
			document.getElementById("sub").innerHTML = "*Enter all fields";
			document.getElementById("sub").style.color = "red";
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row paddingbottom">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form class="form-group" name="createsoftwarepage" method="post"
					action=" SoftwareServlet" onsubmit="return fun1()">
					<h3 class="paddingbottom paddingtop style">
						<b>CREATE SOFTWARE</b>
					</h3>
					<div class="row paddingbottom">
						<div class="col-md-12">
							<label><b>Software Name:</b></label> <input
								class="form-control customoutline" type="text"
								name="softwarename" id="softwarename"
								placeholder="SOFTWARE NAME">
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12">
							<label><b>Description:</b></label>
							<textarea class="form-control customoutline" name="description"
								id="description" rows="5" cols="50"></textarea>
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12">
							<label><b>Access Levels:</b></label><br> <input
								type="checkbox" name="read" id="read" value="Read"> <label
								for="read">Read</label><br /> <input type="checkbox"
								name="write" id="write" value="Write"> <label
								for="write">Write</label><br /> <input type="checkbox"
								name="admin" id="admin" value="Admin"> <label
								for="admin">Admin</label>
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12 style">
							<button type="submit" class="btn btn-success">CREATE
								SOFTWARE</button>
							<p id="sub"></P>
							<%
                   String Message=(String) request.getAttribute("Message");
                   if(Message!=null && Message.equals("Sofware Created Successfully!!")){
                    %>
					<p style="color: green; text-align: center;"><%= Message%></p>
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
