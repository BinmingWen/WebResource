package cn.wyu.Controller.Admin.Post;

import cn.wyu.Dao.PostsDao;
import cn.wyu.DaoImple.PostsImple;
import cn.wyu.bean.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostsServlet",urlPatterns = {"/PostsServlet"})
public class PostsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPageStr = request.getParameter("currentPage");
    Integer currentPage = 1;
        if(currentPageStr!=null&&currentPageStr.trim()!="") {
        currentPage = new Integer(currentPageStr);
    }
    PostsDao postsDao = new PostsImple();
    PageInfo pageInfo = postsDao.queryByCurPage(currentPage);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/pages/Administrator/Post/PostList.jsp").forward(request,response);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
