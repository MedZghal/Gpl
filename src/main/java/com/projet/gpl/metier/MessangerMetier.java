/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Chatmsg;
import com.projet.gpl.entites.chatMessage;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

/**
 *
 * @author ProSYS
 */
public interface MessangerMetier {
    void notify(Chatmsg notification, String username);
    void chatSend(Chatmsg notification, String username);
    public void chatRecive(Chatmsg notification, String username);
    chatMessage addUser(@Payload chatMessage chatMessage,SimpMessageHeaderAccessor headerAccessor);
    chatMessage sendMessage(@Payload chatMessage chatMessage);
}
