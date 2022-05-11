/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

import com.employee.employee;
import com.employee.employeeDB;
import com.notification.message;
import com.notification.messageDB;
import com.task.task;
import com.task.taskDB;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
public class AddprojectServlet extends HttpServlet {

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
            out.println("<title>Servlet AddprojectServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddprojectServlet at " + request.getContextPath() + "</h1>");
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
        
        //declare each DAO 
        clientDB ClientDB = new clientDB();
        supplierDB SuppDB = new supplierDB();
        projectDB ProDB = new projectDB();
        taskDB TaskDB = new taskDB();
        
        HttpSession session = request.getSession();
        employee Employee = (employee)session.getAttribute("emp");
        
        //gets values from jsp
        String title = request.getParameter("projectName");
        String client = request.getParameter("cName");
        String supplier = request.getParameter("sName");
        String ProAddress = request.getParameter("address");
        String startDate = request.getParameter("startDate");
        String EstEndDate = request.getParameter("estEndDate");
        
        int clieID = ClientDB.getClientID(client);
        int SupID = SuppDB.getSuppID(supplier);
        InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("qFile");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            System.out.println(filePart.getSubmittedFileName());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        String image = filePart.getSubmittedFileName();
        
        //declare java class
        project Project = new project();
        task Task = new task();
        
        //setting the variable into java class
        Project.setTitle(title);
        Project.setAddress(ProAddress);
        Project.setStartDate(startDate);
        Project.setEstEndDate(EstEndDate);
        Project.setClientID(clieID);
        Project.setSupplierID(SupID);
        Project.setQuotFile(image);
        Project.setStatus(0);
        Project.setWarranty(java.time.LocalDate.now().plusDays(5).toString());
        String addProject = ProDB.addProject(Project);
        
        
        int ID = ProDB.selectLatestProj();
        Task.setType(1);
        Task.setStartDate(java.time.LocalDate.now().toString());
        Task.setDueDate(java.time.LocalDate.now().plusDays(2).toString());
        Task.setIsComplete(false);
        Task.setLateTask(false);
        Task.setDepid(4);
        Task.setProjectID(ID);
        Task.setRemarks(" ");
        
        String addTask = TaskDB.addTask(Task); 
        
        //Message
        messageDB SMSdb = new messageDB();
        message SMS = new message();

        SMS.setTitle(TaskDB.getTaskName(Task.getType()));
        SMS.setRemarks(Task.getRemarks());
        SMS.setCreateDate(Task.getDueDate());
        SMS.setEmpFrom(Employee.getId());
        SMS.setEmpTo(4);
        SMS.setType("Task");
        SMS.setIsComplete(false);

        String addSMS = SMSdb.addMessage(SMS);
        
        if(addTask.equals("SUCCESS") && addProject.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
            {
                
                request.getRequestDispatcher("/home.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
            }
            else
            {
                request.setAttribute("errMessage", addProject); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
                request.getRequestDispatcher("/addProject.jsp").forward(request, response);//forwarding the request
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
