package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "NC_TARGET_AUDIENCE")
public class TargetAudience implements Serializable {

	private static final long serialVersionUID = -1396103806618534326L;

	/**
	 * Target audience id
	 */
	@Id
	@Column(name = "TA_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


}
