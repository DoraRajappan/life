package org.life.dto;

import java.util.Date;

public class Feedback {
	private long id;
	private long uuId;
	private Date createdDate;
	private long domainId;
	private String feedback;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUuId() {
		return uuId;
	}

	public void setUuId(long uuId) {
		this.uuId = uuId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getDomainId() {
		return domainId;
	}

	public void setDomainId(long domainId) {
		this.domainId = domainId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
