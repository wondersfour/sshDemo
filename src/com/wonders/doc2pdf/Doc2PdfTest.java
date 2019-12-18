package com.wonders.doc2pdf;

import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

/**
 * 将word文件转换成pdf（转换失败）应该需要添加些dll文件
 * 改用openOffice试下。
 * @author zj
 *
 */
public class Doc2PdfTest {
	
	
	public static void main(String[] args) {
        
        String word = "D:/wondersFile/bigdata/危废字典信息确认.docx";
        String name = "危废字典信息确认".concat(".pdf");
        String pdf = "E:\\"+name;
        wToPdfChange(word, pdf);
    }
	
	public static void wToPdfChange(String wordFile,String pdfFile){//wordFile word 的路径  //pdfFile pdf 的路径 
        
        ActiveXComponent app = null;
          System.out.println("开始转换...");
          // 开始时间
         // long start = System.currentTimeMillis();  
          try {
           // 打开word
           app = new ActiveXComponent("Word.Application");
           // 获得word中所有打开的文档
           Dispatch documents = app.getProperty("Documents").toDispatch();
           System.out.println("打开文件: " + wordFile);
           // 打开文档
           Dispatch document = Dispatch.call(documents, "Open", wordFile, false, true).toDispatch();
           // 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
           File target = new File(pdfFile);  
            if (target.exists()) {  
               target.delete();
            }
           System.out.println("另存为: " + pdfFile);
           Dispatch.call(document, "SaveAs", pdfFile, 17);
           // 关闭文档
           Dispatch.call(document, "Close", false);
          }catch(Exception e) {
           System.out.println("转换失败"+e.getMessage());
          }finally {
            // 关闭office
           app.invoke("Quit", 0);
          }
   }
}
