package com.example.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.R;
import com.example.databinding.LoginBindings;
import com.example.models.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private LoginBindings mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        mBinding = DataBindingUtil.setContentView(this, R.layout.login_page);

        // Initializing the bindings @XML
        initializeBindings();
    }

    private void initializeBindings() {
        mBinding.setHandler(this);
        mBinding.setEnableLoginButton(true);

        // Setting the values of bindings via model class
        mBinding.setLoginViewModel(new LoginViewModel(this, mBinding));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                if (mBinding.getLoginViewModel().validateUserName() && mBinding.getLoginViewModel().validatePassword()) {
                    // Proceed To login
                    startActivity(new Intent(this, LoginSuccessActivity.class));
                }
                break;
        }
    }
}