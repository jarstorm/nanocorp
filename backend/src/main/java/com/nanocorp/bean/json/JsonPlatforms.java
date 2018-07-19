package com.nanocorp.bean.json;

/**
 * Read JSON data for platforms
 */
public class JsonPlatforms {

	/**
	 * Facebook platform
	 */
	private JsonPlatform facebook;

	/**
	 * Instagram platform
	 */
	private JsonPlatform instagram;

	/**
	 * Google platform
	 */
	private JsonPlatform google;

	public JsonPlatform getFacebook() {
		return facebook;
	}

	public void setFacebook(JsonPlatform facebook) {
		this.facebook = facebook;
	}

	public JsonPlatform getInstagram() {
		return instagram;
	}

	public void setInstagram(JsonPlatform instagram) {
		this.instagram = instagram;
	}

	public JsonPlatform getGoogle() {
		return google;
	}

	public void setGoogle(JsonPlatform google) {
		this.google = google;
	}

}
