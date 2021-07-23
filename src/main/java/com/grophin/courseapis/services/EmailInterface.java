package com.grophin.courseapis.services;

import com.grophin.courseapis.dto.request.EmailRequest;
import com.grophin.courseapis.dto.response.EmailResponse;

public interface EmailInterface {

    EmailResponse sendEmail(EmailRequest emailRequest) throws Exception;
}
