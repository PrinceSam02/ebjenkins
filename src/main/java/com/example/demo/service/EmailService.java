package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String role, String password) {
        String subject = "Welcome to the Company!";
        String text = String.format(
            "You have been enrolled as a %s.\n" +
            "Your email ID is %s.\n" +
            "Your password is %s.\n" +
            "Kindly login with this password and change it after your first login.",
            role, to, password
        );

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }
    
    public void sendDepositRequestEmail(String toEmail, String customerName, String meterNumber, String depositAmount) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sofisam02@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Connection Request Update – Meter Number Assigned");

        String body = String.format(
            "Dear %s,%n%n"
            + "We are pleased to inform you that your connection request has been processed successfully. Below are the details of your meter assignment:%n%n"
            + "Meter Number: %s%n%n"
            + "To proceed further, we kindly request you to make a deposit of %s as soon as possible to finalize your connection.%n%n"
            + "You can make the payment through any of our approved payment methods. Once the deposit is received, we will proceed with the next steps in the connection process.%n%n"
            + "If you have any questions or need further assistance, please feel free to contact us.%n%n"
            + "Thank you for choosing our services.%n%n"
            + "Best regards,%n"
            + "TNEB",
            customerName, meterNumber, depositAmount
        );

        message.setText(body);
        javaMailSender.send(message);
    }
}
