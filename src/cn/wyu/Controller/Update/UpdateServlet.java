package cn.wyu.Controller.Update;

import cn.wyu.Service.UserService;
import cn.wyu.ServiceImple.UserServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no = request.getParameter("userNo");
        String name = request.getParameter("userName");
        String classname = request.getParameter("className");
        int id= new Integer(request.getParameter("userId"));

        UserService userService = new UserServiceImple();
        if(userService.userUpdate(no,name,classname,id)){
            request.getRequestDispatcher("/pages/users/user.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/pages/users/updateUser.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
