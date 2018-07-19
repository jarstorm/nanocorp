package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Keyword database object
 */
@Entity
@Table(name = "NC_KEYWORD")
public class Keyword implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Keyword id
	 */
	@Id
	@Column(name = "K_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Keyword code
	 */
	@Column(name = "K_CODE")
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
