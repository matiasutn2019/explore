package com.disney.explore.common;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;

public class EmailHelper {

  public void sendMail(IEmail emailBody) throws IOException {
    Email from = new Email("matiasceviniydejesus@gmail.com");
    String subject = emailBody.getSubject();
    Email to = new Email(emailBody.getEmailTo());
    Content content =
        new Content(emailBody.getContent().getType(), emailBody.getContent().getValue());
    Mail mail = new Mail(from, subject, to, content);
    SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();

    try {
      request.setMethod(Method.POST);
      request.setEndpoint("/mail/send");
      request.setBody(mail.build());
      Response response = sendGrid.api(request);

      if (!(response.getStatusCode() >= 200 || response.getStatusCode() < 300)) {
        throw new IOException("The email has not sent");
      }
      
    } catch (IOException e) {
      throw new IOException(e.getMessage(), e);
    }
  }

}
