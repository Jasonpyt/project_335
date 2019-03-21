package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/upload01")
    public String upload(String username, MultipartFile upload, HttpServletRequest request){
       //获取唯一的文件名称 uuid
        String uuidName = UUID.randomUUID().toString().replace("-", "");

        //获取文件名称
        String originalFilename = upload.getOriginalFilename();

        //获取文件后缀名
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));

        //拼接服务器文件的名称
        String fileName = uuidName + extendName;

        //获取服务器路径
        String serverPath = request.getSession().getServletContext().getRealPath("/upload");

        //判断upload路径是否存在,如果不存在创建一个
        if ( !new File(serverPath).exists()){
            new File(serverPath).mkdirs();
        }

        //文件上传
        try {
            upload.transferTo(new File(serverPath+"\\"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "show";
    }




    //跨服文件上传

    @RequestMapping("/upload")
    public String upload01(String username, MultipartFile upload, HttpServletRequest request){
        //获取唯一的文件名称 uuid
        String uuidName = UUID.randomUUID().toString().replace("-", "");

        //获取文件名称
        String originalFilename = upload.getOriginalFilename();

        //获取文件后缀名
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));

        //拼接服务器文件的名称
        String fileName = uuidName + extendName;


        //图片服务器的路径
        String url = "http://localhost:9090/img_servlet/upload/";
        //创建客户端对象
        Client client = Client.create();
        //获取文件的资源
        WebResource resource = client.resource(url +fileName);
        // 开始上传
        try {
            String put = resource.put(String.class, upload.getBytes());
            System.out.println(put);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "show";
    }

}
