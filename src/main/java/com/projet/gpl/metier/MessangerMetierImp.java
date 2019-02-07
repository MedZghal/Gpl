/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Chatmsg;
import com.projet.gpl.entites.chatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class MessangerMetierImp implements MessangerMetier{
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
 
    
    @Override
    public void notify(Chatmsg notification, String username) {
        messagingTemplate.convertAndSendToUser(
          username, 
          "/queue/notify", 
          notification
        );
        return;
    }
  
   
    @Override
    public void chatSend(Chatmsg notification, String username) {
      messagingTemplate.convertAndSendToUser(
        username, 
        "/queue/chatSend", 
        notification
      );
      return;
    }
  
   
    @Override
    public void chatRecive(Chatmsg notification, String username) {
     messagingTemplate.convertAndSendToUser(
       username, 
       "/queue/chatRecive", 
       notification
     );
     return;
   }
    
    @Override
    public chatMessage addUser(@Payload chatMessage chatMessage, 
                             SimpMessageHeaderAccessor headerAccessor) {
      // Add username in web socket session
      headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
      return chatMessage;
    }
    
    @Override
    public chatMessage sendMessage(@Payload chatMessage chatMessage) {
        return chatMessage;
    }
}
