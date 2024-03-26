<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
	
	<div class="pomodoroTimer">
        <h1> Pomodoro Timer </h1>
        <c:if test="${empty sessionScope.taskController.getAllTasks()}">
	    	<h2> Add Tasks to use Pomodoro Timer! </h2>
        </c:if>
        <c:if test="${not empty sessionScope.taskController.getAllTasks()}">
        	<form id="taskForm">
    			<select id="taskSelect">
        			<c:forEach var="task" items="${sessionScope.taskController.getAllTasks()}">
            			<option value="${task.expectedTime}">${task.taskName}</option>
        			</c:forEach>
    			</select>
    			<button id="startTimerBtn">Start Timer</button>
			</form>
		<script>
    	document.getElementById('startTimerBtn').addEventListener('click', function() {
        	var timeInSeconds = parseInt(document.getElementById('taskSelect').value);
        	startTimer(timeInSeconds);
        	});

    	function startTimer(duration) {
        	var timer = duration, hours, minutes, seconds;
        	setInterval(function () {
            	hours = parseInt(timer / 3600, 10);
            	minutes = parseInt((timer % 3600) / 60, 10);
            	seconds = parseInt(timer % 60, 10);

            	hours = hours < 10 ? "0" + hours : hours;
            	minutes = minutes < 10 ? "0" + minutes : minutes;
            	seconds = seconds < 10 ? "0" + seconds : seconds;

            	document.getElementById('countdown').textContent = hours + ":" + minutes + ":" + seconds;

            	if (--timer < 0) {
                	timer = duration;
            	}
        	}, 1000);
    	}
		</script>
		</c:if>
		<div class="timer">
    		<h2 id="countdown">00:00:00</h2>
		</div>
      </div>
    </div>
  </body>
</html>