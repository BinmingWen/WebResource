package cn.wyu.Controller.Users;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdatePwsServlet", urlPatterns = {"/UpdatePwsServlet"})
public class UpdatePwsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newPassword = request.getParameter("newkey");
        int id = new Integer(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        Users user = new Users();
        user.setUserId(id);
        user.setPassword(newPassword);
        user.setUserName(userName);
        UserService userService = new UserServiceImple();
        request.removeAttribute("user");
        if (userService.updatePassword(user)) {
            UsersDao usersDao = new UsersImple();
            user = usersDao.queryById(id);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("/pages/users/user.jsp").forward(request, response);


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
