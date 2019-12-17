package cn.wyu.Controller.Post;

import cn.wyu.Domain.Posts;
import cn.wyu.Domain.Users;
import cn.wyu.Service.PostService;
import cn.wyu.ServiceImple.PostServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PostEditServlet",urlPatterns = {"/PostEditServlet"})
public class PostEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int postId = new Integer(request.getParameter("postId"));
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        String postDate = request.getParameter("postDate");
        String isExcellentStr = request.getParameter("isExcellent");
        int isExcellent = 0;
        if(isExcellentStr.equals("否")){
            isExcellent=0;
        }
        else{
            isExcellent=1;
        }
        Posts post = new Posts(postId,name,content,postDate,isExcellent,0);
        PostService postService = new PostServiceImple();
        if(postService.isUpdate(post)) {
            request.getRequestDispatcher("/PostsServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
