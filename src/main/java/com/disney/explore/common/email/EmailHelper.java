package com.disney.explore.common.email;

import com.disney.explore.exception.SendEmailException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class EmailHelper {

    private static final String SEND_ENDPOINT = "mail/send";

    private static final String EMAIL_FROM = "foo";

    public void sendMail(IEmail emailBody) throws SendEmailException {
        Email from = new Email(EMAIL_FROM);
        String subject = emailBody.getSubject();
        Email to = new Email(emailBody.getEmailTo());
        Content content =
            new Content(emailBody.getContent().getType(), emailBody.getContent().getValue());
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint(SEND_ENDPOINT);
            request.setBody(mail.build());
            Response response = sendGrid.api(request);

            if (!(response.getStatusCode() >= 200 || response.getStatusCode() < 300)) {
                throw new SendEmailException("The email has not sent");
            }

        } catch (IOException e) {
          throw new SendEmailException(e.getMessage());
        }
    }

}
