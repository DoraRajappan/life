package org.life.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LOGIN")
public class Login {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "LOGGED_IN")
	// toggle this for something to work, for junit
	@Temporal(TemporalType.TIMESTAMP)
	private Date loggedInDate;
	@Column(name = "LOGGED_OUT")
	// toggle this for something to work, for junit
	@Temporal(TemporalType.TIMESTAMP)
	private Date loggedOutDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getLoggedInDate() {
		return loggedInDate;
	}

	public void setLoggedInDate(Date loggedInDate) {
		this.loggedInDate = loggedInDate;
	}

	public Date getLoggedOutDate() {
		return loggedOutDate;
	}

	public void setLoggedOutDate(Date loggedOutDate) {
		this.loggedOutDate = loggedOutDate;
	}

}
