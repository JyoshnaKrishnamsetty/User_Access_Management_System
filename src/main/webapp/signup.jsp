<html>
<head>
<title>Sign Up</title>
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
				<form class="form-group" name="signuppage" method="post"
					action="SignUpServlet" onsubmit="return fun1()">
					<h3 class="paddingbottom paddingbottom1 style">
						<b>SIGN UP</b>
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
					<input type="hidden" name="role" value="Employee"><br>
					<div class="row">
						<div class="col-md-12 style">
							<button type="submit" class="btn btn-success">SIGN UP</button>
							<p id="sub"></P>
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-12 style">
							<p>If you are already registered, <a href="login.jsp">login here</a>.</p>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>