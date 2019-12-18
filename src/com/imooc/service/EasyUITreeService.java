package com.imooc.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.dao.EasyUITreeDAO;
import com.imooc.domain.EasyUITree;
import com.imooc.domain.TreeDto;

@Transactional
@Service("easyUITreeService")
public class EasyUITreeService {
	@Autowired
	private EasyUITreeDAO easyUITreeDAO;
	
	
	public List<EasyUITree> getEasyUITree(){
		return this.easyUITreeDAO.getEasyUITree();
	}
	
	public Serializable add(EasyUITree easyUITree){
		return this.easyUITreeDAO.add(easyUITree);
	}
	
	public List<TreeDto> getChildByParentId(String id){
		return this.easyUITreeDAO.getChildByParentId(id);
	}
	/**
	 * 删除数据
	 * @param id
	 * @return 
	 */
	public void delete(String id) {
		 this.easyUITreeDAO.delete(id);
	}
}
