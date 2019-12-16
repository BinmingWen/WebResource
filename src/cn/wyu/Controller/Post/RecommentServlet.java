package cn.wyu.Controller.Post;

import cn.wyu.Domain.Comment;
import cn.wyu.Service.CommentService;
import cn.wyu.ServiceImple.ComentServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RecommentServlet",urlPatterns = {"/RecommentServlet"})
public class RecommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String recomm = request.getParameter("recomm");
        int postId = new Integer(request.getParameter("postId"));
        Comment comment = new Comment();
        comment.setComContent(recomm);
        comment.setCom_postId(postId);
        CommentService commentService = new ComentServiceImple();
        if(commentService.isInsert(comment)) {
            request.getRequestDispatcher("/PostListServlet").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
