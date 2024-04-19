<html>
<head>

	<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css" rel="stylesheet">
<title>Login Page</title></head>
<body>
	<br>
	<div class="container">
		<h1>Login</h1>
		<hr>
			<form method="post">
				<pre style=color:red;>${error}</pre>
				Username : <input type="text" name="name">
				Password : <input type="password" name="pass">
				<input type="submit">
			</form>
	</div>
	
	<script href="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
	<script href="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>