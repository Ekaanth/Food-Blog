package com.foodblog.sa.service;

import java.util.Collection;

import com.foodblog.sa.domain.UserModel;


public interface UserService {
	
	public Collection<UserModel> findAll();
}
