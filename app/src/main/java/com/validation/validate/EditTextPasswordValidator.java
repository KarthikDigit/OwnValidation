package com.validation.validate;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;

public class EditTextPasswordValidator extends EditTextValidator<TextInputLayout> {


    private static final String TAG = "EditTextPasswordValidator";

    private int min = 1;

    public EditTextPasswordValidator(TextInputLayout editText, int errorMessageId) {
        super(editText, errorMessageId);
    }

    public EditTextPasswordValidator(TextInputLayout editText, int min, int errorMessageId) {
        super(editText, errorMessageId);
        this.min = min;
    }


    @Override
    public boolean isValid() {

        boolean isValid = !TextUtils.isEmpty(getText()) && getText().length() >= min;

        enableError(!isValid);

        return isValid;
    }


}
