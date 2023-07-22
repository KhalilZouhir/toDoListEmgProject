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
@WebServlet(name = "updatingServlet", value = "/updatingServlet")
public class updatingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int token = Integer.parseInt(request.getParameter("variableName"));
        int statetochange = Integer.parseInt(request.getParameter("statetochange"));
         int idstatetochange = Integer.parseInt(request.getParameter("idstatetochange"));
        taskDisplay td =new taskDisplay();
        td.connecting();
        td.updatestate(statetochange,idstatetochange);
        request.setAttribute("variableName", token);
        response.sendRedirect("homePageServlet?variableName=" + token);

    }
}
