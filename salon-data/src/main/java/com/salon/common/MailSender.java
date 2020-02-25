package com.salon.common;

import com.salon.domain.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {

    private JavaMailSender mailSender;

    private RegistrationLink registrationLink;
    private MessageSource messageSource;

    @Value("${spring.mail.username}")
    private String username;

    public MailSender(JavaMailSender mailSender
            , RegistrationLink registrationLink, MessageSource messageSource) {
        this.mailSender = mailSender;

        this.registrationLink=registrationLink;
        this.messageSource=messageSource;
    }

    public void send(String emailTo,String subject,String message){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }


    public void sendEmailActivation(String email,String activateCode,String firstName) {

        if (verifyEmail(email)) {
            String link = getStringLink() + activateCode;

            String[] params = new String[]{firstName, link};
            String messageLink = messageSource.getMessage("registration.user.emaillink"
                    , params, LocaleContextHolder.getLocale());
            String messageSubject = messageSource.getMessage("registration.user.activationcode"
                    , null, LocaleContextHolder.getLocale());

             send(email, messageSubject, messageLink);
        }
    }

    public void sendEmailSuccessRegistation(String email ){
        if (verifyEmail(email)){
            String messageLink = messageSource.getMessage("registration.user.success"
                    , null, LocaleContextHolder.getLocale());
            String messageSubject = messageSource.getMessage("registration.user.done"
                    , null, LocaleContextHolder.getLocale());

            send(email, messageSubject, messageLink);
        }
    }

    private boolean verifyEmail(String email){
        if(email != null && !email.isEmpty() && !email.equals("")){
            return true;
        }
        return false;
    }

    private String getStringLink(){
        return registrationLink.getAppHost()
                + registrationLink.getAppName()
                + registrationLink.getAppActivatePath();
    }


}
