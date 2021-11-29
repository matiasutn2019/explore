package com.disney.explore.common.email;

import com.disney.explore.common.email.IContent;

public interface IEmail {

  String getEmailTo();

  String getSubject();

  IContent getContent();

}
