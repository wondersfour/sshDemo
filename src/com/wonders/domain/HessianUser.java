package com.wonders.domain;

import java.io.Serializable;

public class HessianUser implements Serializable {
	private static final long serialVersionUID = 1692800630322115854L;
    //name属性
    private String name;

    public HessianUser() {
        
    }

    public HessianUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "HessianUser [name=" + name + "]";
	}
    
    
}
