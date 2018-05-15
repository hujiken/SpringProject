package configuration.email;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan({"configuration"})
public class EmailConfig {
	
	@Bean
    public JavaMailSender getMailSender() {
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	
    	//using gmail
    	mailSender.setHost("smtp.gmail.com");
    	mailSender.setPort(587);
    	mailSender.setUsername("phamhuycntt@gmail.com");
    	mailSender.setPassword("snlnmmtbnmcch");
    	
    	Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");
         
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;

    }
}
