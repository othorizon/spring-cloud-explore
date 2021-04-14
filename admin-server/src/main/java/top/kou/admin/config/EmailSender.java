package top.kou.admin.config;

import com.google.gson.Gson;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Created by Rizon on 2018/4/18.
 */
//@Component
public class EmailSender implements MailSender {
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

    @Value("${mail.server.url}")
    private String EMAIL_SERVER_URL;

    @Override
    public void send(SimpleMailMessage simpleMailMessage){
        this.send(new SimpleMailMessage[]{simpleMailMessage});
    }

    @Override
    public void send(SimpleMailMessage... simpleMailMessages){
        for (SimpleMailMessage simpleMailMessage : simpleMailMessages) {
            String to = StringUtils.join(simpleMailMessage.getTo(), ",");
            String cc = StringUtils.join(simpleMailMessage.getCc(), ",");
            String subject = simpleMailMessage.getSubject();
            String body = simpleMailMessage.getText();
            doSend(to, cc, subject, body);
        }
    }

    public void doSend(String receiver, String ccAddress, String subject, String body) {
        Email email = new Email(receiver, ccAddress, subject, body);
        LOGGER.info(String.format("Send-Email-Request: [url=%s, to=%s, subject=%s, body=%s]", EMAIL_SERVER_URL,
                email.receiver, email.subject, email.body));
        HttpRequest request = HttpRequest.post(EMAIL_SERVER_URL).multipart(true);

        HttpResponse response = request
                .form("sendEmailInfo", new Gson().toJson(email)).timeout(5000).send();
        LOGGER.info(String.format("Send-Email-Response: [response=%s]", response.bodyText()));
    }

    public static class Email {
        private String receiver;   //多收件人逗号分隔
        private String ccAddress;
        private String subject;
        private String body;

        public Email(String receiver, String ccAddress, String subject, String body) {
            this.receiver = receiver;
            this.ccAddress = ccAddress;
            this.subject = subject;
            this.body = body;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getCcAddress() {
            return ccAddress;
        }

        public void setCcAddress(String ccAddress) {
            this.ccAddress = ccAddress;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}
