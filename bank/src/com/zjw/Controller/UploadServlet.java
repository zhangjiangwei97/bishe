package com.zjw.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
  
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
  
  
public class UploadServlet extends HttpServlet {
  
  /**
   * Constructor of the object.
   */
  public UploadServlet() {
    super();
  }
  
  /**
   * Destruction of the servlet. <br>
   */
  public void destroy() {
    super.destroy(); // Just puts "destroy" string in log
    // Put your code here
  }
  
  /**
   * The doGet method of the servlet. <br>
   *
   * This method is called when a form has its tag value method equals to get.
   *
   * @param request the request send by the client to the server
   * @param response the response send by the server to the client
   * @throws ServletException if an error occurred
   * @throws IOException if an error occurred
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  
    this.doPost(request, response);
  }
  
  /**
   * The doPost method of the servlet. <br>
   *
   * This method is called when a form has its tag value method equals to post.
   *
   * @param request the request send by the client to the server
   * @param response the response send by the server to the client
   * @throws ServletException if an error occurred
   * @throws IOException if an error occurred
   */
  @SuppressWarnings("deprecation")
public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	String message = "";
    response.setContentType("text/html");
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    DiskFileItemFactory sf= new DiskFileItemFactory();//ʵ�������̱��ļ��б���
    ServletContext context = this.getServletContext();
    String path = context.getRealPath("/download");//�õ��ϴ��ļ��Ĵ��Ŀ¼
    System.out.println("Ŀ¼"+path);
    sf.setRepository(new File(path));//�����ļ����Ŀ¼
    sf.setSizeThreshold(1024*1024);//�����ļ��ϴ�С��1M�����ڴ���
    String rename = "";//�ļ������ɵ��ļ���
    String fileName = "";//�ļ�ԭ����
    String name = "";//��ͨfield�ֶ�
    //�ӹ����õ�servletupload�ļ��ϴ���
    ServletFileUpload sfu = new ServletFileUpload(sf);
      
    try {
      List<FileItem> lst = sfu.parseRequest(request);//�õ�request�����е�Ԫ��
      for (FileItem fileItem : lst) {
        if(fileItem.isFormField()){
          if("name".equals(fileItem.getFieldName())){
            name = fileItem.getString("UTF-8");
          }
        }else{
          //����ļ�����
          fileName = fileItem.getName();
          fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
          String houzhui = fileName.substring(fileName.lastIndexOf("."));
         // +houzhui
          rename = fileName;
          fileItem.write(new File(path, rename));
        }
      }
      message= "�ļ��ϴ��ɹ���";
    } catch (Exception e) {
      // TODO Auto-generated catch block
      message= "�ļ��ϴ�ʧ�ܣ�";
      e.printStackTrace();
    }
    request.setAttribute("message",message);
    request.getRequestDispatcher("/message.jsp").forward(request, response);
    System.out.println("��ͨ�ֶ�"+name);
    System.out.println("�ļ�����"+fileName);
    System.out.println("�޸ĺ����ɵ��ļ�����"+rename);
    out.flush();
    out.close();
  }
  
  
 
  /**
   * Initialization of the servlet. <br>
   *
   * @throws ServletException if an error occurs
   */
  public void init() throws ServletException {
    // Put your code here
  }
  
}