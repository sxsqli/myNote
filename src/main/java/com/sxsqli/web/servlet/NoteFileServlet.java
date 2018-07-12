package com.sxsqli.web.servlet;

import com.sxsqli.domain.NoteFile;
import com.sxsqli.domain.User;
import com.sxsqli.service.NoteFileService;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class NoteFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if ("findAll".equals(op)) {
            findAll(request, response);
        } else if ("findLike".equals(op)) {
            findLike(request, response);
        } else if ("upload".equals(op)) {
            upload(request, response);
        }
    }

    private void upload(HttpServletRequest request, HttpServletResponse response) {
        if (!ServletFileUpload.isMultipartContent(request)) {
            return;
        }

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        try {


            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);

            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    // 普通表单项
                } else if (fileItem.getSize() > 0) {
                    // 文件上传表单项

                    // 获取文件名
                    String fileName = fileItem.getName();
                    // IE的fileName会带盘符，进行切割，剩下文件名
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    if (!fileName.endsWith("md")) {
                        return;
                    }

                    String path = getServletContext().getRealPath("/markdown");
                    File filePath = new File(path);

                    File fileImg = new File(filePath, fileName);
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    } else {
                        for (int i = 1; fileImg.exists(); i++) {
                            fileImg = new File(filePath, fileName.replaceAll("[.]", "(" + i + ")."));
                        }
                    }


                    // 写入文件
                    fileItem.write(fileImg);

                    NoteFile noteFile = new NoteFile();
                    noteFile.setFilename(fileName.split("[.]")[0]);
                    noteFile.setPath("markdown/" + fileName);
                    User user = (User) request.getSession().getAttribute("user");
                    noteFile.setUserid(user.getUid());

                    new NoteFileService().insert(noteFile);

                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findLike(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String like = request.getParameter("like");
        NoteFileService noteFileService = new NoteFileService();
        List<NoteFile> files = noteFileService.findLike(like);
        JSONArray jsonArray = JSONArray.fromObject(files);
        response.getWriter().print(jsonArray);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NoteFileService noteFileService = new NoteFileService();
        List<NoteFile> all = noteFileService.findAll();
        JSONArray jsonArray = JSONArray.fromObject(all);
        response.getWriter().print(jsonArray);
    }
}
