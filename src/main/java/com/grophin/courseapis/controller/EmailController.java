package com.grophin.courseapis.controller;

import com.grophin.courseapis.dto.request.EmailRequest;
import com.grophin.courseapis.dto.response.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/email")
public class EmailController {

    @Autowired
    EmailInterface emailInterface;

    @PostMapping(
            path = "/send",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<EmailResponse> sendEmail(@Valid @RequestBody EmailRequest emailRequest) throws Exception{
        return new ResponseEntity<>(emailInterface.sendEmail(emailRequest), HttpStatus.OK);
    }

}
