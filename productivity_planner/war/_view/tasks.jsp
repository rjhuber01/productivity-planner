<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title> Master List Of Tasks </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/dashboardstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/taskStyle.css">
  </head>


  <body> 
    <div class="content">
      <div class="sideBarMenu">
        
        <h2> Menu </h2>

        <form action="http://localhost:8081/prodAssistant/dashboard" method="GET">
          <button class="menuItem"> <span class="buttonText"> Home </span> </button>
        </form>
        
        <form action="http://localhost:8081/prodAssistant/pomoTimer" method="GET">
          <button class="menuItem"> <span class="buttonText"> Pomodoro </span> </button>
        </form>
      
      	<form action="http://localhost:8081/prodAssistant/tasks" method="GET">
      		<button class="menuItem"> <span class="buttonText"> Tasks </span> </button>
      	</form>
      	
       	<form action="http://localhost:8081/prodAssistant/calendar" method="GET">
      		<button class="menuItem" id="textSeparator"> <span class=buttonText> Calendar </span> </button>
      	</form>  
      	
       	<form action="http://localhost:8081/prodAssistant/settings" method="GET">
      		<button class="menuItem"> <span class="buttonText"> Settings </span> </button>
      	</form> 
        <button class="menuItem"> <span class="buttonText"> Logout </span> </button>
      </div>
      
      <div class="userSummary">
        <div class="taskTitle">
          <h1>Your Tasks:</h1>
          <button class="addTaskButton" id="addTaskButton">+</button>
          <button class="addTaskButton" id="editTaskButton" onclick="shakeRows()"> <img src="${pageContext.request.contextPath}/_view/media/icons/details_icon.svg"></button>
        </div>    
        
        <div id="taskTable">
        	<c:if test="${not empty sessionScope.taskController.getAllTasks()}">
	          <table>
	            <thead>
	              <tr>
	              	<th id="taskID"> Task ID: </th>
	                <th id="columnTaskName"> Task Name: </th>
	                <th id="columnFolder"> Task Folder: </th>
	                <th id="columnDueDate"> Due Date: </th>
	              </tr>
	            </thead>
	            	<tbody>
		    		 	<c:forEach var="task" items="${sessionScope.taskController.getAllTasks()}">
			   				<tr class="editableRow">
			   					<td>${task.taskID}</td>
			   					<td>${task.getTaskName()}</td>
			   					<td>${task.getFolderName()}</td>
			   					<td>${task.getDueDate()}</td>
			   				</tr>
		   				</c:forEach>
            		</tbody>
          		</table>
          	</c:if>
          <c:if test="${empty sessionScope.taskController.getAllTasks()}">
	          	<h2> No Task Submitted...Yet </h2>
          </c:if>
        </div>
      </div>
    </div>
    
    <!-- Outside main content div to allow it to be its own 'window'-->
    <div id="popUpWindow" class="popup">
      <div class="taskFormWindow"> 
        <span class="closeWindow" id="closeWindowButton">&times;</span>
        <div class="addTaskForm" id="taskForm">    
          
          <!--TODO: Change the styling for the form to make it more friendly. -->
          <form class="actorTaskForm" method="POST">
            <label for="taskName" class="labelName">Task Name<span class="required">*</span> <input type="text" id="taskName" name="taskName" required> </label>

            <label for="taskFolder" class="labelName">Folder:<input type="text" id="taskFolder" name="taskFolder"> </label>

            <label for="dueDate" class="labelName">Due Date<span class="required">*</span> <input type="date" id="dueDate" name="dueDate" required> </label>

            <label for="expectedTime" class="labelName">Task Time:<input type="number" id="expectedTime" name="expectedTime"> </label>

            <label for="status" class="labelName"> Progress: </label>
            <label for="statusNotStarted"> <span class="statusText"> Not Started </span> <input type="radio" id="statusNotStarted" name="status" value="0"> </label>
            <label for="statusInProgress"> <span class="statusText"> In Progress </span> <input type="radio" id="statusInProgress" name="status" value="1"> </label>
            <label for="statusComplete"> <span class="statusText"> Complete </span> <input type="radio" id="statusComplete" name="status" value="2"> </label>

            <label for="taskDescription" class="labelName"> Task Description </label>
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
      
      /* Shake the rows and make them editable. */
      let shakeInterval; 

      function shakeRows() {
        let rows = document.querySelectorAll('.editableRow');
        shakeInterval = setInterval(() => {
          rows.forEach(row => {
            row.classList.add('shakeAnimate');
          });
        }, 0);
      }

      function stopShake() {
        clearInterval(shakeInterval);
        let rows = document.querySelectorAll('.editableRow');
        rows.forEach(row => {
          row.classList.remove('shakeAnimate');
        });
      }

      //Event listener to stop shaking when editable row is clicked. 
      document.querySelectorAll('.editableRow').forEach(row => {
        row.addEventListener('click', () => {
          if(row.classList.contains('shakeAnimate')) {
            stopShake();
            //Get information from the clicked row
            let taskName = row.querySelector('td:nth-child(2)').innerText;
            let folderName = row.querySelector('td:nth-child(3)').innerText;

            let dueDateText = row.querySelector('td:nth-child(4)').innerText;
            //Due date returns 
            let dueDate = new Date(dueDateText);
            //Format into correct type
            let formattedDueDate = dueDate.toISOString().slice(0,10);

            //Populate the form fields with task information
            document.getElementById('taskName').value = taskName;
            document.getElementById('taskFolder').value = folderName;
            document.getElementById('dueDate').value = formattedDueDate;

            //Now display the form
            displayPopUpForm();
          }
        });
      });

      function displayPopUpForm() {
        backgroundContent.style.opacity = '0.25';
        popUpWindow.style.display="block";
      }
    </script>
    
  </body>

</html>