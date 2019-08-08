package com.validation.validate;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;

public class EditTextEmptylValidator extends EditTextValidator<TextInputLayout> {


    private static final String TAG = "EditTextEmailValidator";

    public EditTextEmptylValidator(TextInputLayout editText, int errorMessageId) {
        super(editText, errorMessageId);
    }

    @Override
    public boolean isValid() {

        boolean isValid = !TextUtils.isEmpty(getText());

        enableError(!isValid);

        return isValid;
    }


}
