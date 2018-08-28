package org.life.entity;

import java.io.Serializable;

public class UserAssociationId implements Serializable {

	private long userId;

	private long domainId;

	public int hashCode() {
		return (int) (userId + domainId);
	}

	public boolean equals(Object object) {
		if (object instanceof UserAssociationId) {
			UserAssociationId otherId = (UserAssociationId) object;
			return (otherId.userId == this.userId)
					&& (otherId.domainId == this.domainId);
		}
		return false;
	}

}