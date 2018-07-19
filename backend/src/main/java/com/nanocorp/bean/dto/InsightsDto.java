package com.nanocorp.bean.dto;

/**
 * Class to transform from DB object to DTO insights
 */
public class InsightsDto {

	private long id;

	private long impressions;

	private long clicks;

	private long websiteVisits;

	private float nanosScore;

	private float costPerClick;

	private float clickThroughRate;

	private float kpi1;

	private float kpi2;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getImpressions() {
		return impressions;
	}

	public void setImpressions(long impressions) {
		this.impressions = impressions;
	}

	public long getClicks() {
		return clicks;
	}

	public void setClicks(long clicks) {
		this.clicks = clicks;
	}

	public long getWebsiteVisits() {
		return websiteVisits;
	}

	public void setWebsiteVisits(long websiteVisits) {
		this.websiteVisits = websiteVisits;
	}

	public float getNanosScore() {
		return nanosScore;
	}

	public void setNanosScore(float nanosScore) {
		this.nanosScore = nanosScore;
	}

	public float getCostPerClick() {
		return costPerClick;
	}

	public void setCostPerClick(float costPerClick) {
		this.costPerClick = costPerClick;
	}

	public float getClickThroughRate() {
		return clickThroughRate;
	}

	public void setClickThroughRate(float clickThroughRate) {
		this.clickThroughRate = clickThroughRate;
	}

	public float getKpi1() {
		return kpi1;
	}

	public void setKpi1(float kpi1) {
		this.kpi1 = kpi1;
	}

	public float getKpi2() {
		return kpi2;
	}

	public void setKpi2(float kpi2) {
		this.kpi2 = kpi2;
	}

}
