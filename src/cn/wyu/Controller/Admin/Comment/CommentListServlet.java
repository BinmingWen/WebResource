package cn.wyu.Controller.Admin.Comment;

import cn.wyu.Dao.CommentDao;
import cn.wyu.Dao.PostsDao;
import cn.wyu.Dao.ResourceDao;
import cn.wyu.DaoImple.CommentImple;
import cn.wyu.DaoImple.PostsImple;
import cn.wyu.DaoImple.ResourceImple;
import cn.wyu.bean.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CommentListServlet",urlPatterns = {"/CommentListServlet"})
public class CommentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
