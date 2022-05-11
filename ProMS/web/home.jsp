<%@page import="com.notification.messageDB"%>
<%@page import="com.notification.message"%>
<%@page import="com.employee.employeeDB"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.task.taskDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.task.task"%>
<%@page import="com.employee.employee"%>
<!DOCTYPE html>
<html>
<title>MKR Hartamas Home</title>
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
              background-color: #04AA6D;
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
                background-color: #04AA6D;
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
                background-color: #04AA6D;
                color: white;
                padding: 8px 18px;
                border: none;
                border-radius: 18px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                background-color: #45a049;
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
    <a href="home.jsp" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-home fa-fw"></i>  Home</a>
    <%if(Employee.getDepname().equals("Sales")){%>
    <a href="addProject.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  Add project</a><%}%>
    <a href="listProject.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sort-amount-asc fa-fw"></i>  Project List</a>
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
    <h1><b>Home</b></h1>
  </header>

  <div class="w3-row-padding w3-margin-bottom">
    <div class="w3-quarter">
      <div class="w3-container w3-red w3-padding-16">
        <div class="w3-left"><i class="fa fa-bell w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>52</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>Task</h4>
      </div>
    </div>
    <div class="w3-quarter">
      <div class="w3-container w3-blue w3-padding-16">
        <div class="w3-left"><i class="fa fa-laptop  w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>22</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>Project</h4>
      </div>
    </div>
    <div class="w3-quarter">
      <div class="w3-container w3-teal w3-padding-16">
        <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>4</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>Department</h4>
      </div>
    </div>
    <div class="w3-quarter">
      <div class="w3-container w3-orange w3-text-white w3-padding-16">
        <div class="w3-left"><i class="fa fa-user w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>40</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>Employee</h4>
      </div>
    </div>
  </div>

  <%
      ArrayList<task> taskList = new ArrayList<task>();
      ArrayList<message> messageList = new ArrayList<message>();
      taskDB TaskDB = new taskDB();
      messageDB MessageDB = new messageDB();
      
      messageList = MessageDB.selectMessageEmployee(Employee);
      taskList = TaskDB.selectTaskDepartment(Employee.getDepID());
  %>
  
  <div class="w3-panel">
    <div class="w3-row-padding" style="margin:0 -16px">
      <div class="w3-twothird">
          <a class="open-button w3-bar-item w3-button w3-padding" onclick="openForm()">Send Message</a>
          <p></p>
          <h4><b>Feeds</b></h4>
          <div style="overflow-y: auto;height: 250px">
        <table class="w3-table w3-striped w3-white">
                <%
                    messageDB SMSDB = new messageDB();
                 int j = 0;
                while(j<messageList.size()){
                
                message temp= (message) messageList.get(j);
                System.out.print("Hi" + temp.toString());
                if(temp.getType().equals("Task")){
            %>
                     <tr>
                        <td><i class="fa fa-bell w3-text-red w3-large"></i></td>
                        <td>New Task: <%=temp.getTitle()%></td>
                        <%if(temp.isIsComplete()== false){%>
                        <td  style="color: red"><i>Due Date: <%=temp.getCreateDate()%></i></td><%}
                        else {%><td  style="color: green"><i>Done</i></td><%}%>
                        <%temp.setIsComplete(true);
                        SMSDB.updateMessage(temp);
                        System.out.print(temp.isIsComplete());%>
                     </tr>
                    <%} else if(temp.getType().equals("Message")){
            %>
                     <tr>
                        <td><i class="fa fa-envelope w3-text-blue w3-large"></i></td>
                        <td><b><%=temp.getTitle()%></b>: <%=temp.getRemarks()%></td>
                        <td  style="color: green"><i>Date: <%=temp.getCreateDate()%></i></td>
                     </tr>
                    <%}
                j++;} 
                %>
        </table>
          </div>
      </div>
    </div>
  </div>
  <hr>
  <div class="w3-container">
      <h4><b>Employee of The Month</b></h4>
    <ul class="w3-ul w3-card-4 w3-white">
      <li class="w3-padding-16">
        <img src="Image/faiz.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
        <span class="w3-xlarge">Muhammad Amirul Faiz Bin Mohamed Nordin</span><br>
      </li>
      <li class="w3-padding-16">
        <img src="Image/imman.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
        <span class="w3-xlarge">Imman Zuhairy Bin Ramlee</span><br>
      </li>
      <li class="w3-padding-16">
        <img src="Image/aidil.jpeg" class="w3-left w3-circle w3-margin-right" style="width:35px">
        <span class="w3-xlarge">Ahmad Aidiel Firdaus Bin Ahmad Tarmizie</span><br>
      </li>
    </ul>
  </div>
  <hr>
  <div class="w3-container">
    <h4><b>Department Stats</b></h4>
    <p></p>
    <p>Administration</p>
    <div class="w3-grey">
      <div class="w3-container w3-center w3-padding w3-green" style="width:75%">75%</div>
    </div>

    <p>Maintenance</p>
    <div class="w3-grey">
      <div class="w3-container w3-center w3-padding w3-orange" style="width:60%">60%</div>
    </div>

    <p>Sale</p>
    <div class="w3-grey">
      <div class="w3-container w3-center w3-padding w3-red" style="width:50%">50%</div>
    </div>
    
    <p>Finance</p>
    <div class="w3-grey">
      <div class="w3-container w3-center w3-padding w3-red" style="width:25%">25%</div>
    </div>
  </div>
  <p></p>
  <br>
  <hr>
  <footer class="w3-container w3-padding-16">
    <p>&#169; 2015 MKR HARTAMAS SDN BHD (1168188)</p>
    <p>e: hello@mkrhartamas.com</p>
    <p>t: +603-26157917</p>
</footer>
  
  <div class="form-popup" id="myForm">
              <form action="MessageServlet" method="post" class="form-container">
                    <h2>Send Message</h2>

                    <label for="title"><b>Title</b></label>
                     <input type="text" placeholder="Enter title" name="title" required>
                     
                     <b>Message:</b><br>
                     <textarea id="taskRemarks" name="taskRemarks" placeholder="Write Message" style="width:100%;height:100px"></textarea>
                     
                     <label for="emp">Send To:</label>
                     <input class="w3-select" list="employee" name="emp" id="emp" placeholder="Enter employee name/id">
                     <datalist id="employee">
                         <%
                         ArrayList<employee> empList = new ArrayList<employee>();
                         employeeDB empDB=new employeeDB();
                         
                         empList=empDB.selectEmp();
                         
                         for(int k=0;k<empList.size();k++){
                         
                         employee emp= (employee) empList.get(k);%>
                         <option value="<%=emp.getId()%>"><%=emp.getName()%></option><%}%>
                     </datalist>
                      <br>
                    <button type="submit" class="btn">Add New Message</button>
                    <button type="reset" class="btn cancel" onclick="closeForm()">Close</button>
                  </form>
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

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}

function openForm() {

  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>

</body>
</html>
