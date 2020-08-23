package org.websparrow.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.websparrow.dto.MessageResponse;
import org.websparrow.dto.SmsPushRequest;

/**
 * @author chandra khadka
 * @since 2020-08-23
 */
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Override
    public MessageResponse pushSmsMessage(SmsPushRequest request) {
        log.info("Sms push request received. Mobile number: {}, message: {}", request.getMobileNumber(), request.getMessage());
        return null;
    }
}
