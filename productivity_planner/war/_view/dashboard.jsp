<!DOCTYPE html>

<html>
  <head>
    <title> Productivity Assistant - Dashboard </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/dashboardstyle.css">

  </head>


  <body> 
    <div class="content">
      <div class="sideBarMenu">
        
       <form class="menuItem" action="http://localhost:8081/prodAssistant/pomoTimer" method="GET">
      	<input type="submit" value="Pomodoro">
      </form>
      
      	<form class="menuItem" action="http://localhost:8081/prodAssistant/tasks" method="GET">
      		<input type="submit" value="Tasks">
      	</form>
      	
       	<form class="menuItem" action="http://localhost:8081/prodAssistant/calendar" method="GET">
      		<input type="submit" value="Calendar">
      	</form>  
      	
       	<form class="menuItem" action="http://localhost:8081/prodAssistant/settings" method="GET">
      		<input type="submit" value="Settings">
      	</form>  	
      </div>

      <div class="userSummary">
        <h3> Hello, User </h3>
        <h4> Upcoming Assignments: </h4>
        <table> 
          <th scope="col"> Assignment: </th>
          <th> Course: </th>
          <th> Estimated Time </th>
          <th> Due: </th>
        </table>
      </div>
    </div>
  </body>

</html>