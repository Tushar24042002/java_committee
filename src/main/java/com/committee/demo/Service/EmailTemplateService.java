package com.committee.demo.Service;

import com.committee.demo.Entity.EmailTemplate.EmailTemplate;
import com.committee.demo.Repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailTemplateService {
    @Autowired
    EmailTemplateRepository emailTemplateRepository;


    public Optional<EmailTemplate> getTemplateById(Long id) {
        return emailTemplateRepository.findById(id);
    }
}
