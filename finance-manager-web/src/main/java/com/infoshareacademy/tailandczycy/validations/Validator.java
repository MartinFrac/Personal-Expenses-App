package com.infoshareacademy.tailandczycy.validations;

import javax.servlet.http.HttpServletRequest;

public interface Validator {

    boolean areFieldsCorrect(HttpServletRequest request);
}
