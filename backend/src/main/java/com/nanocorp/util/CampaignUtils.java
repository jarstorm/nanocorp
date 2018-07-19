package com.nanocorp.util;

import java.util.*;

import com.nanocorp.bean.db.*;
import com.nanocorp.bean.dto.*;

/**
 * Campaign utils class
 */
public class CampaignUtils {

	/**
	 * Transform campaign DB object to DTO object
	 * @param campaign DB campaign object
	 * @return DTO campaign object
	 */
	public static CampaignDto transformFromDbObject(Campaign campaign) {
		CampaignDto dto = new CampaignDto();
		dto.setId(campaign.getId());
		dto.setGoal(campaign.getGoal());
		dto.setName(campaign.getName());
		dto.setTotalBudget(campaign.getTotalBudget());
		dto.setPlatforms(getPlatforms(campaign));
		return dto;
	}

	/**
	 * Get platform from DB object
	 * @param campaign campaign DB object
	 * @return platforms DTO list
	 */
	private static List<PlatformDto> getPlatforms(Campaign campaign) {
		List<PlatformDto> platforms = new ArrayList<>();
		for (Platform platform : campaign.getPlatforms()) {
			PlatformDto platformDto = new PlatformDto();
			platformDto.setCreative(getCreatives(platform.getCreative()));
			platformDto.setId(platform.getId());
			platformDto.setInsights(getInsights(platform.getInsights()));
			platformDto.setPlatformType(platform.getPlatformType().getName());
			platformDto.setRemainingBudget(platform.getRemainingBudget());
			platformDto.setStatus(platform.getStatus());
			platformDto.setTargetAudience(getTargetAudience(platform.getTargetAudience()));
			platformDto.setTotalBudget(platform.getTotalBudget());
			platforms.add(platformDto);
		}
		return platforms;
	}

	/**
	 * Get target audience DTO
	 * @param targetAudience target audience DB object
	 * @return target audience DTO object
	 */
	private static TargetAudienceDto getTargetAudience(TargetAudience targetAudience) {
		TargetAudienceDto targetAudienceDto = null;
		if (targetAudience != null) {
			targetAudienceDto = new TargetAudienceDto();
			targetAudienceDto.setId(targetAudience.getId());
			targetAudienceDto.setAgeMax(targetAudience.getAgeMax());
			targetAudienceDto.setAgeMin(targetAudience.getAgeMin());

			Set<String> stringGenders = new HashSet<>();
			for (Gender gender : targetAudience.getGenders()) {
				stringGenders.add(gender.getCode());
			}
			targetAudienceDto.setGenders(stringGenders);

			Set<String> stringInterests = new HashSet<>();
			for (Interest interest : targetAudience.getInterests()) {
				stringInterests.add(interest.getCode());
			}
			targetAudienceDto.setInterests(stringInterests);

			Set<String> stringKeywords = new HashSet<>();
			for (Keyword keyword : targetAudience.getKeywords()) {
				stringKeywords.add(keyword.getCode());
			}
			targetAudienceDto.setKeywords(stringKeywords);

			Set<String> stringLanguages = new HashSet<>();
			for (Language language : targetAudience.getLanguages()) {
				stringLanguages.add(language.getCode());
			}
			targetAudienceDto.setLanguages(stringLanguages);

			Set<String> stringLocations = new HashSet<>();
			for (Location location : targetAudience.getLocations()) {
				stringLocations.add(location.getCode());
			}
			targetAudienceDto.setLocations(stringLocations);
		}
		return targetAudienceDto;
	}

	/**
	 * Get insights DTO object
	 * @param insights insights DB object
	 * @return insights DTO object
	 */
	private static InsightsDto getInsights(Insights insights) {
		InsightsDto insightsDto = null;
		if (insights != null) {
			insightsDto = new InsightsDto();
			insightsDto.setClicks(insights.getClicks());
			insightsDto.setClickThroughRate(insights.getClickThroughRate());
			insightsDto.setCostPerClick(insights.getCostPerClick());
			insightsDto.setId(insights.getId());
			insightsDto.setImpressions(insights.getImpressions());
			insightsDto.setKpi1(insights.getKpi1());
			insightsDto.setKpi2(insights.getKpi2());
			insightsDto.setNanosScore(insights.getNanosScore());
			insightsDto.setWebsiteVisits(insights.getWebsiteVisits());
		}
		return insightsDto;
	}

	/**
	 * Get creative DTO object
	 * @param creative creative DB object
	 * @return creative DTO object
	 */
	private static CreativeDto getCreatives(Creative creative) {
		CreativeDto creativeDto = null;
		if (creative != null) {
			creativeDto = new CreativeDto();
			creativeDto.setDescription(creative.getDescription());
			creativeDto.setHeader(creative.getHeader());
			creativeDto.setHeader1(creative.getHeader1());
			creativeDto.setHeader2(creative.getHeader2());
			creativeDto.setId(creative.getId());
			creativeDto.setImage(creative.getImage());
			creativeDto.setUrl(creative.getUrl());
		}
		return creativeDto;
	}
}
