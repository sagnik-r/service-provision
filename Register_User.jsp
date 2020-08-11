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

input[type=submit] {
  background-color: #2F4F4F;
  border: none;
  color: white;
  padding: 12px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
</head>

<body>
<form method = "post" action = "User_Validation">
<div class = "container">
<b>Enter EmailID:</b><input type="text" placeholder = "EmailID" name = "emailID" required><br>
<b>Enter UserID:</b><input type="text" placeholder = "User Name" name = "uname" required><br>
<input type = "submit" value = "Validate">
</div>
</form>
</body>
</html> 