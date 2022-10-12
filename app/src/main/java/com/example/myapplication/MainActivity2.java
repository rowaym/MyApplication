package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
     Button plus, minus;
     EditText num1, num2;
     TextView result;



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num1=findViewById(R.id.editTextNumber);
        num2=findViewById(R.id.editTextNumber2);
        plus=findViewById(R.id.button3);
        minus=findViewById(R.id.button4);
        result=findViewById(R.id.textView2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public void plus(View view) {
        if(num1.getText().toString().equals(""))
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        else if (num2.getText().toString().equals(""))
            Toast.makeText(this, "fill the number", Toast.LENGTH_SHORT).show();
        else{
            double num11 = Double.parseDouble(num1.getText().toString());
            double num22 =Double.parseDouble(num2.getText().toString()) ;
            result.setText((num11+num22)+"");
    }


    }

    public void minus(View view) {
         if(num1.getText().toString().equals(""))
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        else if (num2.getText().toString().equals(""))
            Toast.makeText(this, "fill the number", Toast.LENGTH_SHORT).show();
        else{
            double num11 = Double.parseDouble(num1.getText().toString());
            double num22 =Double.parseDouble(num2.getText().toString()) ;
            result.setText((num11-num22)+"");
        }
    }
}