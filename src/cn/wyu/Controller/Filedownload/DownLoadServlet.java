package cn.wyu.Controller.Filedownload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownLoadServlet", urlPatterns = {"/DownLoadServlet"})
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到要下载的文件名
        String fileName = request.getParameter("filename");
        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
        //上传的文件都是保存在/WEB-INF/upload目录下的子目录中
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //通过文件名找出文件所在的目录
        String path = findFileSavePathByFileName(fileName, fileSaveRootPath);
        //得到要下载的文件
        File file = new File(path + "\\" + fileName);
        //若文件不存在
        if(!file.exists()) {
            request.setAttribute("message","你要下载的资源已被删除");
            request.getRequestDispatcher("/pages/download/message.jsp").forward(request,response);
            return;
        }
        //处理文件名
        String realname = fileName.substring(fileName.indexOf("_")+1);
        //设置响应头，控制游览器下载该文件
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(realname,"UTF-8"));
        //读取要下载的文件，保存到文件输入流中。
        FileInputStream in = new FileInputStream(path+"\\"+fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        while((len = in.read(buffer))>0) {
            //输出缓冲区的内容到游览器，实现文件下载
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    private String findFileSavePathByFileName(String fileName, String fileSaveRootPath) {
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashCode = fileName.hashCode();
        int dir1 = hashCode&0xf;
        int dir2 = (hashCode&0xf0)>>4;
        //构造新的保存目录
        String dir = fileSaveRootPath+"\\"+dir1+"\\"+dir2;
        File file = new File(dir);
        if(!file.exists()) {
            file.mkdirs();
        }
        return dir;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
