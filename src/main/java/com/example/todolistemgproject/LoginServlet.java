package com.example.todolistemgproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private String message;
public static int token;
    public void init() {
        message = "we r testing login";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        connectionLogin cn=new connectionLogin();
        cn.deco();
        String red ="notvisible";
        request.setAttribute("red", red);
        this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
user user = new user();
user.setName_user(request.getParameter("name_user"));
user.setMdp_user(request.getParameter("mdp_user"));
connectionLogin cn =new connectionLogin();
        cn.connecting();
        boolean test ;



    test=cn.authentification(user);

        String red="notvisible";

if(test){

    try {
        token  = cn.token(user);
        System.out.println(token);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    request.setAttribute("red", red);
    request.setAttribute("variableName", token);
    response.sendRedirect("homePageServlet?variableName=" + token);




}
else{  red="visible";
    request.setAttribute("red", red);
    this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
}
    }

    public void destroy() {
    }
}
