package org.websparrow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.websparrow.dto.EmailDTO;
import org.websparrow.dto.EmailResponse;
import org.websparrow.service.EmailService;

/**
 * @author chandra khadka
 * @since 2020-08-22
 */
@RestController
@RequestMapping("/api/ns/")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/email")
    public EmailResponse sendEmail(@RequestBody EmailDTO emailDTO) {
        return emailService.sendEmail(emailDTO);
    }
}
