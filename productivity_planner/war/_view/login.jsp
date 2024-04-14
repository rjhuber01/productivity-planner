<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
        <c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
	  <form action="http://localhost:8081/prodAssistant/login" method="POST">
	      <label class="userText" for="username"> Email </label> <br>
	      <input type="text" placeholder="Email" name="email"> <br> <br>
	      <label class="userText" for="password"> Password </label> <br> 
	      <input type="password" placeholder="Password" name="password"> <br> 
	      <!-- <button> Submit </button>  -->
	      	<input type="submit" value="Submit">
      </form>
    </div>
  </body>

</html>