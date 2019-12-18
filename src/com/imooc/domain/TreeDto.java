package com.imooc.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 
· id：节点的 id，它对于加载远程数据很重要。
· text：显示的节点文字。
· state：节点状态， 'open' 或 'closed'，默认是 'open'。当设为 'closed' 时，此节点有子节点，并且将从远程站点加载它们。
· checked：指示节点是否被选中。 Indicate whether the node is checked selected.
· attributes：给一个节点追加的自定义属性。
· children：定义了一些子节点的节点数组。

 * @author Administrator
 *
 */
public class TreeDto {
	private String id;
	private String text;
	private String state;
	private boolean checked;
	private Map<String,Object> attributes = new HashMap<String,Object>();
	
	public TreeDto(String id, String text, String state, boolean checked,
			Map<String, Object> attributes) {
		this.id = id;
		this.text = text;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
	}
	
	public TreeDto() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	

}
