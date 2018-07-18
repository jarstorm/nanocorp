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
}
