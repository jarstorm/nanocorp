package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "NC_GENDER")
public class Gender implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Gender id
	 */
	@Id
	@Column(name = "G_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "G_CODE")
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