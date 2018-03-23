package com.databinding.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.databinding.R;
import com.databinding.databinding.LoginBindings;
import com.databinding.models.LoginViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LoginBindings mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Initializing the bindings @XML
        initializeBindings();
    }

    private void initializeBindings() {
        mBinding.setHandler(this);
        mBinding.setEnableLoginButton(true);

        // Setting the values of bindings via model
        mBinding.setViewModel(new LoginViewModel(this, mBinding));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                if (mBinding.getViewModel().validateUserName() && mBinding.getViewModel().validatePassword()) {
                    // Proceed To login
                    startActivity(new Intent(this, LoginSuccess.class));
                }
                break;
        }
    }
}
