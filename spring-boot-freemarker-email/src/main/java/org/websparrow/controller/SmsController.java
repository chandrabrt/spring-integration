package org.websparrow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.websparrow.dto.MessageResponse;
import org.websparrow.dto.SmsPushRequest;
import org.websparrow.service.SmsService;

/**
 * @author chandra khadka
 * @since 2020-08-23
 */
@RestController("/api/ns/")
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/sms" , produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageResponse smsRequest(@RequestBody SmsPushRequest request) {
        return smsService.pushSmsMessage(request);
    }
}
