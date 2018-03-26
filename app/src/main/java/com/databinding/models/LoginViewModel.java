package com.databinding.models;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.databinding.R;
import com.databinding.databinding.LoginBindings;

/**
 *   Model For Setting Values in XML
 */

public class LoginViewModel extends BaseViewModel<LoginBindings> implements View.OnFocusChangeListener {
    private String userNameValue;
    private String passwordValue;

    public LoginViewModel(Context context, LoginBindings binding) {
        super(context, binding);
    }

    public String getUserNameValue() {
        return userNameValue;
    }

    public void setUserNameValue(String userNameValue) {
        this.userNameValue = userNameValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public String getPasswordValue() {
        return passwordValue;
    }


    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (!hasFocus) {
            switch (view.getId()) {
                case R.id.userNameField: {
                    validateUserName();
                }
                break;
                case R.id.userPasswordField: {
                    validatePassword();
                }
                break;
            }
        }
    }

    public boolean validateUserName() {
        if (TextUtils.isEmpty(userNameValue)) {
            getBinding().userNameField.setError(getContext().getString(R.string.error_register_empty_username));
        } else if (userNameValue.trim().length() < 4) {
            getBinding().userNameField.setError(getContext().getString(R.string.error_register_invalid_username));
        } else {
            getBinding().userNameField.setError(null);
            setUserNameValue(userNameValue.trim());
            return true;
        }
        return false;
    }

    public boolean validatePassword() {
        if (TextUtils.isEmpty(passwordValue)) {
            getBinding().userPasswordField.setError(getContext().getString(R.string.error_register_empty_password));
        } else if (passwordValue.trim().length() < 4) {
            getBinding().userPasswordField.setError(getContext().getString(R.string.error_register_invalid_password));
        } else {
            getBinding().userPasswordField.setError(null);
            setPasswordValue(passwordValue.trim());
            return true;
        }
        return false;
    }
}

