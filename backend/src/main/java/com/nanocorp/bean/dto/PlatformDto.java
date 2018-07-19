package com.nanocorp.bean.dto;

public class PlatformDto {

	private long id;

	private String platformType;

	private int totalBudget;

	private String status;

	private int remainingBudget;

	private CreativeDto creative;

	private InsightsDto insights;

	private TargetAudienceDto targetAudience;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public int getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(int totalBudget) {
		this.totalBudget = totalBudget;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRemainingBudget() {
		return remainingBudget;
	}

	public void setRemainingBudget(int remainingBudget) {
		this.remainingBudget = remainingBudget;
	}

	public CreativeDto getCreative() {
		return creative;
	}

	public void setCreative(CreativeDto creative) {
		this.creative = creative;
	}

	public InsightsDto getInsights() {
		return insights;
	}

	public void setInsights(InsightsDto insights) {
		this.insights = insights;
	}

	public TargetAudienceDto getTargetAudience() {
		return targetAudience;
	}

	public void setTargetAudience(TargetAudienceDto targetAudience) {
		this.targetAudience = targetAudience;
	}


}
