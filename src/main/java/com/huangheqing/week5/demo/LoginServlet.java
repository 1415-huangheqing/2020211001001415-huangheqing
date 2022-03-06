package com.huangheqing.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException{
        super.init();
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection -->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from usertable where username='smkxmsk   ' and password =123456");
            if("sa".equals(username)&&"huangheqing".equals(password))
            {   PrintWriter writer =response.getWriter();
                writer.println("Login successful");
                writer.println("Welcome   "+username);
            }
            else
            {   PrintWriter writer =response.getWriter();

                writer.println("Username or password Error");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }

}