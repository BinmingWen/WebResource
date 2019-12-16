package cn.wyu.Controller.Admin.Resource;

import cn.wyu.Service.ResourceService;
import cn.wyu.ServiceImple.ResourceServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResourceDeleteServlet",urlPatterns = {"/ResourceDeleteServlet"})
public class ResourceDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int resourceId = new Integer(request.getParameter("resourceId"));
        ResourceService resourceService = new ResourceServiceImple();
        if(resourceService.isDelete(resourceId)){
            request.getRequestDispatcher("/ResourceListServlet").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
