package com.foodblog.sa.service;

public interface SubscriptionService {

	public void subscribeNewUser(String email);
	
	public void unsubscribe(String email);
	
	public void resubscribe(String email);
}
