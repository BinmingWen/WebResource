package cn.wyu.Controller.Admin.Post;

import cn.wyu.Dao.PostsDao;
import cn.wyu.Dao.ResourceDao;
import cn.wyu.DaoImple.PostsImple;
import cn.wyu.DaoImple.ResourceImple;
import cn.wyu.Domain.Posts;
import cn.wyu.Domain.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JumpPostUpdateServlet",urlPatterns = {"/JumpPostUpdateServlet"})
public class JumpPostUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = new Integer(request.getParameter("postId"));
        PostsDao postsDao = new PostsImple();
        Posts posts = postsDao.queryById(postId);
        request.setAttribute("posts",posts);
        request.getRequestDispatcher("/pages/Administrator/Post/editPost.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
