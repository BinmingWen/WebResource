package cn.wyu.Controller.Login;

import cn.wyu.Domain.Users;
import cn.wyu.Service.UserService;
import cn.wyu.ServiceImple.UserServiceImple;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("userName");
        String password = request.getParameter("userpwd");
        Users user = new Users();
        user.setUserName(username);
        user.setPassword(password);
        UserService userService = new UserServiceImple();
        Boolean flag = userService.login(user);
        //普通用户
        if( flag && user.getIsAdmin()==0){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("/pages/login/success.jsp").forward(request,response);
        }
        //管理员登陆
        else if(flag && user.getIsAdmin()==1){
            request.getRequestDispatcher("/pages/Administrator/index.jsp").forward(request,response);
        }
        //无法登陆
        else {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request,response);
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doPost(request,response);
    }
}
