package com.ngmartinezs.wsmsclientesappjava.messaging;

import com.ngmartinezs.wsmsclientesappjava.dto.message.MessageDTO;

public interface MessageService {

    public void sendMessage(MessageDTO messageDto);

    public void startMessageListener();

    public void stopMessageListener();

}
