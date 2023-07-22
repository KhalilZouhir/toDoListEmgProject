package com.example.todolistemgproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "memberPageServlet", value = "/memberPageServlet")
public class memberPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int tokenvalue = Integer.parseInt(request.getParameter("tokenthird"));
        int membrid =  Integer.parseInt(request.getParameter("mmbrid"));

        System.out.println("waaaaaaaaaaaaa"+membrid);
        System.out.println("waaaaaaaaaaaaa"+tokenvalue);
        request.setAttribute("token", tokenvalue);
        taskDisplay td =new taskDisplay();
        td.connecting();
        List<task> tsk = new ArrayList();
       tsk= td.displaytaskofmember(membrid);
        request.setAttribute("tasks",tsk);
        this.getServletContext().getRequestDispatcher("/memberPage.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}
