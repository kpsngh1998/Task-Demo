package com.project.server.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class UserMessageId implements Serializable {
	private static final long serialVersionUID = 1L;
	private String messageId;
	private String userId;
	
	public UserMessageId(String userId2, String messageId2) {
		this.messageId = messageId2;
		this.userId = userId2;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(messageId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMessageId other = (UserMessageId) obj;
		return Objects.equals(messageId, other.messageId) && Objects.equals(userId, other.userId);
	}
	
}
