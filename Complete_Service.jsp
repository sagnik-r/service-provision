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
	String custName = request.getParameter("custName");
	String servDate = request.getParameter("servDate");
	out.println("<h2 style = 'font-family:georgia,garamond,serif;font-size:20px;font-style:bold;'>Have you Completed this Service : </h2><br>");
	out.println("<form method = 'post' action = 'Complete_Service_Servlet'>");
	out.println("<div class = 'container'>");
	out.println("<label for = 'bookingID'><b>Booking ID</b></label>");
	out.println("<input type = 'text' name = 'bookingID' value = '"+bookingID+"' readonly>");
	out.println("<label for = 'custName'><b>Customer Name</b></label>");
	out.println("<input type = 'text' name = 'custName' value = '"+custName+"' readonly>");
	out.println("<label for = 'servDate'><b>Service Date</b></label>");
	out.println("<input type = 'text' name = 'servDate' value = '"+servDate+"' readonly>");
	out.println("<button type = 'submit'>Confirm Completion</button></div></form>");
%>

</body>
</html>