package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
 private EditText etMail, etPass, etName;
 private Button btnReg, btnCan;
 private TextView tvWelcome;

 SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etMail = findViewById(R.id.editTextTextEmailAddress);
        etPass = findViewById(R.id.editTextTextPassword);
        etName = findViewById(R.id.editTextTextPersonName);
        btnReg = findViewById(R.id.button5);
        btnCan = findViewById(R.id.button6);
        tvWelcome= findViewById(R.id.textView3);

        pref= getSharedPreferences("UserInfo", 0);
    }

    public void Register(View view) {
        String input_mail = etMail.getText().toString();
        String input_pass = etPass.getText().toString();
        String input_name = etName.getText().toString();
        if(input_mail.length()>0){
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("Email", input_mail);
            editor.putString("Password", input_pass);
            editor.putString("UserName", input_name);

            editor.apply();
            Toast.makeText(this, "User registered", Toast.LENGTH_LONG).show();
            Intent intent_main =new Intent(this, MainActivity.class);
            startActivity(intent_main);

        }
        else{
            Toast.makeText(this, "Empty values, please insert!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View view) {
        Intent intent_main = new Intent(this, MainActivity.class);
        startActivity(intent_main);
    }
}