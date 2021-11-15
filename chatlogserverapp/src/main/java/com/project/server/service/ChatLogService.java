package com.project.server.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.server.model.ChatLog;
import com.project.server.model.UserMessageId;
import com.project.server.repo.ChatLogRepository;

@Service
public class ChatLogService {
	
	@Autowired
	private ChatLogRepository chatLogRepo;
	
	public String createChatLog(ChatLog chatLog, String userId) {
		String messageId = UUID.randomUUID().toString();
		UserMessageId userMessageId = new UserMessageId(userId, messageId);
		chatLog.setUserMessageId(userMessageId);
		ChatLog res = chatLogRepo.save(chatLog);
		return messageId;
	}
	
	public List<ChatLog> findUserChatLogs(String userId, Integer limit, String messageId) {
		List<ChatLog> chatLogs = chatLogRepo.findByIdUserId(userId);
		List<ChatLog> sortedLogs = chatLogs.stream().sorted((o1, o2) -> (Long.compare(o2.getTimestamp(), o1.getTimestamp())))
						 .collect(Collectors.toList());
		if( limit == null) {
			return sortedLogs.subList(0, 10);
		}else {
			return sortedLogs.subList(0, limit);
		}
	}
	public void deleteAllUser(String userId) {
		chatLogRepo.deleteAllByIdUserId(userId);
	}
	
	public void deleteAllByUserMessageId(String userId, String messageId) {
		chatLogRepo.deleteById(new UserMessageId(userId, messageId));
	}
	 
}
