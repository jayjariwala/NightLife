<%@page import="com.jayjariwala.nightlife.MODEL.BarModel" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="twitter4j.Twitter"%>
<% ArrayList<BarModel> list=(ArrayList<BarModel>) request.getAttribute("list"); %>
<% Twitter twitter = (Twitter) request.getSession().getAttribute("twitter"); %>
<%String searchKeyword=(String) request.getAttribute("searchkeyword"); %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
     <link rel="icon" href="img/NightLife.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>NightLife Coordination</title>

      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="stylesheet" type="text/css" href="css/grid.css">
      
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kadwa' rel='stylesheet' type='text/css'>
    <link href="font-awesome-4.6.3/css/font-awesome.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>


  </head>
  <body>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
  <br/>

  <div class="container">
<center><h1>Plans Tonight?</h1></center>

<center><i class="fa fa-map-marker fa-5x" style="color:white"></i>&nbsp;&nbsp;&nbsp;<i class="fa fa-car fa-5x" style="color:white"></i>&nbsp;&nbsp;<i class="fa fa-glass fa-5x" style="color:white"></i></center> <br/><br/>
<h4 style="color:orange"><center>See Which Bar are hoppin' tonight and RSVP ahead of time! <br> Remember: Take a cab and drink responsibly</center></h4>
<br/>
<br/>

<form method="post" action="Search" id="target">


   <div class="col-lg-10 ">
  <input id="textinput" name="searchInput" type="text" placeholder="Your Area Name" class="form-control input-md" required>
  </div>
  <div class="col-lg-2">
<button class="btn btn-block" id="go" style="color:black" >GO!</button>
  </div>
</form> <br/><br/>

<br/>

  <div class="list-group ">
  
  

 <% if(list!=null){
	 	
	 	if(twitter!=null)
	 	{
	 		for(BarModel model:list)
	 		 {
	 			 out.println("<div class='row list'><form action='UserAction' method='post'><input type='hidden' name='barId' value='"+model.getId()+"'><input type='hidden' name='searchkeyword' value='"+searchKeyword+"'><div class='col-lg-2'><center><span class='photo'><img src='"+model.getImage()+"'></span></center></div><div class='col-lg-2'><a href='"+model.getUrl()+"' target='_blank'><center><h4>"+model.getName()+"</h4></center></a> <center><button class='btn btn-default'>Going! <span class='badge' style='color:orange'>"+model.getCount()+"</span></button></center></div> <div class='col-lg-7'><i>\""+model.getComment()+"\"</i><br/><img src='"+model.getRating()+"' /></form></div></div>");
	 		 }		
	 	}
	 	else
	 	{
	 		for(BarModel model:list)
	 		 {
	 			 out.println("<div class='row list'><form action='TwitterLoginServlet' method='get'><div class='col-lg-2'><center><span class='photo'><img src='"+model.getImage()+"'></span></center></div><div class='col-lg-2'><a href='"+model.getUrl()+"' target='_blank'><center><h4>"+model.getName()+"</h4></center></a> <center><button class='btn btn-default'>Going! <span class='badge' style='color:orange'>"+model.getCount()+"</span></button></center></div> <div class='col-lg-7'><i>\""+model.getComment()+"\"</i><br/><img src='"+model.getRating()+"' /></form></div></div>");
	 		 }
	 		
	 	}
	 
	 
 }
	 %>
 
 
  


</div>

</html>
