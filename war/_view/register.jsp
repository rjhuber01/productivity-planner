<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
  <head>
    <title> Register Now!! </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/_view/media/loginStyle.css">
  </head>

  <body> 
    <div class="loginDiv">
      <a href="http://localhost:8081/prodAssistant/login" class="registerButton" method="GET"> Already registered? <br> <br> Log In </a>
      <h3> Register Now </h3>
      <form method="POST">
        <label for="firstName">First Name:</label><br>
        <input type="text" id="firstName" name="firstName" placeholder = "First Name" required><br><br>
        
        <label for="lastName">Last Name:</label><br>
        <input type="text" id="lastName" name="lastName" placeholder = "Last Name" required><br><br>
        
       	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
        
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email" placeholder = "Email" required><br><br>
        
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" placeholder = "Password" required><br><br>
        
        <input type="submit" value="Register">
      </form>
    </div>
  </body>

</html>