package com.huangheqing.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name="JDBCDemoServlet",urlPatterns = {"/jdbc"},
        initParams = {
        @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value = "jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false"),
                @WebInitParam(name="username",value = "sa"),
                @WebInitParam(name="password",value = "huangheqing"),
        },
        loadOnStartup = 1
)

public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        //way 2
        //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//name= values
        //String url = "jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        //String username = "sa";
        //String password = "huangheqing";
        //there 4 variables should not in java code--- must be in web.xml as

         //STEP-1
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public  void  destroy(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}