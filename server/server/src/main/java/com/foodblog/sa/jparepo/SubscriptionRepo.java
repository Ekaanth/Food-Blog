package com.foodblog.sa.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodblog.sa.domain.SubscriptionModel;

@Repository
public interface SubscriptionRepo extends JpaRepository<SubscriptionModel, Long> {

	public SubscriptionModel findByUseremail(String email);
}
