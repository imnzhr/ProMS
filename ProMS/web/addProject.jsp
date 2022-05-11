<%@page import="com.employee.employeeDB"%>
<%@page import="com.employee.employee"%>
<%@page import="com.project.supplierDB"%>
<%@page import="com.project.clientDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.*"%>
<%@page import="com.util.dataDB"%>
<!DOCTYPE html>
<html>

<title>Add project</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}

footer{
    background-color:lightgray;
    font-size: 12px;
    line-height: 0.8;
}
</style>
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
    <a href="addProject.jsp" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-users fa-fw"></i>  Add project</a><%}%>
    <a href="listProject.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i>  Project List</a>
    <a href="listTask.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-server fa-fw"></i>  Task List</a>
    <a href="LogoutServlet" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h1><b>Add Project</b></h1>
  </header>

  <div class="w3-panel w3-row-padding w3-container w3-half" style="margin:0 -16px">
    <head>
        <style> 
            form {
                border: 3px solid #f1f1f1;
            }
            input{
                border-radius: 8px;
            }
            select{
                border-radius: 8px;
            }
            /* Full-width inputs */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            /* Set a style for all buttons */
            button {
                background-color: #0086FF;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            /* Add a hover effect for buttons */
            button:hover {
                opacity: 0.8;
            }

            /* Extra style for the cancel button (red) */
            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            /* Center the avatar image inside this container */
            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
            }

            /* Avatar image */
            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            /* Add padding to containers */
            .container {
                padding: 16px;
            }

            /* The "Forgot password" text */
            span.psw {
                float: right;
                padding-top: 16px;
            }   

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
            }
            *{box-sizing: border-box;}

            /* Button used to open the contact form - fixed at the bottom of the page */
            .open-button {
              background-color: #0086FF;
              color: white;
              padding: 12px 20px;
              border: none;
              cursor: pointer;
              width: 170px;
              border-radius: 8px;
            }

            /* The popup form - hidden by default */
            .form-popup {
              display: none;
              position: fixed;
              bottom: 0;
              right: 15px;
              border: 3px solid #f1f1f1;
              z-index: 9;
            }

            /* Add styles to the form container */
            .form-container {
              max-width: 300px;
              padding: 10px;
              background-color: white;
            }

            /* Full-width input fields */
            .form-container input[type=text], .form-container input[type=password] {
              width: 100%;
              padding: 15px;
              margin: 5px 0 22px 0;
              border: none;
              background: #f1f1f1;
            }

            /* When the inputs get focus, do something */
            .form-container input[type=text]:focus, .form-container input[type=password]:focus {
              background-color: #ddd;
              outline: none;
            }

            /* Set a style for the submit/login button */
            .form-container .btn {
              background-color: #0086FF;
              color: white;
              padding: 16px 20px;
              border: none;
              cursor: pointer;
              width: 100%;
              margin-bottom:10px;
              opacity: 0.8;
            }

            /* Add a red background color to the cancel button */
            .form-container .cancel {
              background-color: red;
            }

            /* Add some hover effects to buttons */
            .btn{
                background-color: #0086FF;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 18px;
                cursor: pointer;
            }
            .form-container .btn:hover, .open-button:hover {
              opacity: 1;
            }
            
            input[type=submit] {
                background-color: #0086FF;
                color: white;
                padding: 8px 18px;
                border: none;
                border-radius: 18px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                opacity: 0.8;
            }

            input[type=reset] {
                background-color: #DC143C;
                color: white;
                padding: 8px 18px;
                border: none;
                border-radius: 18px;
                cursor: pointer;
            }

            input[type=reset]:hover {
                background-color: #B22222;
            }
        </style>
        
<div class="container">
    <form action="AddprojectServlet" method="POST" enctype="multipart/form-data">
        
        <label for="projectName"><b>Title </b></label>
        <input type="text" placeholder="Enter project" name="projectName" required>
        <p></p>
        <label for="cName"><b>Select Client</b></label>
        <select class="w3-select" name="cName" id="cName">

                <%
                    clientDB clientDB=new clientDB();
                    ArrayList<client> clientList = (ArrayList<client>)clientDB.selectClient();

                for(int i=0;i<clientList.size();i++){

                client temp= (client) clientList.get(i);
                temp.toString();
                %>

                    <option value="<%=temp.getClientName()%>"><%=temp.getClientName()%></option>
                    <%
                }
                %>
        </select>
        <br>
        <a class="open-button w3-bar-item w3-button w3-padding" onclick="openFormClient()">Add New Client</a>
        <p></p>
        <label for="cName"><b>Select Supplier</b></label>
        <select class="w3-select" name="sName" id="cName">

                <%
                    supplierDB supplierDB=new supplierDB();
                    ArrayList<supplier> supplierList = (ArrayList<supplier>) supplierDB.selectSupplier();

                for(int i=0;i<supplierList.size();i++){

                supplier temp= (supplier) supplierList.get(i);
                temp.toString();
                %>

                    <option value="<%=temp.getSupName()%>"><%=temp.getSupName()%></option>
                    <%
                }
                %>
        </select>
        <br>
        <a class="open-button w3-bar-item w3-button w3-padding" onclick="openFormSupplier()">Add New Supplier</a>
        <br>
        <p></p>
        <label for="address"><b>Project Address</b></label>
        <input type="text" placeholder="Enter Project Address" name="address" style="height:90px" required>
        <p></p>
        <label for="start date"><b>Start Date</b></label>
        <input class="w3-input" type="date" placeholder="Start date" name="startDate" required><br>
        <label for="est end date"><b>Estimated end date</b></label>
        <input class="w3-input" type="date" placeholder="Estimated end date" name="estEndDate" required><br>
        <label for="quo file"><b>Quatation file</b></label>
        <input class="w3-input" type="file" name="qFile" required>
        <p></p>
        <input type="submit" value="Add Project"></input>
        <input type="reset" value="Reset"></input></td>
    </form>         
        
        <div class="form-popup" id="myForm-client">
               <form action="ClientController" method="post" class="form-container">
                 <h2>Add New Client</h2>
                 

                 <label for="cName"><b>Client Name</b></label>
                <input type="text" placeholder="Enter name" name="cName" required>

                <label for="cContact"><b>Client Contact</b></label>
                <input type="text" placeholder="Enter contact" name="cContact" required>

                <label for="adress"><b>Client Address</b></label>
                <input type="text" placeholder="Enter address" name="cAddress" required>

                 <button type="submit" class="btn">Add New Client</button>
                 <button type="reset" class="btn cancel" onclick="closeFormClient()">Close</button>
               </form>
        </div> 
    
        <div class="form-popup" id="myForm-supplier">
            <form action="SupplierController" method="post" class="form-container">
                     <h2>Add New Supplier</h2>
                     <label for="cName"><b>Supplier Name</b></label>
                    <input type="text" placeholder="Enter name" name="sName" required>

                    <label for="cContact"><b>Supplier Contact</b></label>
                    <input type="text" placeholder="Enter contact" name="sContact" required>

                    <label for="adress"><b>Supplier Address</b></label>
                    <input type="text" placeholder="Enter address" name="sAddress" required>

                     <button type="submit" class="btn">Add New Supplier</button>
                     <button type="reset" class="btn cancel" onclick="closeFormSupplier()">Close</button>
                   </form>
            </div> 
        </div>
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
function close_exist() {
     exist_old.style.display = "none";

}
// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}

function openFormClient() {
  document.getElementById("myForm-supplier").style.display = "none";
  document.getElementById("myForm-client").style.display = "block";
}

function closeFormClient() {
  document.getElementById("myForm-client").style.display = "none";
} 

function openFormSupplier() {
  document.getElementById("myForm-client").style.display = "none";
  document.getElementById("myForm-supplier").style.display = "block";
}

function closeFormSupplier() {
  document.getElementById("myForm-supplier").style.display = "none";
}
</script>

</body>
</html>
