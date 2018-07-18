package com.nanocorp.bean;

public class Platform {
	private String status;
	private String total_budget;
	private String remaining_budget;
	private String start_date;
	private String end_date;
	private TargetAudiance target_audiance;
	private Creatives creatives;
	private Insights insights;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotal_budget() {
		return total_budget;
	}

	public void setTotal_budget(String total_budget) {
		this.total_budget = total_budget;
	}

	public String getRemaining_budget() {
		return remaining_budget;
	}

	public void setRemaining_budget(String remaining_budget) {
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

	public TargetAudiance getTarget_audiance() {
		return target_audiance;
	}

	public void setTarget_audiance(TargetAudiance target_audiance) {
		this.target_audiance = target_audiance;
	}

	public Creatives getCreatives() {
		return creatives;
	}

	public void setCreatives(Creatives creatives) {
		this.creatives = creatives;
	}

	public Insights getInsights() {
		return insights;
	}

	public void setInsights(Insights insights) {
		this.insights = insights;
	}

}
