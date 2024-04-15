package com.committee.demo.Service;

import com.committee.demo.Entity.Email.Email;
import com.committee.demo.Repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailRepository emailRepository;

    public void sendEmail(Email email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email.getToEmail());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getMessage());

        javaMailSender.send(mailMessage);

//        emailRepository.save(email);
    }
}
