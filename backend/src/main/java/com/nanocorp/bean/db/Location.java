package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Location database entity
 */
@Entity
@Table(name = "NC_LOCATION")
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Location id
	 */
	@Id
	@Column(name = "L_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Location code
	 */
	@Column(name = "L_CODE")
	private String code;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
