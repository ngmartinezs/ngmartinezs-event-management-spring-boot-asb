package com.ngmartinezs.wsregsolicitudclientejava.messaging;

import com.ngmartinezs.wsregsolicitudclientejava.dto.message.MessageDTO;

public interface MessageService {
    void sendMessage(MessageDTO messageDTO) throws Exception;
    void startMesssageListener();
    void stopMessageListener();
}
