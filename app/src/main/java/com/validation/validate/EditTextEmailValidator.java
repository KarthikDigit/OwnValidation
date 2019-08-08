package com.validation.validate;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

public class EditTextEmailValidator extends EditTextValidator<TextInputLayout> {


    private static final String TAG = "EditTextEmailValidator";

    public EditTextEmailValidator(TextInputLayout editText, int errorMessageId) {
        super(editText, errorMessageId);
    }

    @Override
    public boolean isValid() {

        boolean isValid = !TextUtils.isEmpty(getText()) && Patterns.EMAIL_ADDRESS.matcher(getText()).matches();

        enableError(!isValid);

        return isValid;
    }


}
