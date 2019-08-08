package com.validation.validate;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.CheckBox;

public class CheckBoxTrueValidator extends CheckBoxValidator<CheckBox> {


    private static final String TAG = "CheckBoxTrueValidator";

    public CheckBoxTrueValidator(CheckBox editText, int errorMessageId) {
        super(editText, errorMessageId);
    }

    @Override
    public boolean isValid() {

        boolean isValid = isChecked();

        enableError(!isValid);

        return isValid;
    }


}
