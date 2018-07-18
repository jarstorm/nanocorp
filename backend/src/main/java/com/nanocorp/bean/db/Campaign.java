package com.nanocorp.bean.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "NC_CAMPAIGN")
public class Campaign implements Serializable {

	private static final long serialVersionUID = -7258731921912704592L;

	/**
	 * Campaign id
	 */
	@Id
	@Column(name = "C_ID")
	private long id;

	/**
	 * Name
	 */
	@Column(name = "C_NAME")
	private String name;

	/**
	 * Goal
	 */
	@Column(name = "C_GOAL")
	private String goal;

	/**
	 * Total budget
	 */
	@Column(name = "C_TOTAL_BUDGET")
	private int totalBudget;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "P_CAMPAIGN", referencedColumnName = "C_ID")
	private List<Platform> platforms = new ArrayList<>();

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

	public List<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platform> platforms) {
		this.platforms = platforms;
	}
}
