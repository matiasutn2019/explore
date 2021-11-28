package com.disney.explore.common;

public enum RoleEnum {
    USER("USER");

    private static final String ROLE_PREFIX = "ROLE_";
    private final String name;

    RoleEnum(String name) {
    this.name = name;
  }

    public String getName() {
    return name;
  }

    public String getRoleName() {
    return ROLE_PREFIX + name;
  }
}
