package com.validation.validate;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

public class EmptyValidation extends EditTextValidatorTest<TextInputLayout> {

    private ValidationStrategy validationStrategy;

    public EmptyValidation(final TextInputLayout view, final String errorMessage, ValidationStrategy validationStrategy) {
        super(view, errorMessage);

        this.validationStrategy = validationStrategy;

        if (view.getEditText() != null) {

            view.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (s.length() >= 0) {
                        if (validate()) hideError();
                        else showError(getErrorMessage());
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

//                view.setErrorEnabled(false);
//                view.setError(null);

                }
            });
        }
    }

    @Override
    public boolean validate() {
        return validationStrategy.validate(getText());
    }
}
