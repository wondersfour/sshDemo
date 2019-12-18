package com.wonders.aspectJ;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义切面
 * @author zj
 *
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoLog {
	
	/** 要执行的操作类型比如：add操作 **/  
    public String operationType() default "";  
     
    /** 要执行的具体操作比如：添加用户 **/  
    public String operationName() default "";

}
