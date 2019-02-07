/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.chatMessage;
import com.projet.gpl.metier.MessangerMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
/**
 *
 * @author ProSYS
 */
@Controller
public class ChatController {
    
    @Autowired MessangerMetier messangerMetier;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public chatMessage sendMessage(@Payload chatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public chatMessage addUser(@Payload chatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        return messangerMetier.addUser(chatMessage, headerAccessor);
    }

}
