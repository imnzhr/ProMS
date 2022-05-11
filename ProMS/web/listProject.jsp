<%@page import="com.employee.employeeDB"%>
<%@page import="com.employee.employee"%>
<%@page import="com.util.dataDB"%>
<%@page import="com.project.project"%>
<%@page import="com.project.projectDB"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
.container{
    width: 100%;
    margin: auto;
    overflow: hidden;
    margin-top: 20px;
}

.container ul{
    padding: 0px;
    margin: 0px;
}

.container ul li{
    float:left;
    list-style: none;
    width:28%;
    height:270px;
    background: #DCDCDC;
    margin :20px 0px 20px 55px; 
    box-sizing: border-box;
    border-radius: 30px;
}

.container ul li .bottom{
    width: 100%;
    height:50px;
    line-height: 50px;
    background: #DCDCDC;    
    text-align: center;
    color:black;
    font-size: 25px;
   	border-radius: 30px;
}

footer{
    background-color:lightgray;
    font-size: 12px;
    line-height: 0.8;
}

@media screen and (max-width:1250px){
    .container ul li{
        width:40%;
        margin-left: 40px;
         
    }
}
</style>
<head>
        <title>View Project</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <img class=" w3-bar-item w3-right" src="Image/MKR-logo.png" alt="LogoCompany" width="45" height="55">
</div>

<!-- Sidebar/menu -->
        <% employee Employee = (employee)session.getAttribute("emp");
        %>
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="Image/<%= Employee.getImg()%>" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8 w3-bar ">
      <span>Welcome, <br><strong><%= Employee.getName()%></strong></span><br>
      <span>Staff Id:<br><strong><%= Employee.getId()%></strong></span><br>
      <span>Department:<br><strong><%= Employee.getDepname()%></strong></span><br>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5><b>Dashboard</b></h5>
  </div>
  <div class="w3-bar-block">
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="home.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-home fa-fw"></i>  Home</a>
    <%if(Employee.getDepname().equals("Sales")){%>
    <a href="addProject.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  Add project</a><%}%>
    <a href="listProject.jsp" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-sort-amount-asc fa-fw"></i>  Project List</a>
    <a href="listTask.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-server fa-fw"></i>  Task List</a>
    <a href="LogoutServlet" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

 <!-- Header -->
        <% 
            dataDB util = new dataDB();
        %>
  <header class="w3-container" style="padding-top:22px">
      <h1><b>List of Project</b></h1>
  </header>
  <div class="container">
      <ul> 
          <% 
              for(int i=1; i<=util.getSize("project"); i++){
                  
                    projectDB proDB = new projectDB();
                    project Pro = proDB.selectProject(i);
                    
                    %>
                    <li> <div class="bottom"><b><%= Pro.getTitle()%></b></div>
                    <div class="w3-container">
                    Progress:
                    <div class="w3-grey">
                    <div class="
                        <% 
                            if(Pro.getStatus()<= 35){
                               %>w3-container w3-center w3-padding w3-red<%
                            }
                            else if(Pro.getStatus()> 35 && Pro.getStatus()<= 75){
                               %>w3-container w3-center w3-padding w3-yellow<%
                            }
                            else if(Pro.getStatus()> 75 && Pro.getStatus()<= 100){
                               %>w3-container w3-center w3-padding w3-green<%
                            }
                            else
                               %>w3-container w3-center w3-padding <%
                        %>"
                        style="width:<%= Pro.getStatus()%>%"><%= Pro.getStatus()%>%</div>
                    </div>
                    <br>
                    <div>Start Date:<%= Pro.getStartDate()%></div>
                    Est. End Date:<%= Pro.getEstEndDate()%>
                    <p></p>
                    <a href="viewProject.jsp?user=<%= Employee.getUsername()%>&id=<%=Pro.getId()%>" class="w3-button w3-block w3-dark-grey">
                        <%if(Pro.getStatus()==100){%>View Report</a><%} else {%> View Project Details</a><%}%>
                    </div></li><%
                }
          %>
            
        </ul>
    </div>
  <!-- End page content -->
  
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>

</body>
</html>
