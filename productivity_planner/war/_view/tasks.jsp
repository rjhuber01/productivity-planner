<!DOCTYPE html>

<html>
  <head>
    <title> Productivity Assistant - Dashboard </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/dashboardstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/taskStyle.css">
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
        <div class="taskTitle">
          <h1> Your Tasks: </h1>
          <button id="addTaskButton">+</button>
        </div>
      </div>
    </div>
    
    <!-- Outside main content div to allow it to be its own 'window'-->
    <div id="popUpWindow" class="popup">
      <div class="taskFormWindow"> 
        <span class="closeWindow" id="closeWindowButton">&times;</span>
        <div class="addTaskForm" id="taskForm">    
          
          <!--TODO: Change the styling for the form to make it more friendly. -->
          <form class="actorTaskForm">
            <label for="taskName">Task Name: </label>
            <input type="text" id="taskName" name="taskName" required>

            <label for="taskFolder"> Task Folder: </label>
            <input type="text" id="taskFolder" name="taskFolder">

            <label for="dueDate"> Due Date: </label>
            <input type="date" id="dueDate" name="dueDate" required>

            <label for="expectedTime"> Task Time: </label>
            <input type="number" id="expectedTime" name="expectedTime">

            <label for="status"> Progress: </label>
            <label for="statusNotStarted"> Not Started </label>
            <input type="radio" id="statusInProgress" name="status">
            <label for="statusInProgress"> In Progress </label>
            <input type="radio" id="statusComplete" name="status">
            <label for="statusComplete"> Complete </label>
            <input type="radio" id="statusNotStarted" name="status">

            <label for="taskDescription"> Task Description </label>
            <textarea id="taskDescription" name="taskDescription" rows="8" cols="50"> </textarea>

            <input type="submit" id="submitTask" name="submitTask" value="Submit"> 
          </form>
        </div>
      </div>
    </div>

    <script>
      let popUpButton = document.getElementById('addTaskButton');
      let popUpWindow = document.getElementById('popUpWindow');
      let closeWindowButton = document.getElementById('closeWindowButton');
      let backgroundContent = document.querySelector('.content');

      popUpButton.onclick = function() {
        backgroundContent.style.opacity = '0.25';
        popUpWindow.style.display="block";
      }

      closeWindowButton.onclick = function() {
        backgroundContent.style.opacity = '1';
        popUpWindow.style.display="none";
      }
    </script>
    
  </body>

</html>