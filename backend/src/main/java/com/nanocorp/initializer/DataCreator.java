package com.nanocorp.initializer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nanocorp.bean.db.*;
import com.nanocorp.bean.json.JsonCampaign;
import com.nanocorp.bean.json.JsonPlatform;
import com.nanocorp.dao.CampaignRepository;
import com.nanocorp.dao.PlatformTypeRepository;

@Component
public class DataCreator {

	private static Logger logger = LoggerFactory.getLogger(DataCreator.class);

	private final long GOOGLE_PLATFORM_ID = 1;
	private final long INSTAGRAM_PLATFORM_ID = 2;
	private final long FACEBOOK_PLATFORM_ID = 3;

	@Autowired
	private CampaignRepository campaignRepository;

	@Autowired
	private PlatformTypeRepository platformTypeRepository;

	public void createData(JsonCampaign[] campaigns) {
		// Clear previous data
		campaignRepository.deleteAll();
		platformTypeRepository.deleteAll();

		PlatformType ptGoogle = new PlatformType();
		ptGoogle.setId(GOOGLE_PLATFORM_ID);
		ptGoogle.setName("Google");
		platformTypeRepository.save(ptGoogle);

		PlatformType ptFacebook = new PlatformType();
		ptFacebook.setId(FACEBOOK_PLATFORM_ID);
		ptFacebook.setName("Facebook");
		platformTypeRepository.save(ptFacebook);

		PlatformType ptInstagram = new PlatformType();
		ptInstagram.setId(INSTAGRAM_PLATFORM_ID);
		ptInstagram.setName("Instagram");
		platformTypeRepository.save(ptInstagram);

		for (JsonCampaign campaign : campaigns) {
			Campaign c = new Campaign();
			c.setId(campaign.getId());
			c.setGoal(campaign.getGoal());
			c.setName(campaign.getName());
			c.setTotalBudget(campaign.getTotal_budget());
			List<Platform> platforms = new ArrayList<>();
			if (campaign.getPlatforms().getGoogle() != null) {
				platforms.add(readPlatform(campaign.getPlatforms().getGoogle(), GOOGLE_PLATFORM_ID));
			}
			if (campaign.getPlatforms().getFacebook() != null) {
				platforms.add(readPlatform(campaign.getPlatforms().getFacebook(), FACEBOOK_PLATFORM_ID));
			}
			if (campaign.getPlatforms().getInstagram() != null) {
				platforms.add(readPlatform(campaign.getPlatforms().getInstagram(), INSTAGRAM_PLATFORM_ID));
			}
			c.setPlatforms(platforms);
			campaignRepository.save(c);
		}

		logger.info("Data read from file data.json finished");
	}

	/**
	 * Read platform data from json
	 * @param jsonPlatform json data of platform
	 * @param platformTypeId platform type stored in DB
	 * @return created platform
	 */
	private Platform readPlatform(JsonPlatform jsonPlatform, long platformTypeId) {
		Platform platform =  new Platform();
		platform.setPlatformType(platformTypeRepository.findById(platformTypeId).get());
		platform.setTotalBudget(jsonPlatform.getTotal_budget());
		platform.setStatus(jsonPlatform.getStatus());
		platform.setRemainingBudget(jsonPlatform.getRemaining_budget());

		return platform;
	}

}
