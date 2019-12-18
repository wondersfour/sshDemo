package com.wonders.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zj
 *  aop配合slf4j打印日志
 *	https://blog.csdn.net/young4dream/article/details/79662033
 */

@Component
@Aspect
public class AutoLogAspectJ {
	
	private  static  final Logger logger = LoggerFactory.getLogger(AutoLogAspectJ. class);
	
	
	//Controller层切点  
    @Pointcut("execution (* com.imooc.controller..*.*(..))") 
	public void controllerAspect(){
		
	}
	 /** 
     * 前置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */ 
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
    	logger.info("==========执行controller前置通知===============");
        if(logger.isInfoEnabled()){
            logger.info("执行的before方法:" + joinPoint);
        }
        logger.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+"");
    }  

}
