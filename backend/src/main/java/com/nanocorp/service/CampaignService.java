package com.nanocorp.service;

import java.util.List;

import com.nanocorp.bean.dto.CampaignDto;

public interface CampaignService {

	CampaignDto findById(long id);

	List<CampaignDto> findAll();
}
