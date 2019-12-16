package cn.wyu.Controller.Filedownload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ListFileServlet",urlPatterns = {"/ListFileServlet"})
public class ListFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取上传文件的目录
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<>();
        //递归遍历fileNameMap目录下的所有文件和目录，并存放在map集合中
        listfile(new File(uploadFilePath),fileNameMap);

        request.setAttribute("fileNameMap",fileNameMap);
        /*String currentPageStr = request.getParameter("currentPage");
        Integer currentPage = 1;
        if(currentPageStr!=null&&currentPageStr.trim()!="") {
            currentPage = new Integer(currentPageStr);
        }
        ResourceDao resourceDao = new ResourceImple();
        PageInfo pageinfo = resourceDao.queryByAll(currentPage);
        pageinfo.setFileNameMap(fileNameMap);
        request.setAttribute("pageinfo",pageinfo);
        List<?> list = pageinfo.getList();
        System.out.println(list.size());*/
        request.getRequestDispatcher("/pages/download/listfile.jsp").forward(request,response);
    }

    private void listfile(File file, Map<String, String> fileNameMap) {
        //如果file代表的不是一个文件，而是一个目录
        if(!file.isFile()) {
            //列出该目录下的所有文件和目录
            File files[] = file.listFiles();
            for(File f:files) {
                //递归
                listfile(f,fileNameMap);
            }
        }else{
            //获取文件名称，并去掉哈希值。
            String realName = file.getName().substring(file.getName().indexOf("_")+1);
            //当前文件为key,哈希值的文件为value
            fileNameMap.put(file.getName(),realName);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
