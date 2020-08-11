<html>

<head>
<style> 
input[type=submit] {
  background-color: #303036;
  border: none;
  color: white;
  padding: 10px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}

.header {
	background: #303036;
	color: #d3d3d3;
	height : 130px;
	position: relative;
}

.header .header-content{
	height: 100px;
	display: flex;
}

.header .header-content .header-section{
	flex: 1;
	text-align: center;
}


.header2 {
	background: darkslategray;
	color: #d3d3d3;
	height : 130px;
	width: 50%;
	position: relative;
}

.header2 .header-content2{
	height: 100px;
	display: flex;
}

.header2 .header-content2 .header-section2{
	flex: 1;
	text-align: left;
}

.footer {
	background: #303036;
	color: #d3d3d3;
	height : 200px;
	position: relative;
}

.footer .footer-bottom {
	background: #343a40;
	color: #686868;
	height: 25px;
	width: 100%;
	position: absolute;
	text-align : center;
	bottom: 0px;
	left: 0px;
	padding-top : 20px;
}

.footer .footer-content {
	height: 175px;
	display: flex;	
}

.footer .footer-content .footer-section{
	flex: 1;
}

</style>
</head>
<body>

<%
	//response.setHeader("Cache-Control","no-cache,co-store,must-revalidate");
	//response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("Login.jsp");
	}
	String uname = (String)session.getAttribute("username");
	
	
	
	out.println("<div class = 'header'>");
		out.println("<div class = 'header-content'>");
			out.println("<div class = 'header-section welcome'>");
				out.println("<p style = 'font-family:georgia,garamond,serif;font-size:16px;font-style:italic;'>");
				out.println("This is your Dashboard.<br>Here you can find your upcoming services");
				out.println("and also take a comprehensive look at your previously completed services<br>");
				out.println("Your Satisfaction is our primary concern. In case of any difficulty");
				out.println("feel free to contact us at the details given below");
			out.println("</div>");
		
			out.println("<div class = 'header-section welcome'>");
				out.println("<h2>Welcome, "+uname+"<h2>");
			out.println("</div>");
			/*This is to LogOut*/
			out.println("<div class = 'header-section action'>");
				out.println("<form action = 'Logout' method = 'post'>");
				out.println("<input type = 'submit' style = 'font-family:georgia,garamond,serif;font-size:18px;font-style:bold;' value ='Logout &#8688'></form>");
	
	/*This is to view User Profile*/
				out.println("<form action = 'View_Profile' method = 'post'>");
				out.println("<input type = 'hidden' name = 'uname' value = '"+uname+"'>");
				out.println("<input type = 'submit' style = 'font-family:georgia,garamond,serif;font-size:18px;font-style:bold;' value = 'View Profile &#10001'></form>");
			out.println("</div>");
		out.println("</div>");
	out.println("</div>");
	
	out.println("<br><br>");
	
	out.println("<div class = 'header2'>");
		out.println("<div class = 'header-content2'>");
			out.println("<div class = 'header-section2 desc'>");
				out.println("<p style = 'font-family:georgia,garamond,serif;font-size:18px;font-style:bold;'>");
				out.println("Want a look at your completed services?<br> ");
				out.println("Click on \"Completed Services\" to get the list of services you have completed</p>");
			out.println("</div>");
			
			out.println("<div class = 'header-section2 end'>");
				out.println("<form method = 'post' action = 'Completed_Services'>");
				out.println("<input type = 'hidden' name = 'uname' value = '"+uname+"'>");
				out.println("<input type='submit' style = 'background-color: 	darkslategray;font-family:georgia,garamond,serif;font-size:18px;font-style:bold;' value = 'Completed Services'></form>");
			out.println("</div>");
		out.println("</div>");
	out.println("</div>");
	
	out.println("<br><br>");
	
	out.println("<div class = 'header2'>");
	out.println("<div class = 'header-content2'>");
		out.println("<div class = 'header-section2 desc'>");
			out.println("<p style = 'font-family:georgia,garamond,serif;font-size:18px;font-style:bold;'>");
			out.println("Want a look at your upcoming pending services?<br> ");
			out.println("Click on \"Upcoming Services\" to get the list of services you have pending</p>");
		out.println("</div>");
		
		out.println("<div class = 'header-section2 end'>");
			out.println("<form method = 'post' action = 'Upcoming_Services'>");
			out.println("<input type = 'hidden' name = 'uname' value = '"+uname+"'>");
			out.println("<input type='submit' style = 'background-color: darkslategray;font-family:georgia,garamond,serif;font-size:18px;font-style:bold;' value = 'Upcoming Services'></form>");
		out.println("</div>");
	out.println("</div>");
out.println("</div>");
	
	
	/*This is to view Upcoming Services*/
	/*out.println("<form method = 'post' action = 'Upcoming_Services'>");
	out.println("<input type = 'hidden' name = 'uname' value = '"+uname+"'>");
	out.println("<input type='submit' value = 'Upcoming Services'></h3></form>");*/
	
%>

<br><br><br><br>
<div class = "footer">
	<div class = "footer-content">
		<div class = "footer-section about">
			 <p style = "font-family:georgia,garamond,serif;font-size:20px;font-style:bold;">
			About Us:<br></p>
			 <p style = "font-family:georgia,garamond,serif;font-size:16px;font-style:italic;">
			We are a service provisioning company
			working on the goal to bring together
			our consumers and providers on the same
			platform to make our day-to-day lives easier<br><br>
			
			We provide a wide array of services that take care of all your daily requirements from 
			housekeeping to carwashing and many more....</p>
		</div>
		<div class = "footer-section contact">
			 <p style = "font-family:georgia,garamond,serif;font-size:20px;font-style:bold;">
			 Contact Us:<br><br>
			 	&#9743; 7044103279<br>
			 	&#x2709; sagnik_r@iitkgp.ac.in
			 	</p>
		</div> 
	<div class= "footer-bottom">
		&copy; Sagnik Roy | Design and Implemented by : Sagnik Roy
	</div>
	</div>
</div>
</body>
</html>