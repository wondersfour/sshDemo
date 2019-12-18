package com.imooc.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * easyui-tree实体类
 * @author zj
 * 说明 此处的实体类和easyui中接收到的json数据格式一致
 * 如果不一致
 * 可以通过dto(数据转换类型)变成一致
 *
 */
@Entity
@Table(name="easyui_tree")
public class EasyUITree {
	private String id;//主键
	private String text;//内容
	private String url;//对应的地址
	private String checked;//是否选中
	private String iconCls;//图标
	private String parentId;//父节点id值
	
	
	public EasyUITree() {
	}



	public EasyUITree(String id, String text, String url, String checked,
			String iconCls, String parentId) {
		this.id = id;
		this.text = text;
		this.url = url;
		this.checked = checked;
		this.iconCls = iconCls;
		this.parentId = parentId;
	}
	
	

	@Id
	@Column(name = "id", nullable = true, unique = true)
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue(generator = "generator")
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "text", nullable = true, length =100)
	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "iconcls", nullable = true, length = 32)
	public String getIconCls() {
		return iconCls;
	}


	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	@Column(name = "parentid", nullable = true, length = 32)
	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	@Column(name = "url", nullable = true, length = 32)
	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}


	@Column(name = "checked", nullable = true, length = 32)
	public String getChecked() {
		return checked;
	}



	public void setChecked(String checked) {
		this.checked = checked;
	}

}
