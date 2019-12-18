package com.baidu.ueditor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;
/**
 * 
 * 建立controller接收上传文件的请求，初始化编辑器等
 * @author zj
 *
 */


@Controller
@RequestMapping("/ueditor/ued")
public class UedController {
	
	
    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	
    	
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootPath+"===========>请求进入了<===============>>>>>");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            System.out.println("=====================>>>>"+exec);
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   /* *//**
     * 文件上传后台
     * @param request
     * @param response
     * @throws IOException
     *//*
    @RequestMapping(value="/fileUploadController")
    public void fileUploadController(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	System.out.println("=============>>>文件上传进入来了<<<====================");
    }
    
    *//**
     * 图片上传后台
     * @param request
     * @param response
     * @throws IOException
     *//*
    @RequestMapping(value="/picturefileUploadController")
    public void picturefileUploadController(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	System.out.println("=============>>图片上传进入来了<<<====================");
    }*/

}
