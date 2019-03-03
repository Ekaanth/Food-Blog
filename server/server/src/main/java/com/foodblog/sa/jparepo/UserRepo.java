package com.foodblog.sa.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodblog.sa.domain.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {

}
