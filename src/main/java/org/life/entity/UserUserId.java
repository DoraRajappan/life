package org.life.entity;

import java.io.Serializable;

public class UserUserId implements Serializable {

	private long userId;
	private long addedUserId;
	private long domainId;

	public UserUserId(long userId, long addedUserId, long domainId) {

		this.userId = userId;
		this.addedUserId = addedUserId;
		this.domainId = domainId;
	}

	public int hashCode() {
		return (int) (userId + domainId);
	}

	public boolean equals(Object object) {
		if (object instanceof UserUserId) {
			UserUserId otherId = (UserUserId) object;
			return (otherId.userId == this.userId)
					&& (otherId.addedUserId == this.addedUserId)
					&& (otherId.domainId == this.domainId);
		}
		return false;
	}

}
