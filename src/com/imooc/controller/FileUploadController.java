package com.imooc.controller;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试文件上传
 * @author zj
 *
 */
@Controller
public class FileUploadController {
		
		@RequestMapping("/fileUpload.do")
		public ModelAndView fileUpload(HttpServletRequest request,HttpServletResponse response) throws Exception{
			Map hashMap = new HashMap();
			
			InputStream is = null;
			
			request.setCharacterEncoding("utf-8");
		      response.setContentType("text/html;charset=UTF-8");
		      
		      char sepChar = File.separatorChar;
		      Date nowDate = new Date();
		      Map<String, String> map = new HashMap();
		      DiskFileUpload fu = new DiskFileUpload();
		      fu.setSizeMax(524288000L);
		      fu.setSizeThreshold(1048576);
		      

		      List fileItems = fu.parseRequest(request);
		      
		      FileItem fileItem = null;
		      String fileExt = null;
		      String filePath = null;
		      String fileName = "";
		      long size = 0L;
		      for (Iterator iterator = fileItems.iterator(); iterator.hasNext();)
		      {
		        fileItem = (FileItem)iterator.next();
		        if (fileItem.isFormField())
		        {
		          map.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
		        }
		        else
		        {
		          filePath = URLDecoder.decode(fileItem.getName(), "utf-8");
		          size = fileItem.getSize();
		          is = fileItem.getInputStream();
		          if (((filePath != null) && (!filePath.equals(""))) || (size != 0L))
		          {
		            fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
		            if (fileName.lastIndexOf(".") > 0) {
		              fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
		            } else {
		              fileExt = null;
		            }
		            System.out.println(fileExt+"==============>>fileExt<<=================");
		          }
		        }
		      }
		      
		      for (Map.Entry<String,String> entry:map.entrySet()){
           	   System.out.println(entry.getKey()+"====>>entryentry<<==="+entry.getValue());
           	}
		      System.out.println("unFirstConnected".equals(map.get("select"))+"====>>unFirstConnected<<====");
		      
		      
			return new ModelAndView("");
		}
}
