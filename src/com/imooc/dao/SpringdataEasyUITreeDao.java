package com.imooc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.imooc.domain.EasyUITree;
import com.imooc.domain.TreeDto;
/**
 * 引入的jar包有：
 * spring-data-commons-1.7.2.RELEASE.jar
   spring-data-jpa-1.5.2.RELEASE.jar
   spring-data-commons-core-1.4.1.RELEASE.jar
 * @author zj
 *
 */


//@Repository
@Service("SpringdataEasyUITreeDao")
public interface SpringdataEasyUITreeDao extends JpaRepository<EasyUITree, String>{
	
	/**
	 * 自定义方法
	 * @return
	 */
	@Query("select * from easyui_tree")
	public List<TreeDto> getAllData();

}
