package cn.wyu.Controller.Admin.Post;

import cn.wyu.Service.PostService;
import cn.wyu.ServiceImple.PostServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostDeleteServlet",urlPatterns = {"/PostDeleteServlet"})
public class PostDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = new Integer(request.getParameter("postId"));
        PostService postService = new PostServiceImple();
        if(postService.isDelete(postId)){
            request.getRequestDispatcher("/PostsServlet").forward(request,response);
        }else{

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
