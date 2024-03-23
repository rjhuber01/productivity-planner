<!DOCTYPE html>

<html>
  <head>
    <title> Productivity Assistant - Dashboard </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/dashboardstyle.css">

  </head>


  <body> 
    <div class="content">
      <div class="sideBarMenu">
        
        <h2> Menu </h2>

        <form action="http://localhost:8081/prodAssistant/dashboard" method="GET">
          <button class="menuItem"> <span class=buttonText> Home </span> </button>
        </form>
        
        <form action="http://localhost:8081/prodAssistant/pomoTimer" method="GET">
          <button class="menuItem"> <span class=buttonText> Pomodoro </span> </button>
        </form>
      
      	<form action="http://localhost:8081/prodAssistant/tasks" method="GET">
      		<button class="menuItem"> <span class=buttonText> Tasks </span> </button>
      	</form>
      	
       	<form action="http://localhost:8081/prodAssistant/calendar" method="GET">
      		<button class="menuItem" id="textSeparator"> <span class=buttonText> Calendar </span> </button>
      	</form>  
      	
       	<form action="http://localhost:8081/prodAssistant/settings" method="GET">
      		<button class="menuItem"> <span class=buttonText> Settings </span> </button>
      	</form> 
        <button class="menuItem"> <span class=buttonText> Logout </span> </button>
      </div>

      <div class="userSummary">
        <h1> Hello, User </h1>
        <h2> Upcoming Things to Do: </h2>
        <div class="userSummaryTable">
          <h3> Task: </h3>
          <h3> Due Date: </h3>
          <!-- Status & Rank == progress & priority, respectively-->
          <h3> Progress: </h3>
          <h3> Priority: </h3>
          <h3> Description: </h3>
        </div>

        <!-- Populate data from DB -->
        <!-- Data: taskName dueDate Status Rank taskDescription -->
      </div>
    </div>
  </body>

</html>