package com.example.smart_campus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {
EditText userId;
EditText name;
EditText rollNo;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        userId=findViewById(R.id.userId);
        name=findViewById(R.id.name);
        rollNo=findViewById(R.id.rollNo);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty() || rollNo.getText().toString().isEmpty()){
                    Toast.makeText(UserLogin.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
                else if(userId.getText().toString().equals("RUET")){
                    Toast.makeText(UserLogin.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    String TAG="first";
                    Log.d(TAG, "onClick: success 1");
                    intent=new Intent(UserLogin.this,Dashboard.class);
                    startActivity(intent);
                    Log.d(TAG, "onClick: success 2");

                }
                else
                {
                    Toast.makeText(UserLogin.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}