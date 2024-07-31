package com.ngmartinezs.wsmscuentaappjava.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class MessageDTO {

     private Header header;

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Header {
        private String messageId;
        private String timestamp;
        private String correlationId;
        private String type;
        private String source;
        private String contentType;
        private String priority;
        private String expiration;
        private String traceId;
}
}
