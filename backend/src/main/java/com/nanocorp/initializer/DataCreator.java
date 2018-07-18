package com.nanocorp.initializer;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nanocorp.bean.db.*;
import com.nanocorp.bean.json.*;
import com.nanocorp.dao.*;

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

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private InterestRepository interestRepository;

	@Autowired
	private KeywordRepository keywordRepository;

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
	 *
	 * @param jsonPlatform json data of platform
	 * @param platformTypeId platform type stored in DB
	 * @return created platform
	 */
	private Platform readPlatform(JsonPlatform jsonPlatform, long platformTypeId) {
		Platform platform = new Platform();
		platform.setPlatformType(platformTypeRepository.findById(platformTypeId).get());
		platform.setTotalBudget(jsonPlatform.getTotal_budget());
		platform.setStatus(jsonPlatform.getStatus());
		platform.setRemainingBudget(jsonPlatform.getRemaining_budget());
		platform.setCreative(readCreativesData(jsonPlatform.getCreatives()));
		platform.setInsights(readInsightsData(jsonPlatform.getInsights()));
		platform.setTargetAudience(readTargetAudience(jsonPlatform.getTarget_audiance()));
		return platform;
	}

	/**
	 * Read creative data
	 *
	 * @param jsonCreatives json creative data
	 * @return creative data to insert in database
	 */
	private Creative readCreativesData(JsonCreatives jsonCreatives) {
		Creative creative = new Creative();
		creative.setDescription(jsonCreatives.getDescription());
		creative.setHeader(jsonCreatives.getHeader());
		creative.setHeader1(jsonCreatives.getHeader_1());
		creative.setHeader2(jsonCreatives.getHeader_2());
		creative.setImage(jsonCreatives.getImage());
		creative.setUrl(jsonCreatives.getUrl());
		return creative;
	}

	/**
	 * Read insights data
	 *
	 * @param jsonInsights json insights data
	 * @return insights to store in DB
	 */
	private Insights readInsightsData(JsonInsights jsonInsights) {
		Insights insights = new Insights();
		insights.setClicks(jsonInsights.getClicks());
		insights.setImpressions(jsonInsights.getImpressions());
		insights.setWebsiteVisits(jsonInsights.getWebsite_visits());
		insights.setNanosScore(jsonInsights.getNanos_score());
		insights.setCostPerClick(jsonInsights.getCost_per_click());
		insights.setClickThroughRate(jsonInsights.getClick_through_rate());
		insights.setKpi1(jsonInsights.getAdvanced_kpi_1());
		insights.setKpi2(jsonInsights.getAdvanced_kpi_2());
		return insights;
	}

	/**
	 * Read target audience data
	 *
	 * @param jsonTargetAudience json target audience data
	 * @return target audicnece entity for DB
	 */
	private TargetAudience readTargetAudience(JsonTargetAudience jsonTargetAudience) {
		TargetAudience targetAudience = new TargetAudience();
		targetAudience.setAgeMin(jsonTargetAudience.getAge_range().get(0));
		targetAudience.setAgeMax(jsonTargetAudience.getAge_range().get(1));
		readLanguages(jsonTargetAudience, targetAudience);
		readGenders(jsonTargetAudience, targetAudience);
		readLocations(jsonTargetAudience, targetAudience);
		readInterests(jsonTargetAudience, targetAudience);
		readKeywords(jsonTargetAudience, targetAudience);
		return targetAudience;
	}

	private void readKeywords(JsonTargetAudience jsonTargetAudience, TargetAudience targetAudience) {
		Set<Keyword> keywords = new HashSet<>();
		if (jsonTargetAudience.getKeyWords() != null) {
			for (String keyword : jsonTargetAudience.getKeyWords()) {
				Keyword keywordEntity = keywordRepository.findByCode(keyword);
				if (keywordEntity == null) {
					keywordEntity = new Keyword();
					keywordEntity.setCode(keyword);
					keywordRepository.save(keywordEntity);
				}
				keywords.add(keywordEntity);
			}
		}
		targetAudience.setKeywords(keywords);
	}

	private void readInterests(JsonTargetAudience jsonTargetAudience, TargetAudience targetAudience) {
		Set<Interest> interests = new HashSet<>();
		if (jsonTargetAudience.getInterests() != null) {
			for (String interest : jsonTargetAudience.getInterests()) {
				Interest interestEntity = interestRepository.findByCode(interest);
				if (interestEntity == null) {
					interestEntity = new Interest();
					interestEntity.setCode(interest);
					interestRepository.save(interestEntity);
				}
				interests.add(interestEntity);
			}
		}
		targetAudience.setInterests(interests);
	}

	private void readLocations(JsonTargetAudience jsonTargetAudience, TargetAudience targetAudience) {
		Set<Location> locations = new HashSet<>();
		if (jsonTargetAudience.getLocations() != null) {
			for (String location : jsonTargetAudience.getLocations()) {
				Location locationEntity = locationRepository.findByCode(location);
				if (locationEntity == null) {
					locationEntity = new Location();
					locationEntity.setCode(location);
					locationRepository.save(locationEntity);
				}
				locations.add(locationEntity);
			}
		}
		targetAudience.setLocations(locations);
	}

	private void readGenders(JsonTargetAudience jsonTargetAudience, TargetAudience targetAudience) {
		Set<Gender> genders = new HashSet<>();
		if (jsonTargetAudience.getGenders() != null) {
			for (String gender : jsonTargetAudience.getGenders()) {
				Gender genderEntity = genderRepository.findByCode(gender);
				if (genderEntity == null) {
					genderEntity = new Gender();
					genderEntity.setCode(gender);
					genderRepository.save(genderEntity);
				}
				genders.add(genderEntity);
			}
		}
		targetAudience.setGenders(genders);
	}

	private void readLanguages(JsonTargetAudience jsonTargetAudience, TargetAudience targetAudience) {
		Set<Language> languages = new HashSet<>();
		if (jsonTargetAudience.getLanguages() != null) {
			for (String language : jsonTargetAudience.getLanguages()) {
				Language languageEntity = languageRepository.findByCode(language);
				if (languageEntity == null) {
					languageEntity = new Language();
					languageEntity.setCode(language);
					languageRepository.save(languageEntity);
				}
				languages.add(languageEntity);
			}
		}
		targetAudience.setLanguages(languages);
	}

}
