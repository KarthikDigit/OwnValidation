package com.validation.validate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    private List<Validator> validatorList = new ArrayList<>();


    public void addValidator(Validator editTextValidator) {

        this.validatorList.add(editTextValidator);
    }


    public boolean validate() {

        Set<Boolean> flags = new HashSet<Boolean>(validatorList.size());


        for (Validator editTextValidator : validatorList
                ) {
            flags.add(editTextValidator.isValid());
        }

        return !flags.contains(false);

    }


}
