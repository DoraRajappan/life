package org.life.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MENTOR_UPDATES")
@IdClass(MentorUpdatesId.class)
public class MentorUpdates {
	@Id
	@Column(name = "USER_ID")
	private long userId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getDomainId() {
		return domainId;
	}

	public void setDomainId(long domainId) {
		this.domainId = domainId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public UserAssociation getUserAssociation() {
		return userAssociation;
	}

	public void setUserAssociation(UserAssociation userAssociation) {
		this.userAssociation = userAssociation;
	}

	@Id
	@Column(name = "DOMAIN_ID")
	private long domainId;

	@Id
	@Column(name = "CREATED_DATE")
	// toggle this for something to work, for junit
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "UPDATE")
	private String update;
	@Column(name = "UPLOAD_URL")
	private String uploadURL;

	@Column(name = "EXTERNAL_LINK ")
	private String externalLink;

	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}

	public String getUploadURL() {
		return uploadURL;
	}

	public void setUploadURL(String uploadURL) {
		this.uploadURL = uploadURL;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({
			@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false),
			@JoinColumn(name = "DOMAIN_ID", referencedColumnName = "DOMAIN_ID", insertable = false, updatable = false), })
	private UserAssociation userAssociation;
}
