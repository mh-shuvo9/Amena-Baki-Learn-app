package com.example.amena_baki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username_edit_text,password_edit_text;
    Button Login_button;
    TextView Register_edit_text;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        username_edit_text = (EditText) findViewById(R.id.Edit_User_Id);
        password_edit_text = (EditText)findViewById(R.id.Edit_Pass_Id);
        Login_button = (Button)findViewById(R.id.buttonId);
        Register_edit_text = (TextView)findViewById(R.id.TextView_Register);


        Register_edit_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username_edit_text.getText().toString().trim();
                String pdw = password_edit_text.getText().toString().trim();
                Boolean res = db.checkUser(user,pdw);

                if (res == true)
                {
                    Toast.makeText(Login.this,"Success full Login",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {

                    Toast.makeText(Login.this,"Login Failed",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
