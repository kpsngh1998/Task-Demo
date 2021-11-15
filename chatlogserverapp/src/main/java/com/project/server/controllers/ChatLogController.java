package com.project.server.controllers;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.server.model.ChatLog;
import com.project.server.service.ChatLogService;

@Controller
@RequestMapping({"/chatlogs"})
public class ChatLogController {

	@Autowired
	private ChatLogService chatLogService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/{user}")
	public ResponseEntity<String> createChatLog(@PathVariable("user") String user, @RequestBody ChatLog chatLog) {
		try {
			String response = chatLogService.createChatLog(chatLog, user);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Request Failed", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{user}")
	public ResponseEntity<List<ChatLog>> getChatLogs(@PathVariable("user") String user, 
									@RequestParam(value="limit", required = false) Integer limit,
									@RequestParam(value="start", required = false) String messageId){
		try {
			List<ChatLog> result = chatLogService.findUserChatLogs(user, limit, messageId);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{user}")
	public ResponseEntity<String> deleteAllChatLogs(@PathVariable("id") String user) {
		try {
			chatLogService.deleteAllUser(user);
			return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Request Failed, messageId not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{user}/{messageId}")
	public ResponseEntity<String> deleteByUserMessageId(@PathVariable("user") String user, @PathVariable("messageId") String messageId) {
		try {
			chatLogService.deleteAllByUserMessageId(user, messageId);
			return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Request Failed, messageId not found", HttpStatus.NOT_FOUND);
		}
		
	}
}
