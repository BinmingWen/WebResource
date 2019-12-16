package cn.wyu.Controller.Admin.Users;

import cn.wyu.Dao.UsersDao;
import cn.wyu.DaoImple.UsersImple;
import cn.wyu.Service.UserService;
import cn.wyu.ServiceImple.UserServiceImple;
import cn.wyu.bean.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersListServlet",urlPatterns = {"/UsersListServlet"})
public class UsersListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPageStr = request.getParameter("currentPage");
        Integer currentPage = 1;
        if(currentPageStr!=null&&currentPageStr.trim()!="") {
            currentPage = new Integer(currentPageStr);
        }
        UsersDao usersDao = new UsersImple();
        PageInfo pageInfo = usersDao.queryByCurrent(currentPage);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/pages/Administrator/user/allUser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
