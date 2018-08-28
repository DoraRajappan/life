package org.life.dto;

public class UserRelation {

	private long userId;
	private String afirstName;
	private String photoURL;

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public String getAfirstName() {
		return afirstName;
	}

	private String countryCode;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	private String zipCode;

	public void setAfirstName(String afirstName) {
		this.afirstName = afirstName;
	}

	public String getaLastName() {
		return aLastName;
	}

	public void setaLastName(String aLastName) {
		this.aLastName = aLastName;
	}

	private String aLastName;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAddedUserId() {
		return addedUserId;
	}

	public void setAddedUserId(long addedUserId) {
		this.addedUserId = addedUserId;
	}

	public long getDomainId() {
		return domainId;
	}

	public void setDomainId(long domainId) {
		this.domainId = domainId;
	}

	public boolean isMentor() {
		return isMentor;
	}

	public void setMentor(boolean isMentor) {
		this.isMentor = isMentor;
	}

	public boolean isMentee() {
		return isMentee;
	}

	public void setMentee(boolean isMentee) {
		this.isMentee = isMentee;
	}

	private long addedUserId;
	private long domainId;
	private boolean isMentor;
	private boolean isMentee;
}
