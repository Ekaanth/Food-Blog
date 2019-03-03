package com.foodblog.sa.service;

import java.util.Collection;

import com.foodblog.sa.domain.SiteVisitModel;
import com.foodblog.sa.domain.UserModel;

public interface SiteVisitService {

	public Collection<SiteVisitModel> findAll();

	public SiteVisitModel addToSiteLog(SiteVisitModel visitDetails);
}
