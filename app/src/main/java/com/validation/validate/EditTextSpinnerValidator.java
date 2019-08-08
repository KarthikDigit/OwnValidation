package com.validation.validate;


import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;

public class EditTextSpinnerValidator extends EditTextValidator<TextInputLayout> {


    public EditTextSpinnerValidator(TextInputLayout editText, int errorMessageId) {
        super(editText, errorMessageId);
    }

    @Override
    public boolean isValid() {

        boolean isValid = !TextUtils.isEmpty(getText());

        enableError(!isValid);

        return isValid;
    }


}
