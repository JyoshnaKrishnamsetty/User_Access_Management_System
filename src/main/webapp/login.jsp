
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
.paddingbottom {
	padding-bottom: 30px;
}

.paddingbottom1 {
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
		let uid = document.getElementById("username").value;
		let pwd = document.getElementById("pwd").value;
		if (uid === "" || pwd === "") {
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
				<form class="form-group" name="loginpage" method="post"
					action="LoginServlet" onsubmit="return fun1()">
					<h3 class="paddingbottom paddingbottom1 style">
						<b>LOGIN</b>
					</h3>
					<div class="row paddingbottom">
						<div class="col-md-12">
							<label><b>Username:</b></label> <input
								class="form-control customoutline" type="text" name="username"
								id="username" placeholder="USERNAME">
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12">
							<label><b>Password:</b></label> <input
								class="form-control customoutline" type="password" name="pwd"
								id="pwd" placeholder="PASSWORD">
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12 style">
							<button type="submit" class="btn btn-success">LOGIN</button>
							<p id="sub"></P>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	 <%
    String error = (String) request.getAttribute("errorMessage");
    if (error != null) {
    %>
    <p style="color:red; text-align:center"><%= error%></p>
    <%
    }
    %>
</body>
</html>