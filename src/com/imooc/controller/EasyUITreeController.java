package com.imooc.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.imooc.dao.SpringdataEasyUITreeDao;
import com.imooc.domain.EasyUITree;
import com.imooc.domain.TreeDto;
import com.imooc.service.EasyUITreeService;
import com.wonders.aspectJ.AutoLog;

@Controller
public class EasyUITreeController {
	
	// 添加slf4j日志实例对象
	final static Logger logger = LoggerFactory.getLogger(EasyUITreeController.class);
	
	@Autowired
	private EasyUITreeService easyUITreeService;
	
	 
	
	//@Autowired
	//private SpringdataEasyUITreeDao springDataEasyUiTreeDao;
	
	
	/**
	 * 获取所有tree数据
	 * @throws IOException 
	 */
	@AutoLog(operationType="select操作:",operationName="查询树信息")
	@RequestMapping("/getAllData.do")
	public void getAllData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");//父节点Id ，异步加载时自动带入
		List<TreeDto> treeDtoList = easyUITreeService.getChildByParentId(id);
		String result =JSONArray.fromObject(treeDtoList).toString();
		System.out.println(result+"====>>>result<<<");
		logger.info("测试：{}", result);
		outPrint(result, request, response);
		  //System.out.println(System.getProperty("user.dir")+"=====>>"+System.getProperty("java.class.path"));
		/*Logger logger  =  Logger.getLogger(EasyUITreeController. class );
		logger.debug("debug");
		logger.error("error");*/
	}
	
	
	
	/**
	 * 新增
	 * @throws IOException 
	 */
	@RequestMapping("/save.do")
	public void save(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(request.getParameter("parentid")+"======><========="+request.getParameter("name"));
		String msg ="";
		Serializable id = null ;
		EasyUITree easyUITree = new EasyUITree();
		easyUITree.setChecked("false");
		easyUITree.setIconCls("add");
		easyUITree.setText(request.getParameter("name"));
		easyUITree.setUrl("https://");
		easyUITree.setParentId(request.getParameter("parentid"));
		try {
			id = this.easyUITreeService.add(easyUITree);
			
			/*this.springDataEasyUiTreeDao.deleteById("402880f96e1fcb01016e1fcbd8670000");
			
			 List<TreeDto> list = this.springDataEasyUiTreeDao.getAllData();
			 System.out.println(list.size()+"=============>>sizesize<<-=========");
			*/msg="保存成功！";
		} catch (Exception e) {
			msg="保存失败...";
			e.printStackTrace();
		}
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("msg", msg);
		result.put("id", id);
		JSONObject JSONObject = new JSONObject(result);
		
		outPrint(JSONObject.toString(), request, response);
		
	}
	/**
	 * 删除数据
	 * @throws IOException 
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		String msg ="";
		try {
			this.easyUITreeService.delete(id);
			msg ="删除成功！";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("=========>>getMessage<<========="+e.getMessage());
			// TODO: handle exception
			msg ="删除失败...";
		}
		
		Map<String, Object> val = new HashMap<String,Object>();
		val.put("msg", msg);
		
		JSONObject JSONObject = new JSONObject(val);
		
		outPrint(JSONObject.toString(), request, response);
		
	}

	/**
	 * 测试
	 * @throws IOException 
	 */
	@RequestMapping("/forTest.do")
	public void forTest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("===========>>this is for test<<====================");
		outPrint(" this is for test",request,response);
	}
	
	/**
	 * 对外写出数据
	 * @param result
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void outPrint(String result ,HttpServletRequest request,HttpServletResponse response) throws IOException{
		//response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(result);
	}

}
