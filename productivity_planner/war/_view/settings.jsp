<!DOCTYPE html>

<html>
  <head>
    <title> Productivity Assistant - Dashboard </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/dashboardstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/settings.css">

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
        <h1> Settings </h1>
        <div class="settingsContainer">
	        <div class = "settingsText">
	          <p> Account </p>
	          <p> Password </p>
	          <p> Data Management </p>
	          <p> Visual Mode </p>
	        </div>
	
	        <div class="settingsCommand">
	          <!-- Change text content here to correct user -->
	          <p id = "userEmail"> email@email.com </p>
	          <button class="settingsAction" id="changeEmail" onclick="showPopup('emailPopup')"> Change Email </button> <br />
	          <button class="settingsAction" id="changePassword" onclick="showPopup('passwordPopup')"> Change Password </button> <br />
	          <button class="settingsAction" id = "deleteData" onclick="showPopup('deleteDataPopup')"> Delete Data </button>
	          <button class="settingsAction" id = "deleteAccount" onclick="showPopup('deleteAccountPopup')" > Delete Account</button> <br />
	          <button class="settingsAction" onclick="showPopup('colorPopup')"> Color </button>
	        </div>
      	</div>
      </div>
    </div>
    
        <div class="popupContainers">
      <div id="emailPopup" class="popup">
        <div class="popup-content">
          <h2 class="userTitle"> Change Email: </h2>
          <button class="close-btn" onclick="closePopup('emailPopup')">X</button>
          <form>
            <div class="inputContainer">
              <label for="currentEmail">Current Email:</label>
              <input type="email" id="oldEmail" placeholder="Enter current email" required>
            </div>
            <div class="inputContainer">
              <label for="newEmail">New Email:</label>
              <input type="email" id="newEmail" placeholder="Enter new email" required>
            </div>
            <div class="inputContainer">
              <label for="currentPassword">Current Password:</label>
              <input type="password" id="currentPassword" placeholder="Enter current password" required>
            </div>
            <button class="submit" type="submit"> Submit </button>
          </form>
        </div>
      </div>
      
      <div id="passwordPopup" class="popup">
        <div class="popup-content">
          <h2> Change Password: </h2>
          <form>
            <div class="inputContainer">
              <label for="currentEmail">Current Email:</label>
              <input type="email" id="currentEmail" placeholder="Enter current email" required>
            </div>
            <div class="inputContainer">
              <label for="newEmail">Old Password:</label>
              <input type="password" id="oldPassword" placeholder="Enter old password" required>
            </div>
            <div class="inputContainer">
              <label for="currentPassword">New Password:</label>
              <input type="password" id="newPassword" placeholder="Enter new password" required>
            </div>
            <button class="submit" type="submit"> Submit </button>
          </form>
          <button class="close-btn" onclick="closePopup('passwordPopup')">X</button>
        </div>
      </div>

      <div id="deleteDataPopup" class="popup">
        <div class="popup-content">
          <h2> <img class="warningIcon" src="${pageContext.request.contextPath}/_view/media/icons/Danger_Icon.svg"> Delete User Data <img class="warningIcon" src="${pageContext.request.contextPath}/_view/media/icons/Danger_Icon.svg"> </h2>
          <p> <strong> Warning: </strong> You are going to delete all of your data. This will be all of your tasks and respective analytics on those tasks. Your account will remain active. Are you sure you want to proceed? </p>
          <p class="finalWarning"> <strong> This Action is Irreversible! </strong></p>
          <form id="deleteDataForm">
            <button id="deleteDataButton" class="deleteSubmit" type="submit" value="deleteDataConfirmation"> Hold to delete data </button>
          </form>
          <div id="progressBar"></div>
          <button class="close-btn" onclick="closePopup('deleteDataPopup')">X</button>
        </div>
      </div>

      <div id="deleteAccountPopup" class="popup">
        <div class="popup-content">
          <h2> <img class="warningIcon" src="${pageContext.request.contextPath}/_view/media/icons/Danger_Icon.svg"> Delete User Account <img class="warningIcon" src="${pageContext.request.contextPath}/_view/media/icons/Danger_Icon.svg"> </h2>
          <p> <strong> Warning: </strong> You are about to delete your entire account. This will remove your account *AND DATA* from our system. Your information is unrecoverable if you continue. Are you sure you want to proceed? </p>
          <p class="finalWarning"> <strong> This Action is Irreversible! </strong></p>
          <!-- Make this issue a POST with a value of "deleteAccountConfirmation so the servlet can handle"-->
          <form>
            <button class="deleteSubmit" type="submit" value="deleteAccountConfirmation"> I understand, delete my account </button>
            <div id="progressBar"></div>
          </form>
          <button class="close-btn" onclick="closePopup('deleteAccountPopup')">X</button>
        </div>
      </div>

      <div id="colorPopup" class="popup">
        <div class="popup-content">
          <h2> Change View: </h2>
          <div class="informationContainer">
            <div class="userInformation"> 
            </div>
          </div>
          <button class="close-btn" onclick="closePopup('colorPopup')">X</button>
        </div>
      </div>
    </div>
    
    <script>
    let backgroundContent = document.querySelector('.content');

      function showPopup(popupID) {
        let popup = document.getElementById(popupID);
          if(popup) {
            console.log('Popup should appear');
            backgroundContent.style.opacity = '0.25';
            popup.style.display = "block";
          }
      }

      function closePopup(popupID) {
        let popup = document.getElementById(popupID);
        if(popup) {
          backgroundContent.style.opacity = '1';
          popup.style.display = "none";
        }
      }
    </script>

    <script>
      let holdTimer;
      const holdDuration = 3000; // 3 seconds in milliseconds
      const initialColor = "#007bff"; // Initial button color
      const finalColor = "#dc3545"; // Final button color
      let deleteDataButton = document.getElementById("deleteDataButton");
      let deleteDataForm = document.getElementById("deleteDataForm");

      deleteDataButton.addEventListener("mousedown", startHoldTimer);
      deleteDataButton.addEventListener("mouseup", cancelHoldTimer);
      deleteDataButton.addEventListener("mouseleave", cancelHoldTimer);

      function startHoldTimer() {
        let startTime = Date.now();
        holdTimer = setInterval(function() {
          let elapsedTime = Date.now() - startTime;
          let progress = Math.min(elapsedTime / holdDuration, 1); // Calculate progress from 0 to 1
          let interpolatedColor = interpolateColor(initialColor, finalColor, progress);
          deleteDataButton.style.backgroundColor = interpolatedColor;
          if (elapsedTime >= holdDuration) {
            clearInterval(holdTimer);
            submitForm();
          }
        }, 10);
      }

      function cancelHoldTimer() {
        clearInterval(holdTimer);
        deleteDataButton.style.backgroundColor = initialColor; // Reset button color
      }

      function submitForm() {
        deleteDataForm.submit();
        console.log("Form Submitted");
        Windows.alert("Data has successfully been removed. Thank you for using our application. ");
      }

      // Function to interpolate color based on progress
      function interpolateColor(color1, color2, progress) {
        let r1 = parseInt(color1.slice(1, 3), 16);
        let g1 = parseInt(color1.slice(3, 5), 16);
        let b1 = parseInt(color1.slice(5, 7), 16);
        let r2 = parseInt(color2.slice(1, 3), 16);
        let g2 = parseInt(color2.slice(3, 5), 16);
        let b2 = parseInt(color2.slice(5, 7), 16);
        let r = Math.round(r1 + (r2 - r1) * progress);
        let g = Math.round(g1 + (g2 - g1) * progress);
        let b = Math.round(b1 + (b2 - b1) * progress);
        return "#" + (r < 16 ? "0" : "") + r.toString(16) + (g < 16 ? "0" : "") + g.toString(16) + (b < 16 ? "0" : "") + b.toString(16);
      }
    </script>
    
    
  </body>

</html>