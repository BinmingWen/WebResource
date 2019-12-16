package cn.wyu.Controller.Login;

import cn.wyu.Domain.Users;
import cn.wyu.Service.UserService;
import cn.wyu.ServiceImple.UserServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String no = request.getParameter("no");
        String password = request.getParameter("password");
        String classname = request.getParameter("className");
        int isStu = Integer.parseInt(request.getParameter("isStu"));

        Users user = new Users();
        user.setUserName(name);
        user.setPassword(password);
        user.setUserNo(no);
        user.setIsStu(isStu);
        user.setClassName(classname);
        UserService userService = new UserServiceImple();
        boolean result = userService.add(user);
        response.setContentType("text/html;charset=UTF-8");

        if(result) {
            //注册成功
            request.getRequestDispatcher("/pages/login/success.jsp").forward(request,response);
        }else {
            //用户已存在，注册失败
            response.getWriter().print("<script language='javascript'>alert('该学号/教师编号已存在！');window.location.href='login.jsp';</script>");
        }
        //注册失败，重新注册。
        request.getRequestDispatcher("/pages/login/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
