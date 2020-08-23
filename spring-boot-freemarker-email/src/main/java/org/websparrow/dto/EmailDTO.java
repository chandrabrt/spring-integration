package org.websparrow.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import java.util.Map;

@Data
public class EmailDTO {
	@Email
	private String receiver;

	private String subject;

	private Map<String, Object> properties;

	private String attachment;
}
