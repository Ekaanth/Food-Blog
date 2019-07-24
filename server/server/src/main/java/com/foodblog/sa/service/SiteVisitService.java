package com.foodblog.sa.service;

import java.util.Collection;

import com.foodblog.sa.domain.SiteVisitModel;

public interface SiteVisitService {

	public Collection<SiteVisitModel> findAll();

	public SiteVisitModel addToSiteLog(SiteVisitModel visitDetails);
}
