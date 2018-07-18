package com.nanocorp.bean.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

	@OneToOne(mappedBy="targetAudience")
	@PrimaryKeyJoinColumn
	private Platform platform;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "NC_TARGET_LANGUAGE", joinColumns = { @JoinColumn(name = "TA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "L_ID") })
	private Set<Language> languages = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "NC_TARGET_GENDER", joinColumns = { @JoinColumn(name = "TA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "G_ID") })
	private Set<Gender> genders = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "NC_TARGET_LOCATION", joinColumns = { @JoinColumn(name = "TA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "L_ID") })
	private Set<Location> locations = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "NC_TARGET_INTEREST", joinColumns = { @JoinColumn(name = "TA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "I_ID") })
	private Set<Interest> interests = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "NC_TARGET_KEYWORD", joinColumns = { @JoinColumn(name = "TA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "K_ID") })
	private Set<Keyword> keywords = new HashSet<>();

	@Column(name = "TA_AGE_MIN")
	private int ageMin;

	@Column(name = "TA_AGE_MAX")
	private int ageMax;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
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

	public Set<Gender> getGenders() {
		return genders;
	}

	public void setGenders(Set<Gender> genders) {
		this.genders = genders;
	}

	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	public Set<Interest> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}
}
