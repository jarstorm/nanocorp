package com.nanocorp.bean.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to transform from DB object to DTO target audience
 */
public class TargetAudienceDto {
	private long id;

	private int ageMin;

	private int ageMax;

	private Set<String> languages = new HashSet<>();

	private Set<String> genders = new HashSet<>();

	private Set<String> locations = new HashSet<>();

	private Set<String> interests = new HashSet<>();

	private Set<String> keywords = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}

	public int getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(int ageMax) {
		this.ageMax = ageMax;
	}

	public Set<String> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<String> languages) {
		this.languages = languages;
	}

	public Set<String> getGenders() {
		return genders;
	}

	public void setGenders(Set<String> genders) {
		this.genders = genders;
	}

	public Set<String> getLocations() {
		return locations;
	}

	public void setLocations(Set<String> locations) {
		this.locations = locations;
	}

	public Set<String> getInterests() {
		return interests;
	}

	public void setInterests(Set<String> interests) {
		this.interests = interests;
	}

	public Set<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}

}
