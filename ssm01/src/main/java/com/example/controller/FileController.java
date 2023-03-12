package com.example.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {
    private static String FILE_SERVER = "http://guchenfei:8090/upload/";

    @ResponseBody
    @RequestMapping("/fileUpload.do")
    public Map<String, String> uploadFile(MultipartFile headPhoto) throws IOException {
        Map<String, String> result = new HashMap<>();
//        final long size = headPhoto.getSize();
//        if (size > 5 * 1024 * 1024) {
//            result.put("message", "文件不能大于5M");
//            return result;
//        }
//        String realPath = req.getServletContext().getRealPath("/upload");
//        File dir = new File(realPath);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
        final String originalFilename = headPhoto.getOriginalFilename();
        final String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
//        if (!extendName.equals(".jpg")) {
//            result.put("message", "文件必须为jpg格式.");
//            return result;
//        }
        final String uuid = UUID.randomUUID().toString();
        String newFileName = uuid.concat(extendName);
        final Client client = Client.create();
        final WebResource resource = client.resource(FILE_SERVER + newFileName);
        resource.put(String.class, headPhoto.getBytes());
        result.put("message", "文件上传成功.");
        result.put("newFileName", newFileName);
        result.put("fileType", headPhoto.getContentType());
        return result;
    }

    @RequestMapping("/fileDownload.do")
    public void fileDownload(String photoName, String fileType, HttpServletResponse response) throws IOException {
        System.out.println("photoName" + photoName + "fileType = " + fileType);
        response.setHeader("Content-Disposition","attachment:filename=" + photoName);
        response.setContentType(fileType);
        System.out.println("filePath = " + FILE_SERVER + photoName);
        final InputStream inputStream = new URL(FILE_SERVER + photoName).openStream();
        final ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
    }
}
