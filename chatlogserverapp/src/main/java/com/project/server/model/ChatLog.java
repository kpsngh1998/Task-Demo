package com.project.server.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chatlog")
public class ChatLog {
	
	@EmbeddedId
	private UserMessageId userMessageId;
	private String message;
	private Long timestamp;
	private boolean isSent;
	
	public ChatLog() {
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isSent() {
		return isSent;
	}
	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}
	public UserMessageId getUserMessageId() {
		return userMessageId;
	}
	public void setUserMessageId(UserMessageId userMessageId) {
		this.userMessageId = userMessageId;
	}

	@Override
	public String toString() {
		return "ChatLog [message=" + message + ", timestamp=" + timestamp + ", isSent=" + isSent +  ", userMessageId=" + userMessageId + "]";
	}



	
}
