<!DOCTYPE html>

<html>
  <head>
    <title> Productivity Assistant - Dashboard </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/dashboardstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/media/calendar.css">
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
        <h1> Calendar </h1>
        <div class="calendar-container">
          <header class="calendar-header">
              <p class="calendar-current-date"></p>
              <div class="calendar-navigation">
                  <span id="calendar-prev" class="material-symbols-rounded"> &lt; </span>
                  <span id="calendar-next" class="material-symbols-rounded"> &gt; </span>
              </div>
          </header>
   
          <div class="calendar-body">
              <ul class="calendar-weekdays">
                  <li>Sun</li>
                  <li>Mon</li>
                  <li>Tue</li>
                  <li>Wed</li>
                  <li>Thur</li>
                  <li>Fri</li>
                  <li>Sat</li>
              </ul>
              <ul class="calendar-dates"></ul>
          </div>
      </div>
      </div>
    </div>

    <script>
     	let date = new Date();
		let year = date.getFullYear();
		let month = date.getMonth();

		const day = document.querySelector(".calendar-dates");
		
		const currdate = document
			.querySelector(".calendar-current-date");
		
		const prenexIcons = document
			.querySelectorAll(".calendar-navigation span");

		// Array of month names
		const months = [
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		];
		
		// Function to generate the calendar
		const manipulate = () => {
		
			// Get the first day of the month
			let dayone = new Date(year, month, 1).getDay();
		
			// Get the last date of the month
			let lastdate = new Date(year, month + 1, 0).getDate();
		
			// Get the day of the last date of the month
			let dayend = new Date(year, month, lastdate).getDay();
		
			// Get the last date of the previous month
			let monthlastdate = new Date(year, month, 0).getDate();
		
			// Variable to store the generated calendar HTML
			let lit = "";
		
			// Loop to add the last dates of the previous month
			for (let i = dayone; i > 0; i--) {
				lit += '<li class="inactive">' + (monthlastdate - i + 1) + '</li>'; 
				console.log(lit);
			}
		
			// Loop to add the dates of the current month
			for (let i = 1; i <= lastdate; i++) {
		
				// Check if the current date is today
				let isToday = i === date.getDate()
					&& month === new Date().getMonth()
					&& year === new Date().getFullYear()
					? "active"
					: "";
			    lit += '<li class="' + isToday + '">' + i + '</li>';
			}
		
			// Loop to add the first dates of the next month
			for (let i = dayend; i < 6; i++) {
			    lit += '<li class="inactive">' + (i - dayend + 1) + '</li>';
			}
		
			// Update the text of the current date element 
			// with the formatted current month and year
			currdate.innerText = months[month] + " " + year;
		
			// update the HTML of the dates element 
			// with the generated calendar
			day.innerHTML = lit;
		}
		
		manipulate();
		
		// Attach a click event listener to each icon
		prenexIcons.forEach(icon => {
		
			// When an icon is clicked
			icon.addEventListener("click", () => {
		
				// Check if the icon is "calendar-prev"
				// or "calendar-next"
				month = icon.id === "calendar-prev" ? month - 1 : month + 1;
		
				// Check if the month is out of range
				if (month < 0 || month > 11) {
		
					// Set the date to the first day of the 
					// month with the new year
					date = new Date(year, month, new Date().getDate());
		
					// Set the year to the new year
					year = date.getFullYear();
		
					// Set the month to the new month
					month = date.getMonth();
				}
		
				else {
		
					// Set the date to the current date
					date = new Date();
				}
		
				// Call the manipulate function to 
				// update the calendar display
				manipulate();
			});
		});
    </script>
  </body>

</html>