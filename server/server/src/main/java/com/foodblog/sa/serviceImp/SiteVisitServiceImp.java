package com.foodblog.sa.serviceImp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodblog.sa.domain.SiteVisitModel;
import com.foodblog.sa.domain.UserModel;
import com.foodblog.sa.jparepo.SiteVisitRepo;
import com.foodblog.sa.service.SiteVisitService;

@Service
public class SiteVisitServiceImp implements SiteVisitService{

	
	@Autowired
	SiteVisitRepo siteVisitRepo;
	
	@Override
	public Collection<SiteVisitModel> findAll() {
		return siteVisitRepo.findAll();
	}

	@Override
	public SiteVisitModel addToSiteLog(SiteVisitModel visitDetails) {
		if(uniqueIpAddress(visitDetails)) {
			return	siteVisitRepo.save(visitDetails);
		}
		else {
			return visitDetails;
		}
	}
	
	public Boolean uniqueIpAddress(SiteVisitModel visitDetails) {
		System.out.println(siteVisitRepo.findByIpaddress(visitDetails.getIpaddress()));
		if(siteVisitRepo.findByIpaddress(visitDetails.getIpaddress()) != null) {
			return false;
		}else {
			return true;
		}
	}

}
