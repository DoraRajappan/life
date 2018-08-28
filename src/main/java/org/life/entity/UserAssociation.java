package org.life.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_DOMAIN",uniqueConstraints=
@UniqueConstraint(columnNames = {"USER_ID", "DOMAIN_ID","IS_MENTOR","IS_MENTEE"}))
@IdClass(UserAssociationId.class)
public class UserAssociation {
	@Id
	@Column(name = "USER_ID")
	private long userId;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Id
	@Column(name = "DOMAIN_ID")
	private long domainId;

	@Column(name = "IS_MENTOR")
	private boolean isMentor;

	@Column(name = "IS_MENTEE")
	private boolean isMentee;

	@Column(name = "SUMMARY")
	private String summary;

	@Column(name = "WEB_SITE")
	private String website;

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "DOMAIN_ID", referencedColumnName = "ID")
	private Domain domain;

	@OneToMany(orphanRemoval = true, mappedBy = "userAssociation", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@OrderBy("createdDate DESC")
	@JoinColumns({
			@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
			@JoinColumn(name = "DOMAIN_ID", referencedColumnName = "DOMAIN_ID"), })
	private List<MentorUpdates> mentorUpdates;

	public void addMentorUpdate(String update, String uploadURL,
			String externalLink) {
		MentorUpdates mentorUpdates = new MentorUpdates();
		mentorUpdates.setUserAssociation(this);
		mentorUpdates.setUpdate(update);
		mentorUpdates.setUploadURL(uploadURL);
		mentorUpdates.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		mentorUpdates.setDomainId(this.domainId);
		mentorUpdates.setUserId(this.userId);
		mentorUpdates.setExternalLink(externalLink);
		if (this.mentorUpdates == null) {
			this.mentorUpdates = new ArrayList<>();
		}
		this.mentorUpdates.add(mentorUpdates);
		// Also add the association object to the employee.

	}

	public List<MentorUpdates> getMentorUpdates() {
		return mentorUpdates;
	}

	public void setMentorUpdates(List<MentorUpdates> mentorUpdates) {
		this.mentorUpdates = mentorUpdates;
	}

}
