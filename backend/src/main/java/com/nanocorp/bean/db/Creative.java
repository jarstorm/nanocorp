package com.nanocorp.bean.db;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "NC_CREATIVE")
public class Creative implements Serializable {

	private static final long serialVersionUID = -5293108294821693505L;

	/**
	 * Creative id
	 */
	@Id
	@Column(name = "C_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "C_HEADER")
	@Lob
	private String header;

	@Column(name = "C_HEADER_1")
	@Lob
	private String header1;

	@Column(name = "C_HEADER_2")
	@Lob
	private String header2;

	@Column(name = "C_DESCRIPTION")
	@Lob
	private String description;

	@Column(name = "C_URL")
	@Lob
	private String url;

	@Column(name = "C_IMAGE")
	@Lob
	private String image;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Platform platform;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeader1() {
		return header1;
	}

	public void setHeader1(String header1) {
		this.header1 = header1;
	}

	public String getHeader2() {
		return header2;
	}

	public void setHeader2(String header2) {
		this.header2 = header2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
