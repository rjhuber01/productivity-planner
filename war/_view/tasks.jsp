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
	        <div class="basicTaskInfo">
	          <input type="hidden" id="userID" value="userID" />
	
	          <label for="taskName" class="labelName"> Task Name: <span class="required">*</span> </label>
	          <input type="text" id="taskName" name="taskName" placeholder="Enter a Name for the Task" required/>
	
	          <label for="taskFolder" class="labelName"> Task Folder: </label>
	          <input type="text" id="taskFolder" name="taskFolder" placeholder="Give me a folder!"/>
	
	          <label for="dueDate" class="labelName"> Due Date: <span class="required">*</span> </label>
	          <input type="date" id="dueDate" name="dueDate" required/>
	
	          <div class="timeHandler">
	            <label for="taskTime" class="labelName"> Task Time: </label>
	            <input type="number" id="taskTime" name="taskTime" placeholder="Enter time to finish"/>
	
	            <select id="timeUnit" name="timeUnit">
	              <option value="minutes"> Minutes </option>
	              <option value="hours"> Hours </option>
	              <option value="days"> Days </option>
	            </select>
	          </div>
	        </div>
	
	        <div class="radioTaskInfo">
	          <label class="labelName"> <strong> Progress: </strong> </label>
	          
	          <input type="radio" id="notStarted" name="status" value="Not Started"/>
	          <label for="notStarted">Not Started </label>
	          <input type="radio" id="inProgress" name="status" value="In Progress"/>
	          <label for="inProgress"> In Progress </label>
	          <input type="radio" id="completed" name="status" value="Completed" />
	          <label for="completed"> Completed </label>
	          
	          <br />
	
	          <label class="labelName"> <strong> Priority: </strong> </label>
	          
	          <input type="radio" id="notImportant" name="rank" value="Not Important" />
	          <label for="notImportant"> Not Important </label>
	          <input type="radio" id="important" name="rank" value="Important" />
	          <label for="important"> Important </label>
	          <input type="radio" id="urgent" name="rank" value="Urgent"/>
	          <label for="urgent"> Urgent </label>
	        </div>
	        
	        <label for="taskDescription" class="labelName"> Task Description: </label>
	        <br />
	        <textarea id="taskDescription" name="taskDescription" rows="8" cols="50"></textarea>
	        <input type="submit" id="submitTask" name="submitTask" value="Submit" />
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