package org.life.entity;

import java.io.Serializable;
import java.util.Date;

public class MentorUpdatesId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long userId;

	private long domainId;

	private Date createdDate;

	public int hashCode() {
		return (int) (userId + domainId + createdDate.hashCode());
	}

	public boolean equals(Object object) {
		if (object instanceof UserAssociationId) {
			MentorUpdatesId otherId = (MentorUpdatesId) object;
			return (otherId.userId == this.userId)
					&& (otherId.domainId == this.domainId)
					&& otherId.createdDate == this.createdDate;
		}
		return false;
	}
}
