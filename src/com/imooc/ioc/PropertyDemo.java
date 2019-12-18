package com.imooc.ioc;

import java.util.Arrays;

/**
 * 对象注入复杂类型属性，如数组、List、Map、Properties。
 * @author zj
 *
 */
public class PropertyDemo {
	private String[] arr;

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "PropertyDemo [arr=" + Arrays.toString(arr) + "]";
	}
	
	
	

}
