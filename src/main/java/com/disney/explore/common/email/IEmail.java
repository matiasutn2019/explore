package com.disney.explore.common.email;

public interface IEmail {

    String getEmailTo();

    String getSubject();

    IContent getContent();

}
