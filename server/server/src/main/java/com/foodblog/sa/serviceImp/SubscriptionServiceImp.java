package com.foodblog.sa.serviceImp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.foodblog.sa.domain.SubscriptionModel;
import com.foodblog.sa.enumHelper.UserStatus;
import com.foodblog.sa.jparepo.SubscriptionRepo;
import com.foodblog.sa.service.SubscriptionService;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

	@Autowired
	private JavaMailSender javaMailSender;


	@Autowired 
	SubscriptionRepo subscriptionRepo;
	
	
	@Override
	public void subscribeNewUser(String email) throws Exception{

//		SEND EMAIL FOR JOINING THE GROUP USE VELECITY TEMPELATE
		
		try {
			SubscriptionModel sub = new SubscriptionModel();
			sub.setUseremail(email);
			sub.setStatus(UserStatus.ACTIVE);
			String timeStamp = new SimpleDateFormat("dd MMMMM yyyy").format(new Date());
			sub.setTimestamp(timeStamp);
			subscriptionRepo.save(sub);
			SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setTo(email); 
	        message.setSubject("Test"); 
	        message.setText("Email sent");
	        javaMailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
			}
		
		
	}

	@Override
	public void unsubscribe(String email) {
		SubscriptionModel sub = subscriptionRepo.findByUseremail(email);
		sub.setStatus(UserStatus.INACTIVE);
		subscriptionRepo.save(sub);
		
//		send unsubscription email
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 
        message.setSubject("Test"); 
        message.setText("Email sent");
        javaMailSender.send(message);
	}

	@Override
	public void resubscribe(String email) {
		SubscriptionModel sub = subscriptionRepo.findByUseremail(email);
		sub.setStatus(UserStatus.ACTIVE);
		subscriptionRepo.save(sub);
		
//		send welcome back email
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 
        message.setSubject("Test"); 
        message.setText("Email sent");
        javaMailSender.send(message);
	}

}
