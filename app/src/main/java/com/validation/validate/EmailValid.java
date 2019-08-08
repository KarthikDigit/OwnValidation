package com.validation.validate;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;

public class EmailValid extends EditTextValidatorTest<TextInputLayout> {


    public EmailValid(TextInputLayout view, String errorMessage) {
        super(view, errorMessage);
    }


    @Override
    public boolean validate() {
        return !TextUtils.isEmpty(getText()) && Patterns.EMAIL_ADDRESS.matcher(getText()).matches();
    }

    @Override
    public void showError(String s) {

    }


}
