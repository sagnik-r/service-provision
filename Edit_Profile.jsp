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
  height: 585px;
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
	String uname = request.getParameter("uname");
	String emailID = request.getParameter("emailID");
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String pass = request.getParameter("pass");
	String phNO = request.getParameter("phNO");
	String address = request.getParameter("address");
	
	out.println("<form method = 'post' action = 'Edit_Profile_Servlet'>");
	out.println("<div class = 'container'>");
	out.println("<label for = 'uname'><b>User Name</b></label>");
	out.println("<input type = 'text' name = 'uname' value = '"+uname+"' readonly>");
	out.println("<label for = 'emailID'><b>Email ID</b></label>");
	out.println("<input type = 'text' name = 'emailID' value = '"+emailID+"' readonly>");
	out.println("<label for = 'fname'><b>First Name</b></label>");
	out.println("<input type = 'text' name = 'fname' value = '"+fname+"' readonly>");
	out.println("<label for = 'lname'><b>Last Name</b></label>");
	out.println("<input type = 'text' name = 'lname' value = '"+lname+"' readonly>");
	out.println("<label for = 'pass'><b>Password</b></label>");
	out.println("<input type = 'password' name = 'pass' value = '"+pass+"'>");
	out.println("<label for = 'phNO'><b>Phone Number</b></label>");
	out.println("<input type = 'text' name = 'phNO' value = '"+phNO+"'>");
	out.println("<label for = 'address'><b>Address</b></label>");
	out.println("<input type = 'text' name = 'address' value = '"+address+"'>");
	out.println("<button type = 'submit'>Save Changes</button></div></form>");
	
%>

</body>
</html>