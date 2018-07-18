package com.nanocorp.bean.json;

public class JsonCampaign {

	private long id;

	private String name;

	private String goal;

	private int total_budget;

	private String status;

	private JsonPlatforms platforms;

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

	public int getTotal_budget() {
		return total_budget;
	}

	public void setTotal_budget(int total_budget) {
		this.total_budget = total_budget;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JsonPlatforms getPlatforms() {
		return platforms;
	}

	public void setPlatforms(JsonPlatforms platforms) {
		this.platforms = platforms;
	}

}
