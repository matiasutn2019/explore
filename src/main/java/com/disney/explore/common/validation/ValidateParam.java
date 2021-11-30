package com.disney.explore.common.validation;

public class ValidateParam {

    private ValidateParam() {}

    public static Boolean validate(int num, int min, int max) {
        return num < min && num > max;
    }

}
