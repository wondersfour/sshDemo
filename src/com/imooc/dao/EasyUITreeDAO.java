package com.imooc.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.imooc.domain.EasyUITree;
import com.imooc.domain.TreeDto;

@Repository
public class EasyUITreeDAO extends HibernateDaoSupport {
	@Resource
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory)
	{
	    super.setSessionFactory(sessionFactory);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 查询所有
	 */
	
	public List<EasyUITree> getEasyUITree(){
		return this.getSession().createCriteria(EasyUITree.class).list();
	}
	
	/**
	 * 新增
	 */
	public Serializable add(EasyUITree easyUITree){
		return this.getSession().save(easyUITree);
	}
	/**
	 * 找出根节点id
	 */
	 public List<TreeDto> getChildByParentId(String id){
		 String sql ="";
		 List<TreeDto> treeList = new ArrayList<TreeDto>();
		 if("".equals(id)||id == null){
			 sql =" select * from easyui_tree t where t.parentId is null";
		 }else{
			 sql =" select * from easyui_tree t where t.parentId ='"+id+"'";
		 }
	 
		  
		 SQLQuery  query = getSession().createSQLQuery(sql);
		 List<Object[]> idList = query.list();
		 for (Object[] o : idList) {
			 TreeDto treeDto = new TreeDto();
			 treeDto.setId((String)o[0]);
			 treeDto.setChecked(false);
			 treeDto.setText((String)o[4]);
			 //如果存在有子节点，默认关闭
			 if(getChild((String)o[0]).size()>0){
				 treeDto.setState("closed"); 
			 }else{
				 treeDto.setState("open");
			 }
			 Map<String,Object> attributes = new HashMap<String,Object>();
			 attributes.put("url", (String)o[3]);
			 treeDto.setAttributes(attributes);
			 treeList.add(treeDto);
		 }
		 return treeList;
	 }
	 
	 /**
	  * 查找所有孩子
	  * @param pid
	  * @return
	  */
	 public List<EasyUITree> getChild(String pid){
		 List<EasyUITree>  childList = new ArrayList<EasyUITree>();
		 String sql ="select * from easyui_tree t where t.parentId ='"+pid+"'";
		 SQLQuery  query = getSession().createSQLQuery(sql);
		 List<Object[]> idList = query.list();
		 for (Object[] o : idList) {
			 String parentId =(String)o[0];
			 EasyUITree easyUITree =  getEasyUITreeById(parentId);
			 childList.add(easyUITree);
		 }
		 
		 return childList;
	 }
	 
	 /**
	  * 根据主键查找单个对象
	  * @param id
	  * @return
	  */
	 public EasyUITree getEasyUITreeById(String parentId){
		 return (EasyUITree) this.getSession().createQuery("from EasyUITree where id=?").setParameter(0, parentId).uniqueResult();
	 }

	public void delete(String id) { 
		// TODO Auto-generated method stub
		this.getSession().createQuery("delete from EasyUITree where id =?").setParameter(0, id).executeUpdate();
		
	}
	 
	
	
	
	
	
	
	
	
	
}
