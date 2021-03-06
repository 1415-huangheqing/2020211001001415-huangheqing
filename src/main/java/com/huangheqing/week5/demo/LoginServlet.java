package com.huangheqing.week5.demo;

import com.huangheqing.dao.UserDao;
import com.huangheqing.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet<response> extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException{
        super.init();
        con=(Connection)getServletContext().getAttribute("com");

        }
        protected void  doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
           // doPost( request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

        }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao userDao=new UserDao();

        String sql="select username,password,email,gender,birthday from usertable where username='sa'";
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null&&rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);

                }
                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                  session.setAttribute("user",user);
                  request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username and Password Error!!!");
                request.getRequestDispatcher("WEB-INf/views/login.jsp").forward(request,response);
            }
//            ResultSet rs=con.createStatement().executeQuery(sql);
//            if(rs.next())
//            {
//                out.println("login Successful!!!");
//                out.println("welcome"+username);
//                // PrintWriter writer =response.getWriter();
//                //writer.println("Login successful");
//                //writer.println("Welcome   "+username);
//            }
//            else
//            {
//                out.println("Username or password Error");
//                //PrintWriter writer =response.getWriter();
//
//                //writer.println("Username or password Error");
//            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    }

