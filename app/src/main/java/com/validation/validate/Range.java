package com.validation.validate;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;

public class Range extends EditTextValidatorTest<TextInputLayout> {


    public Range(TextInputLayout view, String errorMessage) {
        super(view, errorMessage);
    }


    @Override
    public boolean validate() {
        return !TextUtils.isEmpty(getText()) && Integer.valueOf(getText()) > 400;
    }




}
