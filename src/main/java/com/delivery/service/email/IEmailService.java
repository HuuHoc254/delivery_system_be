package com.delivery.service.email;

import org.springframework.mail.MailException;

public interface IEmailService {
    void sendEmail(String to, String subject, String text) throws MailException;
}
