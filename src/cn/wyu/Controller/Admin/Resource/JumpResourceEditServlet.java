package cn.wyu.Controller.Admin.Resource;

import cn.wyu.Dao.ResourceDao;
import cn.wyu.DaoImple.ResourceImple;
import cn.wyu.Domain.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JumpResourceEditServlet",urlPatterns = {"/JumpResourceEditServlet"})
public class JumpResourceEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int resourceId = new Integer(request.getParameter("resourceId"));
        ResourceDao resourceDao = new ResourceImple();
        Resource resource = resourceDao.queryById(resourceId);
        request.setAttribute("resource",resource);
        request.getRequestDispatcher("/pages/Administrator/resource/editResource.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
