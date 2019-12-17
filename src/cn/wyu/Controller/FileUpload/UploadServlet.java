package cn.wyu.Controller.FileUpload;

import cn.wyu.Domain.Resource;
import cn.wyu.Domain.Users;
import cn.wyu.Service.ResourceService;
import cn.wyu.ServiceImple.ResourceServiceImple;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String resourceName = null;
        String type = null;
        String describe = null;
        String fileName = null;
        String saveFileName = null;
        //获取文件上传的保存目录
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //文件上传时，生成临时文件保存目录
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File tempFile = new File(tempPath);
        //判断文件上传的保存目录是否存在
        if (!tempFile.exists()) {
            System.out.println(savePath + "目录不存在，需要创建");
            //创建目录
            tempFile.mkdir();
        }
        //消息提示
        String message = "";
        try {
            //使用Apache文件上传组件处理文件上传步骤
            //1.创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传文件的大小超过缓冲区的大小是，就会生成一个临时文件存放到指定的临时文件中
            factory.setSizeThreshold(1024 * 100);  //设置缓冲区的大小为100kB
            //2.创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //监听文件上传进度
            upload.setProgressListener(new ProgressListener() {
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
                    /**
                     58                              * 文件大小为：14608,当前已处理：4096
                     59                                 文件大小为：14608,当前已处理：7367
                     60                                 文件大小为：14608,当前已处理：11419
                     61                                 文件大小为：14608,当前已处理：14608
                     62                              */
                }
            });
            //设置编码集
            upload.setHeaderEncoding("UTF-8");
            //3.判断提交上来的数据是否是上传表单的数据
            Boolean flag = ServletFileUpload.isMultipartContent(request);
            System.out.println(flag);
            //判断请求是否是文件上传，而不是表单信息。
            if (!ServletFileUpload.isMultipartContent(request)) {
                //不是文件上传，则退出程序。
                return;
            }
            //设置上传单个文件的最大值，目前设置为10MB
            upload.setFileSizeMax(1024 * 1024*10);
            //设置上传文件总量的最大值，最大=同时上传的多个文件的最大值的和，设置为10M
            upload.setSizeMax(1024 * 1024 * 10);
            //4.

            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //fileitem中封装的是普通数据
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    //解决普通输入项的数据乱码问题
                    String value = item.getString("UTF-8");
                    System.out.println(name + "=" + value);
                    if(name.equals("resourceName")) {
                        resourceName = value;
                    }
                    else if(name.equals("type")){
                        type = value;
                    }
                    else if(name.equals("describe")) {
                        describe = value;
                    }
                } else {
                    //fileitem封装的是上传文件
                    String filename = item.getName();
                    System.out.println(filename);
                    if (filename == null || filename.trim().equals("")) {
                        continue;
                    }
                    //处理获取到的上传文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    //获取文件名
                    fileName = filename;
                    //得到上传文件的扩展名
                    String fileExName = filename.substring(filename.lastIndexOf(".") + 1);
                    System.out.println("上传文件的扩展名为：" + fileExName);
                    //获取item中上传文件输入流
                    InputStream in = item.getInputStream();
                    //获取文件保存的名称
                    String saveFilename = makeFileName(filename);
                    //获取保存文件名
                    saveFileName = saveFilename;
                    //获取文件保存的目录
                    String realSavePath = makePath(saveFilename, savePath);

                    FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }

                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除临时文件
                    item.delete();
                }


            }

        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "单个文件超出最大值");
            request.getRequestDispatcher("/pages/upload/message.jsp").forward(request, response);
            return;
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "上传文件的中的大小超出限制的最大值");
            request.getRequestDispatcher("/pages/upload/message.jsp").forward(request, response);
            return;
        } catch (Exception e) {
            message = "文件上传失败";
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");
        Resource resource = new Resource(user.getUserName(),resourceName,describe,type,fileName,saveFileName);
        System.out.println(resourceName+" "+describe+" "+type+" "+user.getUserName()+" "+fileName+" "+saveFileName);
        ResourceService reService = new ResourceServiceImple();
        if(reService.isInsert(resource)){
            request.setAttribute("message", message);
            request.getRequestDispatcher("/pages/upload/message.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/pages/upload/message.jsp").forward(request, response);
        }
    }

    /**
     * 防止目录下面出现太多的文件，使用hash算法大散存储。
     *
     * @param filename
     * @param savePath
     * @return
     */
    private String makePath(String filename, String savePath) {
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashCode = filename.hashCode();
        int dir1 = hashCode & 0xf;
        int dir2 = (hashCode & 0xf0) >> 4;
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dir;
    }

    /**
     * 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
     *
     * @param filename
     * @return
     */
    private String makeFileName(String filename) {
        return UUID.randomUUID().toString() + "_" + filename;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
