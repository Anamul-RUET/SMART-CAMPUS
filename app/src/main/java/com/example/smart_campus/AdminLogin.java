package com.example.smart_campus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText userID;
    EditText password;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        userID=findViewById(R.id.userID);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userID.getText().toString().equals("RUET") && password.getText().toString().equals("1111")){
                    Toast.makeText(AdminLogin.this, "Login sucessfully", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent=new Intent(AdminLogin.this,Menu.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(AdminLogin.this, "Invalid User ID or incorrect password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}