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
@WebServlet(name = "membersServlet", value = "/membersServlet")
public class membersServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int tokenvalue = Integer.parseInt(request.getParameter("tokenscnd"));
        request.setAttribute("token", tokenvalue);

     connectionLogin cl=new connectionLogin();
     cl.connecting();
     List<user>members=new ArrayList();
        members=cl.recupermembers(tokenvalue);
        request.setAttribute("members",members);

        this.getServletContext().getRequestDispatcher("/members.jsp").forward(request,response);
    }

}
