package org.websparrow.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.websparrow.dto.EmailDTO;
import org.websparrow.dto.EmailResponse;
import org.websparrow.enums.ResponseCode;
import org.websparrow.utils.PropertyNames;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

	private final JavaMailSender mailSender;
	private final FreeMarkerConfigurer freemarkerConfig;

	public EmailServiceImpl(JavaMailSender mailSender, FreeMarkerConfigurer freemarkerConfig) {
		this.mailSender = mailSender;
		this.freemarkerConfig = freemarkerConfig;
	}

	public EmailResponse sendEmail(EmailDTO emailDTO) {
		log.info("##### Started sending email ####");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			emailDTO.getProperties().put(PropertyNames.TEMPLATE_NAME, "/email/user_transaction_notification_en.ftl");

			String templateContent = FreeMarkerTemplateUtils
					.processTemplateIntoString(freemarkerConfig.getConfiguration()
							.getTemplate("/email/email_template.ftl"),
							emailDTO.getProperties());

			helper.setTo(emailDTO.getReceiver());
			helper.setSubject(emailDTO.getSubject());
			helper.setText(templateContent, true);
			mailSender.send(mimeMessage);
			log.info("######## email sent ######");
		} catch (Exception e) {
			System.out.println("Sending email failed, check log...");
			e.printStackTrace();
		}
		return new EmailResponse(ResponseCode.COMPLETE, "Email send successfully");
	}
}
