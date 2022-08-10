package com.example.amena_baki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelper db;
    private EditText edit_text_username,edit_text_password,edit_text_confirm_password;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        edit_text_username = (EditText)findViewById(R.id.Edit_User_Id);
        edit_text_password = (EditText)findViewById(R.id.Edit_Pass_Id);
        edit_text_confirm_password = (EditText)findViewById(R.id.Edit_Pass_Id2);
        register = (Button)findViewById(R.id.buttonId);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edit_text_username.getText().toString().trim();
                String pwd = edit_text_password.getText().toString().trim();
                String cnf_pwd = edit_text_confirm_password.getText().toString().trim();

                if (pwd.equals(cnf_pwd)){

                    long val = db.adduser(user,pwd);
                    if (val>0) {

                        Toast.makeText(Register.this, "You have registered", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Register.this,"Error Registration",Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(Register.this,"Password is not correct",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
