<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>

		<style> 
			form {
				display: inline-block;
				margin: 10px;
			}

			input[type="submit"] {
				border-style: none;
				border-radius: 20px;
				background-color: #2E67CE;
				color: #CCCCCC;
				font-size: 16px;
				font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
				padding: 8px 10px 8px 10px;
				transition: all ease-in 0.3s;
			}

			input[type="submit"]:hover {
				cursor: pointer;
				background-color: #506B8D;
				color: white;
			}

			input[type="submit"]:active {
				background-color: #262E40;
				color: white;
			}

		</style>
	</head>

	<body>
		<h1> Index View. </h1>
		<p> This is the index view JSP. Please click one of the three buttons to link to the right page </p>

		<form action="http://localhost:8081/lab02/addNumbers" method="GET">
			<input type="submit" value="Add Numbers">
		</form>

		<form action="http://localhost:8081/lab02/multiplyNumbers" method="GET">
			<input type="submit" value="Multiply Numbers">
		</form>

		<form action="http://localhost:8081/lab02/guessingGame" method="GET">
			<input type="submit" value="Guessing Game">
		</form>

	</body>
</html>
