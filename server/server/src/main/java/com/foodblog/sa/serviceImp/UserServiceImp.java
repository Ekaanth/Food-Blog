package com.foodblog.sa.serviceImp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodblog.sa.domain.UserModel;
import com.foodblog.sa.jparepo.UserRepo;
import com.foodblog.sa.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public Collection<UserModel> findAll() {
		return userRepo.findAll();
	}

	
}
