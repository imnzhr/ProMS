/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task;

import com.employee.employee;
import com.notification.message;
import com.notification.messageDB;
import com.project.project;
import com.project.projectDB;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author aidie
 */
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class TaskServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TaskServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TaskServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //declare java class
        task Task = new task();
        project Pro = new project(); 
        taskDB TaskDB = new taskDB();
        projectDB ProDB = new projectDB();
        
        
        
        HttpSession session = request.getSession();
        employee Employee = (employee)session.getAttribute("emp");
        
        String ID = request.getParameter("Taskid");
        String TypeID = request.getParameter("TTID");
        String proID = request.getParameter("proID");
        String DueDate = request.getParameter("DueDate");
        String DepID = request.getParameter("department");
        int DepartmentID=0;
        if(DepID.equals("Maintenance")){ DepartmentID = 1;}
        else if(DepID.equals("Sales")){ DepartmentID = 2;}
        else if(DepID.equals("Admin")){ DepartmentID = 3;}
        else if(DepID.equals("Finance")){ DepartmentID = 4;}
        
        LocalDate dueD = LocalDate.parse(DueDate); 
        
        
        Pro = ProDB.selectProject(Integer.parseInt(proID));
        
        //retrieve employee id 
        int empID = Employee.getId();
        
        //retrieve value status from form
        boolean stats = false;
        boolean lateTask = false;
        boolean ProStats = false;
        boolean ProLate = false;
        String status = request.getParameter("status");
        
        LocalDate CompDate = null;
        LocalDate EstEndD = LocalDate.parse(Pro.getEstEndDate());
        
        String addSMS = null;
        
        if(status.equals("Complete"))
        {
            stats = true;
            CompDate = java.time.LocalDate.now();
            if(CompDate.isAfter(dueD)){
                 lateTask = true;
            }
            Task.setCompletedDate(CompDate.toString());
            
            if(Integer.parseInt(TypeID) == 1){
                Pro.setStatus(20);
                Pro.setProgress(TaskDB.getTaskName(Integer.parseInt(TypeID)));
            }
            else if(Integer.parseInt(TypeID) == 2){
                Pro.setStatus(40);
                Pro.setProgress(TaskDB.getTaskName(Integer.parseInt(TypeID)));
            }
            else if(Integer.parseInt(TypeID) == 3){
                Pro.setStatus(60);
                Pro.setProgress(TaskDB.getTaskName(Integer.parseInt(TypeID)));
            }
            else if(Integer.parseInt(TypeID) == 4){
                Pro.setStatus(80);
                Pro.setProgress(TaskDB.getTaskName(Integer.parseInt(TypeID)));
            }
            else if(Integer.parseInt(TypeID) == 5){
                Pro.setStatus(100);
                Pro.setProgress(TaskDB.getTaskName(Integer.parseInt(TypeID)));
                Pro.setEndDate(CompDate.toString());
                ProStats = true;
                
                if(CompDate.isAfter(EstEndD)){
                 ProLate = true;
            }
            }
            
            
        if ((Integer.parseInt(TypeID) == 1)  || (Integer.parseInt(TypeID) == 4)){
        //Message
        messageDB SMSdb = new messageDB();
        message SMS = new message();
        
        SMS.setTitle(TaskDB.getTaskName(Integer.parseInt(TypeID)+1));
        SMS.setRemarks(Task.getRemarks());
        SMS.setCreateDate(DueDate);
        SMS.setEmpFrom(empID);
        SMS.setEmpTo(DepartmentID);
        SMS.setType("Task");
        SMS.setIsComplete(false);
        
        addSMS = SMSdb.addMessage(SMS);}
        }
        
        //retrieve value file from form
        InputStream file = null; // input stream of the upload file
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("uploadFile");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            System.out.println(filePart.getSubmittedFileName());
             
            // obtains input stream of the upload file
            file = filePart.getInputStream();
        }
        String fileName = filePart.getSubmittedFileName();
        
        //retrieve value remarks from form
        String remarks = request.getParameter("taskRemarks");
        
        
        //Setting variables into java class
        Task.setId(Integer.parseInt(ID));
        Task.setType(Integer.parseInt(TypeID));
        Task.setProjectID(Integer.parseInt(proID));
        Task.setEmpID(empID);
        Task.setIsComplete(stats);
        Task.setFile(fileName);
        Task.setRemarks(remarks);
        Task.setLateTask(lateTask);
        String updateTask = TaskDB.updateTask(Task); 
        
        
        Pro.setIsCOmplete(ProStats);
        Pro.setLateProject(ProLate);
        String updateProject = ProDB.updateProject(Pro);
        
        
        System.out.print(addSMS);
    if(updateTask.equals("SUCCESS") && updateProject.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
            {
                
                request.getRequestDispatcher("/listTask.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
            }
            else
            {
                request.setAttribute("errMessage", updateTask); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
                request.getRequestDispatcher("/updateTask.jsp").forward(request, response);//forwarding the request
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
