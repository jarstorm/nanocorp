package com.nanocorp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanocorp.bean.db.Campaign;
import com.nanocorp.bean.dto.CampaignDto;
import com.nanocorp.dao.CampaignRepository;
import com.nanocorp.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;

	@Override
	public CampaignDto findById(long id) {
		Campaign campaign = campaignRepository.findById(id).get();
		CampaignDto dto = initializeCampaignDto(campaign);
		return dto;
	}

	private CampaignDto initializeCampaignDto(Campaign campaign) {
		CampaignDto dto = new CampaignDto();
		dto.setId(campaign.getId());
		dto.setGoal(campaign.getGoal());
		dto.setName(campaign.getName());
		dto.setTotalBudget(campaign.getTotalBudget());
		return dto;
	}

	@Override
	public List<CampaignDto> findAll() {
		List<Campaign> campaigns = campaignRepository.findAll();
		List<CampaignDto> list = new ArrayList<>();
		for (Campaign campaign: campaigns) {
			CampaignDto dto = initializeCampaignDto(campaign);
			list.add(dto);
		}
		return list;
	}

}
