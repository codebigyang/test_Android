package com.example.android_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
//接受信息的activity
public class receive extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        String get_message=intent.getStringExtra(MainActivity.MESSAGE);
        if(get_message!=null)
        {
            textView.setText(get_message);
        }
    }
}