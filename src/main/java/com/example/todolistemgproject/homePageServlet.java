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

@WebServlet(name = "homePageServlet", value = "/homePageServlet")
public class homePageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int tokenvalue = Integer.parseInt(request.getParameter("variableName"));
        request.setAttribute("token", tokenvalue);
        String newClassValue = "completed";
        request.setAttribute("classValue", newClassValue);
        taskDisplay td = new taskDisplay();
        td.connecting();
        List<task> tsk = new ArrayList();
        tsk = td.recuperdept(tokenvalue);
        request.setAttribute("tasks", tsk);

        this.getServletContext().getRequestDispatcher("/homePage.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int tokenvalue = Integer.parseInt(request.getParameter("variableName"));
task tsk=new task();
tsk.setDesc_task(request.getParameter("newTask"));
taskDisplay x =new taskDisplay();
x.connecting();
x.ajoutertask(tsk,tokenvalue);//ajouter l object li fih had attribute f bdd
doGet(request,response);
    }


}
