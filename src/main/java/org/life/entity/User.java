package org.life.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "USER_ID", unique=true)
	private String userId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "SURNAME")
	private String surname;
	@Column(name = "DOB")
	// toggle this for junit
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "PHOTO_URL")
	private String photoUrl;

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

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

	@OneToMany(orphanRemoval = true, mappedBy = "user", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<UserUser> userUsers;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<UserAssociation> domains;

	public List<UserAssociation> getDomains() {
		return domains;
	}

	public void setDomains(List<UserAssociation> domains) {
		this.domains = domains;
	}

	public void removeUser(User user, Domain domain) {

		if (this.userUsers == null)
			this.userUsers = new ArrayList<>();
		for (UserUser tUserUser : userUsers) {
			if (tUserUser.getUserId() == this.getId()
					&& tUserUser.getAddedUserId() == user.getId()
					&& tUserUser.getDomainId() == domain.getId()) {
				this.userUsers.remove(tUserUser);
				break;
			}
		}
		
	}

	public void addUser(User user, Domain domain, boolean isMentor,
			boolean isMentee) {
		UserUser userUser = new UserUser();
		userUser.setUser(this); 
		userUser.setDomain(domain);
		userUser.setAddedUser(user);
		userUser.setUserId(this.getId());
		userUser.setAddedUserId(user.getId());
		userUser.setDomainId(domain.getId());
		userUser.setMentor(isMentor); 
		userUser.setMentee(isMentee);

		if (this.userUsers == null)
			this.userUsers = new ArrayList<>();

		this.userUsers.add(userUser);
		// Also add the association object to the employee.
		
	}

	public void addRequest(User user, Domain domain, boolean mentorRequested,
			boolean menteeRequested) {
		UserUser userUser = new UserUser();
		userUser.setUser(this); 
		userUser.setDomain(domain);
		userUser.setAddedUser(user);
		userUser.setUserId(this.getId());
		userUser.setAddedUserId(user.getId());
		userUser.setDomainId(domain.getId());
		userUser.setMentorRequested(mentorRequested); 
		userUser.setMenteeRequested(menteeRequested);

		if (this.userUsers == null)
			this.userUsers = new ArrayList<>();

		this.userUsers.add(userUser);
		
		
	}

	public List<UserUser> getUserUsers() {
		return userUsers;
	}

	public void setUserUsers(List<UserUser> userUsers) {
		this.userUsers = userUsers;
	}

	public void allowRequest(User user, Domain domain, boolean allow,
			boolean reject, boolean requestType) {
		UserUser userUser = new UserUser();
		userUser.setUser(this); 
		userUser.setDomain(domain);
		userUser.setAddedUser(user);
		userUser.setUserId(this.getId());
		userUser.setAddedUserId(user.getId());
		userUser.setDomainId(domain.getId());
		
		
		if (this.userUsers == null)
			this.userUsers = new ArrayList<>();

		this.userUsers.add(userUser);// employees.add(association);
		// Also add the association object to the employee.
		
	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + ", password=" + password + "]";
	}

}