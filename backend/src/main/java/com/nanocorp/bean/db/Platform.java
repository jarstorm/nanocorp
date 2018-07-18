package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "NC_PLATFORM")
public class Platform implements Serializable {

	private static final long serialVersionUID = 8685655164998688249L;

	/**
	 * Platform id
	 */
	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "PT_ID")
	private PlatformType platformType;

	@Column(name = "P_TOTAL_BUDGET")
	private int totalBudget;

	@Column(name = "P_STATUS")
	private String status;

	@Column(name = "P_REMAINING_BUDGET")
	private int remainingBudget;

	@OneToOne(mappedBy = "platform", cascade = CascadeType.ALL)
	private Creative creative;

	@OneToOne(mappedBy = "platform", cascade = CascadeType.ALL)
	private Insights insights;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PlatformType getPlatformType() {
		return platformType;
	}

	public void setPlatformType(PlatformType platformType) {
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

	public Creative getCreative() {
		return creative;
	}

	public void setCreative(Creative creative) {
		this.creative = creative;
	}
}
