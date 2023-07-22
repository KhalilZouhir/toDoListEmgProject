package com.example.todolistemgproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deleteTaskServlet", value = "/deleteTaskServlet")
public class deleteTaskServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int token = Integer.parseInt(request.getParameter("variableName"));
        int idTask = Integer.parseInt(request.getParameter("idTask"));
        taskDisplay ts=new taskDisplay();
        ts.connecting();
        ts.deletetask(idTask);
        request.setAttribute("variableName", token);
        response.sendRedirect("homePageServlet?variableName=" + token);







    }



















}
