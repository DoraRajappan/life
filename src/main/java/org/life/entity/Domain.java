package org.life.entity;

import java.util.ArrayList;
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

@Entity
@Table(name = "DOMAIN")
public class Domain {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME",unique=true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "domain", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<UserAssociation> users;

	public List<UserAssociation> getUsers() {
		return users;
	}

	public void setUsers(List<UserAssociation> users) {
		this.users = users;
	}

	public void addUser(User user, boolean isMentor, boolean isMentee,
			String summary, String website, String photoUrl, String update) {
		List<UserAssociation> assocs = user.getDomains();
		List<MentorUpdates> mentorUpdates = null;
		if (assocs != null && !assocs.isEmpty()) {
			for (UserAssociation assoc : assocs) {
				if (assoc.getDomainId() == this.getId()
						&& assoc.getUserId() == user.getId()) {
					mentorUpdates = assoc.getMentorUpdates();
					break;
				}
			}
		}
		UserAssociation association = new UserAssociation();
		association.setUser(user);
		association.setDomain(this);
		association.setUserId(user.getId());
		association.setDomainId(this.getId());
		association.setMentor(isMentor);
		association.setMentee(isMentee);
		association.setSummary(summary);
		association.setWebsite(website);

		association.setMentorUpdates(mentorUpdates);

		if (this.users == null)
			this.users = new ArrayList<>();

		this.users.add(association);
		// Also add the association object to the employee.
		user.getDomains().add(association);
	}

	/**
	 * update User is towork out the updates not fully functional TODO
	 * 
	 * @param user
	 * @param isMentor
	 * @param isMentee
	 * @param summary
	 * @param website
	 * @param photoUrl
	 *            //will be taken out
	 * @param update
	 */
	public void updateUser(User user, boolean isMentor, boolean isMentee,
			String summary, String website, String photoUrl, String update) {
		UserAssociation association = new UserAssociation();
		association.setUser(user);
		association.setDomain(this);
		association.setUserId(user.getId());
		association.setDomainId(this.getId());
		association.setMentor(isMentor);
		association.setMentee(isMentee);
		association.setSummary(summary);
		association.setWebsite(website);

		association.addMentorUpdate(update, "", "");
		if (this.users == null)
			this.users = new ArrayList<>();

		this.users.add(association);
		// Also add the association object to the employee.
		user.getDomains().add(association);
	}

}
