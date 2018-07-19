package com.nanocorp.bean.json;

/**
 * Read JSON data for platform
 */
public class JsonPlatform {
	private String status;
	private int total_budget;
	private int remaining_budget;
	private String start_date;
	private String end_date;
	private JsonTargetAudience target_audiance;
	private JsonCreatives creatives;
	private JsonInsights insights;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotal_budget() {
		return total_budget;
	}

	public void setTotal_budget(int total_budget) {
		this.total_budget = total_budget;
	}

	public int getRemaining_budget() {
		return remaining_budget;
	}

	public void setRemaining_budget(int remaining_budget) {
		this.remaining_budget = remaining_budget;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public JsonTargetAudience getTarget_audiance() {
		return target_audiance;
	}

	public void setTarget_audiance(JsonTargetAudience target_audiance) {
		this.target_audiance = target_audiance;
	}

	public JsonCreatives getCreatives() {
		return creatives;
	}

	public void setCreatives(JsonCreatives creatives) {
		this.creatives = creatives;
	}

	public JsonInsights getInsights() {
		return insights;
	}

	public void setInsights(JsonInsights insights) {
		this.insights = insights;
	}

}
