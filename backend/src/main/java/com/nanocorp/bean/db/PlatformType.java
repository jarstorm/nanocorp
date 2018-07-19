package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Platform type
 */
@Entity
@Table(name = "NC_PLATFORM_TYPE")
public class PlatformType implements Serializable {

	private static final long serialVersionUID = -1905440521758444182L;

	/**
	 * Platform id
	 */
	@Id
	@Column(name = "PT_ID")
	private long id;

	/**
	 * Platform name
	 */
	@Column(name = "PT_NAME")
	private String name;

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

}
