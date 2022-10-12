package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,emailAddress,password;
    Button login,signup;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editTextPersonName);
        emailAddress=findViewById(R.id.editTextEmailAddress);
        password=findViewById(R.id.editTextPassword);
        login=findViewById(R.id.button);
        signup=findViewById(R.id.button2);
        //creats a prefrences file, mode 0 -> read and write is only for my app
        pref=getSharedPreferences("UserInfo", 0);

    }

    public void login(View view) {
        if(emailAddress.getText().toString().equals(""))
            Toast.makeText(this, "Empty Email", Toast.LENGTH_LONG).show();
        else if (password.getText().toString().equals(""))
            Toast.makeText(this, "Empty Password", Toast.LENGTH_SHORT).show();
        else if (name.getText().toString().equals(""))
            Toast.makeText(this,"Empty Name", Toast.LENGTH_LONG).show();
        else {

            String input_mail = emailAddress.getText().toString();
            String input_pass = password.getText().toString();
            String input_name = name.getText().toString();
//this line gets the registered mail, name & pass , in case no user was registered empty string is returned
            String registeredMail = pref.getString("Email", "");
            String registeredPass = pref.getString("Password", "");
            String registeredName = pref.getString("UserName", "");

            if (input_mail.equals(registeredMail) && input_pass.equals(registeredPass)) {
                if(input_name.equals(registeredName)){
                Intent i_mail = new Intent(this, MainActivity2.class);
                startActivity(i_mail);}

            } else {
                Toast.makeText(this, "Incorrect credentials!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.helpmenu:
                Toast.makeText(MainActivity.this, "Help Clicked", Toast.LENGTH_SHORT).show();
                Intent x =new Intent(this, helpActivity.class);
                startActivity(x);
                break;
            case R.id.settingsmenu:
                Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                Intent y=new Intent(this, settingsActivity.class);
                startActivity(y);
                break;
            case R.id.logoutmenu:
                Toast.makeText(MainActivity.this, "Log out Clicked", Toast.LENGTH_SHORT).show();
                Intent z =new Intent(this, MainActivity.class);
                startActivity(z);
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Confirm Exit");
                dialog.setMessage("Are You Sure You Want To Exit?");
                dialog.setNegativeButton("Cancel",null);
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                });
    dialog.setIcon(R.drawable.ic_baseline_announcement_24);
    AlertDialog alertDialog=dialog.create();
    alertDialog.show();
    }

    public void Register(View view) {
       Intent i_register = new Intent(this, registerActivity.class);
       startActivity(i_register);
    }
}
