package com.foodblog.sa.serviceImp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodblog.sa.domain.SubscriptionModel;
import com.foodblog.sa.enumHelper.UserStatus;
import com.foodblog.sa.jparepo.SubscriptionRepo;
import com.foodblog.sa.service.SubscriptionService;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

	@Autowired
	SubscriptionRepo subscriptionRepo;
	
	@Override
	public void subscribeNewUser(String model) {
		SubscriptionModel subModel = new SubscriptionModel();
		subModel.setUseremail(model);
		subModel.setStatus(UserStatus.ACTIVE);
		String timeStamp = new SimpleDateFormat("dd MMMMM yyyy").format(new Date());
		subModel.setTimestamp(timeStamp);
		subscriptionRepo.save(subModel);
		
//		SEND EMAIL FOR JOINING THE GROUP USE VELECITY TEMPELATE
		
	}

	@Override
	public void unsubscribe(String email) {
		SubscriptionModel sub = subscriptionRepo.findByUseremail(email);
		sub.setStatus(UserStatus.INACTIVE);
		subscriptionRepo.save(sub);
		
//		send unsubscription email
	}

	@Override
	public void resubscribe(String email) {
		SubscriptionModel sub = subscriptionRepo.findByUseremail(email);
		sub.setStatus(UserStatus.ACTIVE);
		subscriptionRepo.save(sub);
		
//		send welcome back email
	}

}
