package com.wonders.webServiceClient;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.endpoint.Client;
/**
 * cxf方式：
 * 客户端调动webService接口
 * @author zj
 * 
 * 用到的jar包 
 * cxf-2.4.3.jar
	neethi-3.0.1.jar
	wsdl4j-1.6.2.jar
	xmlschema-core-2.0.1.jar
	
	接口服务端改动了：https://blog.csdn.net/xie_xiansheng/article/details/78361760
 *
 */
public class TestWebService {
	
	
	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://192.168.0.123:8080/bd/cxfservices/CheckSocialDataService?wsdl");
        Object[] objs = client.invoke("showDataMessage","上海市青浦区俊先饮食店");
        System.out.println(objs[0].toString());
	}
}
