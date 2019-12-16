package cn.wyu.Controller.Filedownload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JumpDownLoadServlet",urlPatterns = {"/JumpDownLoadServlet"})
public class JumpDownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String filename = request.getParameter("filename");
        String fileName = request.getParameter("fileName");
        request.setAttribute("name",name);
        request.setAttribute("type",type);
        request.setAttribute("filename",filename);
        request.setAttribute("fileName",fileName);
        request.getRequestDispatcher("/pages/download/download.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
