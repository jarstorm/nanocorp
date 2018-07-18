package com.nanocorp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanocorp.bean.db.Campaign;
import com.nanocorp.dao.CampaignRepository;
import com.nanocorp.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;

	@Override
	public Campaign findById(long id) {
		return campaignRepository.findById(id).get();
	}

}
