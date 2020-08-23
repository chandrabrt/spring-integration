package org.websparrow.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chandra khadka
 * @since 2020-08-23
 */
@Data
public class MessageResponse implements Serializable {

    public static final String SUCCESS = "Success";
    private String message;
    private String referenceId;

    public MessageResponse(String message) {
        this.message = message;
    }
    public MessageResponse() {
    }
}