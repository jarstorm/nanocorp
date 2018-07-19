package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Interest database object
 */
@Entity
@Table(name = "NC_INTEREST")
public class Interest implements Serializable {

	private static final long serialVersionUID = 1137662211285731652L;

	/**
	 * Interest id
	 */
	@Id
	@Column(name = "I_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Interest code
	 */
	@Column(name = "I_CODE")
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
