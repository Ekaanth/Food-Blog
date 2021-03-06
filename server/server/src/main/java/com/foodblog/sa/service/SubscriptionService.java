package com.foodblog.sa.service;

public interface SubscriptionService {

	public void subscribeNewUser(String email) throws Exception;
	
	public void unsubscribe(String email);
	
	public void resubscribe(String email);
}
