<!DOCTYPE html>

<html>
  <head>
    <title> Productivity Assistant - Dashboard </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/dashboardstyle.css">

  </head>


  <body> 
    <div class="content">
      <div class="sideBarMenu">

        <h3> Menu </h3>

        <form action="http://localhost:8081/prodAssistant/dashboard" method="GET">
          <button class="menuItem"> <span class=buttonText"> Home </span> </button>
        </form>
        
        <form action="http://localhost:8081/prodAssistant/pomoTimer" method="GET">
          <button class="menuItem"> <span class=buttonText> Pomodoro </span> </button>
        </form>
      
      	<form action="http://localhost:8081/prodAssistant/tasks" method="GET">
      		<button class="menuItem"> <span class=buttonText> Tasks </span> </button>
      	</form>
      	
       	<form action="http://localhost:8081/prodAssistant/calendar" method="GET">
      		<button class="menuItem"> <span class=buttonText> Calendar </span> </button>
      	</form>  
      	
       	<form action="http://localhost:8081/prodAssistant/settings" method="GET">
      		<button class="menuItem"> <span class=buttonText> Settings </span> </button>
      	</form> 
        <button class="menuItem"> <span class=buttonText> Logout </span> </button>
      </div>

      <div class="userSummary">
        <h1> Things You Need To Do! </h1>
      </div>
    </div>
  </body>

</html>