package cn.wyu.Controller.Filedownload;

import cn.wyu.Dao.ResourceDao;
import cn.wyu.DaoImple.ResourceImple;
import cn.wyu.bean.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DownloadResourceServlet",urlPatterns = {"/DownloadResourceServlet"})
public class DownloadResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPageStr = request.getParameter("currentPage");
        Integer currentPage = 1;
        if(currentPageStr!=null&&currentPageStr.trim()!="") {
            currentPage = new Integer(currentPageStr);
        }
        ResourceDao resourceDao = new ResourceImple();
        PageInfo pageInfo = resourceDao.queryByAll(currentPage);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/pages/download/downloadList.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
