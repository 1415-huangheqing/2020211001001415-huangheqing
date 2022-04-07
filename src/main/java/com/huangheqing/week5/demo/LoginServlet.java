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
        con=(Connection)getServletContext().getAttribute("com");

        }
        @Override
      protected void  doGet(HttpServletRequest request HttpServletResponse response)throws ServletException{
        doPost( request,response);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String usename=request.getParameter("username");
        String password=request.getParameter("password");
        String sql="select username,password,email,gender,birthday from usertable where usename='sa'"
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            if(rs.next())
            {
                out.println("login Successful!!!");
                out.println("welcome"+usename);
                // PrintWriter writer =response.getWriter();
                //writer.println("Login successful");
                //writer.println("Welcome   "+username);
            }
            else
            {
                out.println("Username or password Error");
                //PrintWriter writer =response.getWriter();

                //writer.println("Username or password Error");
            }
        }
        catch (SQLException  throwables) {
            throwables.printStackTrace();
        }
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }

}