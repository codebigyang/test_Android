package com.example.android_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
//登录启动界面
public class login_activity extends AppCompatActivity implements View.OnClickListener{

     private Boolean switch_icon=false;
     private EditText  etPwd;//密码框
     private CheckBox RememberPwd;//勾选框
     private EditText etAccount;//账户
    private Button btlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView imageView=findViewById(R.id.iv_pwd_switch);
       etPwd=findViewById(R.id.et_pwd);
        RememberPwd=findViewById(R.id.cb_remember_pwd);
        etAccount=findViewById(R.id.etAccount);
        btlogin=findViewById(R.id.bt_login);
        btlogin.setOnClickListener(this);
        String spFileName = getResources()
                .getString(R.string.shared_preferences_file_name);
        String accountKey = getResources()
                .getString(R.string.login_account_name);
        String passwordKey =  getResources()
                .getString(R.string.login_password);
        String rememberPasswordKey = getResources()
                .getString(R.string.login_remenber_password);

        SharedPreferences spFile = getSharedPreferences(
                spFileName,
                MODE_PRIVATE);
        String account = spFile.getString(accountKey, null);
        String password = spFile.getString(passwordKey, null);
        Boolean rememberPassword = spFile.getBoolean(
                rememberPasswordKey,
                false);
          if(account!=null&&!TextUtils.isEmpty(account))
        {
            etAccount.setText(account);
        }
          if(password!=null&&!TextUtils.isEmpty(password))
        {
            etPwd.setText(password);
        }
          RememberPwd.setChecked(rememberPassword);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_icon=!switch_icon;
                if(switch_icon)
                {
                    imageView.setImageResource(R.drawable.ic_baseline_visibility_24);
                    etPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                else
                {
                    imageView.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    etPwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    etPwd.setTypeface(Typeface.DEFAULT);
                }
            }
        });

    }


    @Override
    public void onClick(View v) {
         String spFilename=getResources().getString(R.string.shared_preferences_file_name);
         String accountkey=getResources().getString(R.string.login_account_name);
         String passwordkey=getResources().getString(R.string.login_password);
         String rememberkey=getResources().getString(R.string.login_remenber_password);

        SharedPreferences spFile=getSharedPreferences(spFilename, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=spFile.edit();
        if(RememberPwd.isChecked())
        {
            String password=etPwd.getText().toString();
            String account=etAccount.getText().toString();

            edit.putString(accountkey,account);
            edit.putString(passwordkey,password);
            edit.putBoolean(rememberkey,true);
            edit.apply();
            Intent intent=new Intent(login_activity.this,newslList_activity.class);
            startActivity(intent);
        }
        else
        {
            edit.remove(accountkey);
            edit.remove(passwordkey);
            edit.remove(rememberkey);
            edit.apply();
            Intent intent=new Intent(login_activity.this,newslList_activity.class);
            startActivity(intent);
        }
    }
}