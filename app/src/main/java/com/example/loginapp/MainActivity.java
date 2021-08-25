package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button   button;
    private TextView text;
    public boolean isvalid=false;
    private int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.et1);
        password=(EditText)findViewById(R.id.et2);
        button=(Button)findViewById(R.id.btn);
        text=(TextView)findViewById(R.id.tv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1=email.getText().toString();
                String password1=password.getText().toString();
                if(email1.isEmpty())
                {


                    Toast.makeText( MainActivity.this,  "Enter correct credentials",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    isvalid=validate(email1,password1);
                            if(isvalid)
                            {
                                Intent ob=new Intent(MainActivity.this,activity2.class);
                                startActivity(ob);
                                MainActivity.super.onDestroy();
                            }
                            else
                            {
                                counter--;
                                if(counter ==0)
                                {
                                    button.setEnabled(false);
                                    Toast.makeText(MainActivity.this,"You have no attempts left",Toast.LENGTH_LONG).show();
                                }
                                Toast.makeText(MainActivity.this,"you have attemps"+counter,Toast.LENGTH_LONG).show();
                                text.setText("you have attempts: "+ counter);

                            }

                }
            }
        });


    }
    public boolean validate(String email1, String pass)
    {
        return email1.equals("shimdaawar@gmail.com") && pass.equals("1234");
    }
}

