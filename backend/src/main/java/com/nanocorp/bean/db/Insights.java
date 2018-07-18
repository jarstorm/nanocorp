package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "NC_INSIGHTS")
public class Insights implements Serializable {

	private static final long serialVersionUID = -7974633271634453615L;

	/**
	 * Insights id
	 */
	@Id
	@Column(name = "I_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "I_IMPRESSIONS")
	private long impressions;

	@Column(name = "I_CLICKS")
	private long clicks;

	@Column(name = "I_WEBSITE_VISITS")
	private long websiteVisits;

	@Column(name = "I_NANOS_SCORE")
	private float nanosScore;

	@Column(name = "I_COST_CLICK")
	private float costPerClick;

	@Column(name = "I_CLICK_RATE")
	private float clickThroughRate;

	@Column(name = "I_KPI_1")
	private float kpi1;

	@Column(name = "I_KPI_2")
	private float kpi2;

	@OneToOne(mappedBy="insights")
	@PrimaryKeyJoinColumn
	private Platform platform;

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

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
}
