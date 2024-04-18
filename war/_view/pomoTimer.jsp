<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	    <title> Productivity Assistant - Pomodoro Timer </title>
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/dashboardstyle.css">
	   	<link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/pomoStyles.css">
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
        <h1> Pomodoro Timer </h1>
        <div class="timerInformation">
          <div class="half">
            <h2 id="selectATask"> Select a Task: </h2>
            <select class="taskSelection" id="taskSelect">
            	<c:forEach var="task" items="${sessionScope.taskController.getAllTasks()}">
            		<option value="taskName">${task.getTaskName()}</option>
            	</c:forEach>
            </select>
          </div>
          <div class="half">
            <div class="sliderContainer"> 
              <h2> Select Time </h2>
              <h2 id="sliderValue"> 35 </h2> <h2 id="minutes"> Minutes </h2> <br> <br> <br>
              <input type="range" min="5" max="240" class="slider">
            </div>
          </div>
        </div>
        <img id="startIcon" src="${pageContext.request.contextPath}/_view/media/icons/start_icon.png" onclick = "startCountdown()">
      </div>
      
	</div>
	
	 <script>
      const rangeInput = document.querySelector('.slider');
      const sliderValue = document.getElementById('sliderValue');
      const startButton = document.getElementById('startIcon');

      rangeInput.addEventListener('input', updateSliderValue);
      updateSliderValue();

      function updateSliderValue() {
        sliderValue.textContent = rangeInput.value;
      }

      function startCountdown() {
        const totalTime = rangeInput.value * 60;
        let timeLeft = totalTime;

        updateSliderValue();

        rangeInput.disabled = true;
        startButton.style.pointerEvents = 'none';

        countdownInterval = setInterval(function() {
        timeLeft--;

        if(timeLeft >= 0) {
          let minutes = Math.floor(timeLeft/60);
          const seconds = timeLeft % 60;
          console.log(minutes);
          console.log(seconds);
          sliderValue.textContent = minutes + ':' + (seconds < 10 ? '0' + seconds : seconds);;
          } else {
            clearInterval(countdownInterval);
            sliderValue.textContent = '00:00';
            rangeInput.disabled = false;
            startButton.style.pointerEvents = 'auto';
            alert('Countdown Finished! Time to rest');
            }
          }, 1000);
        }
    </script>
	
  </body>

</html>