package com.foodblog.sa.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodblog.sa.domain.SiteVisitModel;

@Repository
public interface SiteVisitRepo extends JpaRepository<SiteVisitModel, Long> {

	public SiteVisitModel findByIpaddress(String ipaddress);
}

