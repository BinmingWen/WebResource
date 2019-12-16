package cn.wyu.Controller.Admin.Users;

import cn.wyu.Dao.UsersDao;
import cn.wyu.DaoImple.UsersImple;
import cn.wyu.Service.UserService;
import cn.wyu.ServiceImple.UserServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDeleteServlet",urlPatterns = {"/UserDeleteServlet"})
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = new Integer(request.getParameter("userId"));
        UserService userService = new UserServiceImple();

        if(userService.userDelete(id)) {
            request.getRequestDispatcher("/UsersListServlet").forward(request,response);
        }
        else {
            request.getRequestDispatcher("").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
