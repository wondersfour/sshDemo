package com.imooc.util;

import java.io.Serializable;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;



@SuppressWarnings("deprecation")
public class BaseDaoImpl extends HibernateDaoSupport {
	
	/**
	 * 获取数据
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getObject(Class clazz,Integer id) {
		Object object=this.getHibernateTemplate().get(clazz,id);
		return object;	
		
	}
	/**
	 * 添加数据
	 * @param obj
	 * @return
	 */
	public Serializable addObject(Object obj) {
		Serializable id = null;
		id=this.getHibernateTemplate().save(obj);
		this.getHibernateTemplate().flush();
		return id;
	}
}
