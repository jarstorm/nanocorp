package com.nanocorp.bean.dto;

import java.util.List;

public class CampaignDto {

	private long id;
	private String name;
	private String goal;
	private int totalBudget;
	private List<PlatformDto> platforms;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public int getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(int totalBudget) {
		this.totalBudget = totalBudget;
	}

	public List<PlatformDto> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<PlatformDto> platforms) {
		this.platforms = platforms;
	}
}
