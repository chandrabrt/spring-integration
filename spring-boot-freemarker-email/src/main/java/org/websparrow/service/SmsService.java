package org.websparrow.service;

import org.websparrow.dto.MessageResponse;
import org.websparrow.dto.SmsPushRequest;

/**
 * @author chandra khadka
 * @since 2020-08-23
 */
public interface SmsService {

    MessageResponse pushSmsMessage(SmsPushRequest request);
}
