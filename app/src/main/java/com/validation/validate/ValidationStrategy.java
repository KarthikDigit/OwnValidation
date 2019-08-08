package com.validation.validate;

import android.text.TextUtils;
import android.util.Patterns;

public enum ValidationStrategy {


    EMAIL() {
        public boolean validate(String s) {

            return !TextUtils.isEmpty(s) && Patterns.EMAIL_ADDRESS.matcher(s).matches();
        }
    }


}
