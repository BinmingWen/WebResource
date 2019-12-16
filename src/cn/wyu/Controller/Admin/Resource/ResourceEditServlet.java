package cn.wyu.Controller.Admin.Resource;

import cn.wyu.Domain.Resource;
import cn.wyu.Service.ResourceService;
import cn.wyu.ServiceImple.ResourceServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResourceEditServlet",urlPatterns = {"/ResourceEditServlet"})
public class ResourceEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int resourceId = new Integer(request.getParameter("resourceId"));
        String uploaderName = request.getParameter("uploaderName");
        String name = request.getParameter("name");
        String descn = request.getParameter("descn");
        String type = request.getParameter("type");
        String fileName = request.getParameter("fileName");
        Resource resource = new Resource();
        resource.setResourceId(resourceId);
        resource.setName(name);
        resource.setFileName(fileName);
        resource.setType(type);
        resource.setDescn(descn);
        resource.setUploaderName(uploaderName);
        ResourceService resourceService = new ResourceServiceImple();
        if(resourceService.isUpdate(resource)){
            request.getRequestDispatcher("/ResourceListServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
