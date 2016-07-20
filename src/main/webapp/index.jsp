<%@page import="com.jayjariwala.nightlife.MODEL.BarModel" %>
<%@page import="java.util.ArrayList" %>
<% ArrayList<BarModel> list=(ArrayList<BarModel>) request.getAttribute("list"); %>
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
      <script src="https://npmcdn.com/masonry-layout@4.0/dist/masonry.pkgd.min.js"></script>
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

<form method="post" id="target" action="Search">


   <div class="col-lg-10">
  <input id="textinput" name="searchInput" type="text" placeholder="Your Area Name" class="form-control input-md" required>
  </div>
  <div class="col-lg-2">
<button class="btn btn-block" id="go" style="color:black" >GO!</button>
  </div>
</form> <br/><br/>

<br/>
</div>


  <!--<div class="list-group list">

  <div class="row">
    <div class="col-lg-2">
  <center><img src="https://s3-media2.fl.yelpcdn.com/bphoto/mP1rPIieZD_UKqDO18Oa3Q/ms.jpg"> </center>
  </div>
  <div class="col-lg-2">
  <h4>The Rock Bar Grill </h4>

  </div>

  <div class="col-lg-7">
  <i>Came here on a football Sunday to watch some basketball. We went in the late afternoon and it was surprisingly not completely packed. The bartender was..."</i>
  </div>
</div> -->
<!--
<div class="row">
  <div class="col-sm-6 col-md-3 tile">
    <div class="thumbnail">
      <img src="https://s3-media2.fl.yelpcdn.com/bphoto/mP1rPIieZD_UKqDO18Oa3Q/ms.jpg" width="100%">
    </div>
      <div class="caption">
        <center>
          <h3>Thumbnail label</h3>
        </center>
        <p>Where do I start? Ah, yes. I work as an intern near by and pass by almost every day to go the train, and I always see a paper sign taped to the door that...</p>
        <center>
     <center><span class="btn btn-default badge">Going! <span class="badge" style="color:orange">0</span></span></center>
        </center>

      </div>

</div>



</div>
-->
<div class="grid" data-masonry='{ "itemSelector": ".grid-item", "columnWidth": 180 }'>


<!--      --------->

<% if(list!=null)
{
	for(BarModel model:list)
	{
		out.print("<div class='grid-item'><img src='"+model.getImage()+"' width='156px;'><br/><center><u>"+model.getName()+"</u></center><center><img src='"+model.getRating()+"'></center><br/>\""+model.getComment()+"\"<br/><span style='color:orange'>-----------------------------</span><br/><center><button class='btn btn1'> <span style='font-size:10px'><span class='badge' style='color:orange'>0</span> Going</span></button> </center><br/></div>");
	}
}
	
	
	%>


     







    </div>






</html>
