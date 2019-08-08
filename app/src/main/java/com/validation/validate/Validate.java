package com.validation.validate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    private List<Validator> validatorList = new ArrayList<>();
    private ValidationErrorListener errorListener;

    public Validate(ValidationErrorListener errorListener) {

        this.errorListener = errorListener;
    }

    public void addValidator(Validator editTextValidator) {

        this.validatorList.add(editTextValidator);
    }


    public boolean validate() {

        Set<Boolean> flags = new HashSet<Boolean>(validatorList.size());

        List<Validator> validates = new ArrayList<>();

        for (Validator editTextValidator : validatorList
                ) {
            editTextValidator.hideError();

            boolean b = editTextValidator.validate();

            if (!b) validates.add(editTextValidator);

            flags.add(b);
        }


        if (errorListener != null && flags.contains(false)) {

            errorListener.onError(validates);
        }

        return !flags.contains(false);

    }


    public interface ValidationErrorListener {

        void onError(List<Validator> validates);

    }

}
