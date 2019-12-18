package com.imooc.domain;
/**
 * 属性注入
 * @author zj
 *
 */
public class Demo1 {
	private String demoName;

	
	
	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}



	/*public Demo1() {
	}
	public Demo1(String demoName) {
		this.demoName = demoName;
	}*/
	public void say(){
		System.out.println("this is demo1."+demoName);
	}
	
	
}
