package com.wonders.hessian.impl;

import com.wonders.domain.HessianUser;
import com.wonders.hessian.IService;

public class ServiceImpl implements IService {

	public HessianUser getUser() {
		
		return new HessianUser("孤傲沧浪");
	}

}
