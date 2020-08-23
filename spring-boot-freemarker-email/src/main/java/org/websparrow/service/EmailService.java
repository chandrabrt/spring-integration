package org.websparrow.service;

import org.websparrow.dto.EmailDTO;
import org.websparrow.dto.EmailResponse;

/**
 * @author chandra khadka
 * @since 2020-08-22
 */
public interface EmailService {

    EmailResponse sendEmail(EmailDTO emailDTO);
}
