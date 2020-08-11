<html>
<head>
<style>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
body {font-family: georgia,garamond,serif;}
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
  background-color: #2F4F4F;
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
  height: 200px;
  width: 50%;
  background-color: gainsboro;
}

.select-style {
    border: 1px solid #ccc;
    width: 200px;
    border-radius: 13px;
    overflow: hidden;
    background-color: 	slategray;
    color: white;
}

.select-style select {
    padding: 10px 8px;
    width: 130%;
    border: none;
    border-radius: 13px;
    box-shadow: none;
    background-color: 	slategray;
    background-image: none;
    -webkit-appearance: none;
    color: white;
}

.select-style select:focus {
    outline: none;
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
<form method = "post" action = "Login_Validate">


<div class = "container">

<label for = "uname"><b>Username</b></label>
<input type="text" placeholder = "Enter Username" name = "uname" required>

<label for="pass"><b>Password</b></label>
<input type="password" placeholder = "Enter Password" name = "pass" required>



<button type = "submit" style = "font-family:georgia,garamond,serif;font-size:16px;font-style:bold;">Login &#128477</button>



</div>
</form>

<form method = "post" action="New_User">

<div class = "container">
<center><b>Don't have an Account? Sign UP<br><br><br></b></center>

<b>Select User Type :</b><br><br>  
  <div class="select-style">

  <select id="utype" name="utype" required>
    <option value="customer">Customer</option>
    <option value="provider">Service Provider</option>
 
  </select>
 </div>
  <br>
  <button type="submit" style = "font-family:georgia,garamond,serif;font-size:16px;font-style:bold;">Sign Up</button>

</div>
</form>
<br>
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