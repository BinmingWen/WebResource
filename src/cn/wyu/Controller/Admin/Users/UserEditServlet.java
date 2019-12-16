package cn.wyu.Controller.Admin.Users;

import cn.wyu.Dao.UsersDao;
import cn.wyu.DaoImple.UsersImple;
import cn.wyu.Domain.Users;
import cn.wyu.Service.UserService;
import cn.wyu.ServiceImple.UserServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserEditServlet",urlPatterns = {"/UserEditServlet"})
public class UserEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int userId = new Integer(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String className = request.getParameter("className");
        String isStuStr = request.getParameter("isStu");
        String userNo = request.getParameter("userNo");
        int isStu = 0;
        if(isStuStr.equals("老师")){
            isStu = 1;
        }
        else if(isStuStr.equals("学生")){
            isStu = 0;
        }
        Users user = new Users(userId,isStu,0,userName,userNo,password,className);
        UserService userService = new UserServiceImple();
        if(userService.userEdit(user)){
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
