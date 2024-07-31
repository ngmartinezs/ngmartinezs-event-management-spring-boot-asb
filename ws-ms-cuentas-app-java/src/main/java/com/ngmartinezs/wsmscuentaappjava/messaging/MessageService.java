package com.ngmartinezs.wsmscuentaappjava.messaging;

import com.ngmartinezs.wsmscuentaappjava.dto.message.MessageDTO;

public interface MessageService {

    public void sendMessage(MessageDTO messageDto);

    public void startMessageListener();

    public void stopMessageListener();

}
