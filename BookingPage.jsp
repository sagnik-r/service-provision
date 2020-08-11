<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>


<html>
<head>
<style>

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
    background-color: slategray;
    background-image: none;
    -webkit-appearance: none;
    color: white;
}

.select-style select:focus {
    outline: none;
}

input[type=submit] {
  background-color: darkslategray;
  border: none;
  color: white;
  padding: 10px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}

</style>
</head>
<body>

<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);

Date date = Calendar.getInstance().getTime();  
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
String[] strDate = new String[8];
strDate[0] = dateFormat.format(date);  
//out.println(strDate[0]+"<br>");  

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(strDate[0]));
for(int i=1;i<=7;i++)
{
	c.add(Calendar.DATE,1);
	strDate[i] = sdf.format(c.getTime());
	//out.println(strDate[i]+"<br>");
}
String uname = (String)session.getAttribute("username");
out.println("<form method = 'post' action='Make_Booking'>");
out.println("<b>Choose service type:</b>");
out.println("<input type = 'hidden' name = 'uname' value = '"+uname+"'>");
out.println(" <div class='select-style'>");
out.println("<select id='servType' name='servType'>"
		+ "<option value='acrep'>AC Repair</option>"
		+ "<option value='tvrep'>TV Repair</option>"
		+ "<option value='frirep'>Refrigerator Repair</option>"
		+ "<option value='carC'>Car Cleaning</option>"
		+ "<option value='carP'>Carpentry</option>"
		+ "<option value='elec'>Electrician</option>"
		+ "<option value='plu'>Plumbing</option>"
		+ "<option value='hkp'>House Keeping</option>"
		+ " </select>");
out.println("</div>");
out.println("<br><b>Choose a date :</b>");
out.println(" <div class='select-style'>");
out.println("<select id= 'servDate' name = 'servDate'>"
		+ "<option value='"+strDate[1]+"'>"+strDate[1]+"</option>"
		+ "<option value='"+strDate[2]+"'>"+strDate[2]+"</option>"
		+ "<option value='"+strDate[3]+"'>"+strDate[3]+"</option>"
		+ "<option value='"+strDate[4]+"'>"+strDate[4]+"</option>"
		+ "<option value='"+strDate[5]+"'>"+strDate[5]+"</option>"
		+ "<option value='"+strDate[6]+"'>"+strDate[6]+"</option>"
		+ "<option value='"+strDate[7]+"'>"+strDate[7]+"</option>"
		+ "</select></div>");
out.println("<br><input type = 'submit' value = 'Search'></form>");
%>
</body>
</html>