/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task;

import com.employee.employee;
import com.notification.message;
import com.notification.messageDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aidie
 */
public class AddTaskServlet extends HttpServlet {

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
            out.println("<title>Servlet AddTaskServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddTaskServlet at " + request.getContextPath() + "</h1>");
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
        
        HttpSession session = request.getSession();
        employee Employee = (employee)session.getAttribute("emp");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List errorMsgs = new LinkedList();
        
        //retrieve employee id 
        int empID = Employee.getId();
            
            //Retrive form parameters
            
            String name = request.getParameter("tasktype");
            String department = request.getParameter("department");
            String remarks = request.getParameter("taskRemarks");
            String proID = request.getParameter("Project");
            
            //Business logic
            taskDB TaskDB = new taskDB();
            task Task = new task();
            
            Task.setStartDate(java.time.LocalDate.now().toString());
            Task.setDueDate(java.time.LocalDate.now().plusDays(2).toString());
            Task.setIsComplete(false);
            Task.setLateTask(false);
            Task.setProjectID(Integer.parseInt(proID));
            Task.setRemarks(remarks);
            Task.setType(Integer.parseInt(name));
            Task.setDepid(Integer.parseInt(department));
            
            String nextTask = TaskDB.addTask(Task);
            
            //Message
            messageDB SMSdb = new messageDB();
            message SMS = new message();

            SMS.setTitle(TaskDB.getTaskName(Integer.parseInt(name)));
            SMS.setRemarks(Task.getRemarks());
            SMS.setCreateDate(Task.getDueDate());
            SMS.setEmpFrom(empID);
            SMS.setEmpTo(Integer.parseInt(department));
            SMS.setType("Task");

            String addSMS = SMSdb.addMessage(SMS);
            
            if(nextTask.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
            {
                request.getRequestDispatcher("/listTask.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
            }
            else
            {
                request.setAttribute("errMessage", nextTask); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
                request.getRequestDispatcher("/home.jsp").forward(request, response);//forwarding the request
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
