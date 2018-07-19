package com.nanocorp.bean.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Read JSON data for target audience
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonTargetAudience {

	private List<String> languages;
	private List<String> genders;
	private List<Integer> age_range;
	private List<String> locations;
	private List<String> interests;
	private List<String> keyWords;

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}

	public List<Integer> getAge_range() {
		return age_range;
	}

	public void setAge_range(List<Integer> age_range) {
		this.age_range = age_range;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public List<String> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<String> keyWords) {
		this.keyWords = keyWords;
	}
}
