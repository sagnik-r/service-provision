<html>
<head>
<style>

body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: darkslategray;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.container {
  padding: 16px;
  height: 280px;
  width: 50%;
  background-color: gainsboro;
}

.select-style {
    border: 1px solid #ccc;
    width: 200px;
    border-radius: 13px;
    overflow: hidden;
    background-color: LightGray;
}

.select-style select {
    padding: 10px 8px;
    width: 130%;
    border: none;
    border-radius: 13px;
    box-shadow: none;
    background-color: LightGray;
    background-image: none;
    -webkit-appearance: none;
}

.select-style select:focus {
    outline: none;
}

</style>
</head>
<body>
<%
	int bookingID = Integer.parseInt(request.getParameter("bookingID"));
	String userID = request.getParameter("userID");
	String providerID = request.getParameter("providerID");
	String servDate = request.getParameter("servDate");
	String servDisp = request.getParameter("servType");
	
	
	out.println("<div class = 'container'>");
	out.println("<form method = 'post' action = 'Rating_Entry'>");
	out.println("<h2 style = 'font-family:georgia,garamond,serif;font-size:20px;font-style:bold;'>Submit a Rating for the following Booking :</h2>");
	out.println("<label for = 'bookingID'><b>Booking ID</b></label> ");
	out.println("<input type = 'text' name = 'bookingID' value = '"+bookingID+"' readonly>");
	out.println("<label for = 'servType'><b>Service Type</b></label> ");
	out.println("<input type = 'text' name = 'servType' value = '"+servDisp+"' readonly>");
	out.println("<label for = 'servDate'><b>Service Date</b></label> ");
	out.println("<input type = 'text' name = 'servDate' value = '"+servDate+"' readonly>");
	out.println("<input type = 'hidden' name = 'userID' value = '"+userID+"' readonly>");
	out.println("<input type = 'hidden' name = 'providerID' value = '"+providerID+"' readonly>");
	
	out.println("<br><br><br><label for = 'rating'><b>Rate on a scale of 1-5</b></label> <br>");
	out.println("<input type = 'radio' name = 'rating' value = '1' required>1&#10025");
	out.println("<input type = 'radio' name = 'rating' value = '2'>2&#10025");
	out.println("<input type = 'radio' name = 'rating' value = '3'>3&#10025");
	out.println("<input type = 'radio' name = 'rating' value = '4'>4&#10025");
	out.println("<input type = 'radio' name = 'rating' value = '5'>5&#10025");
	out.println("<br><br><br><label for = 'review'><b>Review Service</b></label> <br>");
	out.println("<input type = 'text' name = 'review' placeholder = 'Write a Review' required maxlength = '150'>");
	out.println("<br><br><label for = 'complaint'><b>Register Review as Complaint</b></label> ");
	out.println("<div class='select-style'>"
			  +"<select id='complaint' name='complaint' required>"
			  +"<option value='no'>No</option>"
			  +"<option value='yes'>Yes</option>"
			  +"</select>"
			  +"</div>");
	
	out.println("<br><br><button type = 'submit' style = 'font-family:georgia,garamond,serif;font-size:20px;font-style:bold;'>Submit Rating and Review</button></div></form>");
%>
</body>
</html>