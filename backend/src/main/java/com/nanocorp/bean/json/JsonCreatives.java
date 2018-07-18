package com.nanocorp.bean.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonCreatives {

	private String header;
	private String header_1;
	private String header_2;
	private String description;
	private String url;
	private String image;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeader_1() {
		return header_1;
	}

	public void setHeader_1(String header_1) {
		this.header_1 = header_1;
	}

	public String getHeader_2() {
		return header_2;
	}

	public void setHeader_2(String header_2) {
		this.header_2 = header_2;
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
