package com.dipaknai.mvvmsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.dipaknai.mvvmsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LoginCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        mainBinding.setViewModel(ViewModelProviders.of(MainActivity.this, new LoginViewModelFactory(this))
        .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG);
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG);
    }
}