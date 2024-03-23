<!DOCTYPE html>

<html>
  <head>
    <title> Scheduler - Timer </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/_view/media/loginStyle.css">
  </head>

  <body> 
    <div class="loginDiv">
      <!-- Explicity call GET method for personal understanding -->
      <a href="http://localhost:8081/prodAssistant/register" class="registerButton" method="GET"> Register Now </a>
      <h3> Login </h3>
      <label class="userText" for="username"> Username </label> <br>
      <input type="text" placeholder="Email"> <br> <br>
      <label class="userText" for="password"> Password </label> <br> 
      <input type="password" placeholder="Password"> <br> 
      <!-- <button> Submit </button>  -->
      <form action="http://localhost:8081/prodAssistant/dashboard" method="GET">
      	<input type="submit" value="Submit">
      </form>
    </div>
  </body>

</html>