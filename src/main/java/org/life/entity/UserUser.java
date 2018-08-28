package org.life.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.UniqueConstraint;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_USER",uniqueConstraints=
@UniqueConstraint(columnNames = {"USER_ID", "ADDED_USER_ID","DOMAIN_ID"}))
public class UserUser {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "ADDED_USER_ID")
	private long addedUserId;

	@Column(name = "DOMAIN_ID")
	private long domainId;

	@Column(name = "MENTOR")
	private boolean isMentor;

	@Column(name = "MENTEE")
	private boolean isMentee;

	@Column(name = "MENTOR_REQUESTED")
	private boolean mentorRequested;

	public boolean isMentorRequested() {
		return mentorRequested;
	}

	public void setMentorRequested(boolean mentorRequested) {
		this.mentorRequested = mentorRequested;
	}

	public boolean isMenteeRequested() {
		return menteeRequested;
	}

	public void setMenteeRequested(boolean menteeRequested) {
		this.menteeRequested = menteeRequested;
	}

	public boolean isAllow() {
		return allow;
	}

	public void setAllow(boolean allow) {
		this.allow = allow;
	}

	public boolean isReject() {
		return reject;
	}

	public void setReject(boolean reject) {
		this.reject = reject;
	}

	@Column(name = "MENTEE_REQUESTED")
	private boolean menteeRequested;

	@Column(name = "ALLOW")
	private boolean allow;

	@Column(name = "REJECT")
	private boolean reject;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "ADDED_USER_ID", referencedColumnName = "ID")
	private User addedUser;

	public User getAddedUser() {
		return addedUser;
	}

	public void setAddedUser(User addedUser) {
		this.addedUser = addedUser;
	}

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

	public long getAddedUserId() {
		return addedUserId;
	}

	public void setAddedUserId(long addedUserId) {
		this.addedUserId = addedUserId;
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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userUser")
	@JoinColumn(name = "ID", referencedColumnName = "UUID")
	private List<QandA> qAndAs;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userUser")
	@JoinColumn(name = "ID", referencedColumnName = "UUID")
	private List<MenteeFeedback> mFeedbacks;

	public List<QandA> getqAndAs() {
		return qAndAs;
	}

	public void setqAndAs(List<QandA> qAndAs) {
		this.qAndAs = qAndAs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addQandA(String question) {
		QandA qAndA = new QandA();
		qAndA.setQuestion(question);
		qAndA.setCreatedDate(new Date());
		qAndA.setUuid(this.id);
		if (this.qAndAs == null) {
			this.qAndAs = new ArrayList<>();
		}
		this.qAndAs.add(qAndA);

	}

	public void addMFeedBack(String feedback) {
		MenteeFeedback mFeeedback = new MenteeFeedback();
		mFeeedback.setFeedback(feedback);
		mFeeedback.setCreatedDate(new Date());
		mFeeedback.setUuid(this.id);
		if (this.mFeedbacks == null) {
			this.mFeedbacks = new ArrayList<>();
		}
		this.mFeedbacks.add(mFeeedback);

	}
}