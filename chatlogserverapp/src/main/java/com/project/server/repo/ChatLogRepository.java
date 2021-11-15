package com.project.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.server.model.ChatLog;
import com.project.server.model.UserMessageId;

@Repository
public interface ChatLogRepository extends CrudRepository< ChatLog , UserMessageId >{
	
	public List<ChatLog> findByIdUserId(String userId);
	public void deleteAllByIdUserId(String userId);
	
}
