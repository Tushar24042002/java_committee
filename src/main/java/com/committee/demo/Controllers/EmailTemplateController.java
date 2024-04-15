package com.committee.demo.Controllers;

import com.committee.demo.Entity.EmailTemplate.EmailTemplate;
import com.committee.demo.Service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/emailtemplate")
public class EmailTemplateController {

    @Autowired
    EmailTemplateService emailTemplateService;

    public Optional<EmailTemplate> getTemplateById(Long id){
        Optional<EmailTemplate> emailTemplate = emailTemplateService.getTemplateById(id);
return  emailTemplate;
    }

}
