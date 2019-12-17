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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "PostServlet",urlPatterns = {"/PostServlet"})
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        //获取当前时间
        LocalDateTime ld = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = df.format(ld);
        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");
        Posts post = new Posts();
        post.setContent(message);
        post.setName(user.getUserName());
        post.setIsExcellent(0);
        post.setIsWorld(0);
        post.setPostDate(dateTime);
        PostService postService = new PostServiceImple();
        if(postService.isInsert(post)){

            request.getRequestDispatcher("/PostListServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
