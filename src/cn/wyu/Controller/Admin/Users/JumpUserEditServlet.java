package cn.wyu.Controller.Admin.Users;

import cn.wyu.Dao.UsersDao;
import cn.wyu.DaoImple.UsersImple;
import cn.wyu.Domain.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JumpUserEditServlet",urlPatterns = {"/JumpUserEditServlet"})
public class JumpUserEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = new Integer(request.getParameter("id"));
        String isStu = null;
        UsersDao usersDao = new UsersImple();
        Users user = usersDao.queryById(id);
        request.setAttribute("user",user);
        if(user.getIsStu()==0) {
            isStu = "学生";
            request.setAttribute("isStu",isStu);
        }
        else if(user.getIsStu()==1){
            isStu = "老师";
            request.setAttribute("isStu",isStu);
        }
        request.getRequestDispatcher("/pages/Administrator/user/editUser.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
