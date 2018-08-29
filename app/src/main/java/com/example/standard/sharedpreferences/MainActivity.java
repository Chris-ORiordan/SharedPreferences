package com.example.standard.sharedpreferences;

import android.content.*;
import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.standard.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding viewBinding;
    private SharedPreferences mSettings;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mSettings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = mSettings.edit();

        if (mSettings.contains("settingOne")) {
            if (mSettings.getBoolean("settingOne", false)) {
                viewBinding.chkSettingOne.setChecked(true);
            }
        }

        if (mSettings.contains("settingTwo")) {
            if (mSettings.getBoolean("settingTwo", false)) {
                viewBinding.chkSettingTwo.setChecked(true);
            }
        }

        //viewBinding.tvText.setText(mSettings.getString("username", "value missing"));

        /*viewBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("username", viewBinding.etText.getText().toString());
                editor.apply();
            }
        });*/

        viewBinding.chkSettingOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    editor.putBoolean("settingOne", true);
                    editor.apply();
                } else {
                    editor.putBoolean("settingOne", false);
                    editor.apply();
                }
            }
        });

        viewBinding.chkSettingTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    editor.putBoolean("settingTwo", true);
                    editor.apply();
                } else {
                    editor.putBoolean("settingTwo", false);
                    editor.apply();
                }
            }
        });
    }
}
