package com.nanocorp.service;

import java.util.List;

import com.nanocorp.bean.dto.CampaignDto;

/**
 * Campaign service
 */
public interface CampaignService {

	/**
	 * Get campaign by id
	 */
	CampaignDto findById(long id);

	/**
	 * Get every campaign in DB
	 */
	List<CampaignDto> findAll();

}
