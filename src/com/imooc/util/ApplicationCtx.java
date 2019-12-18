package com.imooc.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 * 通过监听器获取spring 上下文
 * 需要在web.xml中配置
 * @author zj
 *
 */
public class ApplicationCtx implements ServletContextListener {
	
	private static WebApplicationContext springContext;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		springContext = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
	}
	
	public static ApplicationContext ApplicationCtx() {
		return springContext;
	}
	
	public Object Getbeans(String name) {
		Object o = null;
		try {
			o = springContext.getBean(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	

}
