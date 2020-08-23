package org.websparrow.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author chandra khadka
 * @since 2020-08-23
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsPushRequest {

    private Long appId;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    private String message;

    private Integer moduleId;
}