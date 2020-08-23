package org.websparrow.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.websparrow.enums.ResponseCode;

import java.io.Serializable;

/**
 * @author chandra khadka
 * @since 2020-08-22
 */
@Getter
@JsonPropertyOrder(value = {"code", "message"})
public class EmailResponse implements Serializable {

    private final ResponseCode code;
    private final String message;

    public EmailResponse(ResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
