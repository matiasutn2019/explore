package com.disney.explore.common.email.template;

import com.disney.explore.common.email.IContent;
import com.disney.explore.common.email.IEmail;

public class RegisterTemplateEmail implements IEmail, IContent {

    private static final String TYPE = "text/plain";
    private static final String SUBJECT = "Register Successfully";
    private static final String WELCOME_TEXT = "Welcome to Disney!";

    private String emailTo;

  public RegisterTemplateEmail(String emailTo) {
    this.emailTo = emailTo;
  }

  @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getValue() {
        return WELCOME_TEXT;
    }

    @Override
    public String getEmailTo() {
        return emailTo;
    }

    @Override
    public String getSubject() {
        return SUBJECT;
    }

    @Override
    public IContent getContent() {
        return this;
    }
}
