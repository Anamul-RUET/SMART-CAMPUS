package com.example.smart_campus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Menu extends AppCompatActivity implements View.OnClickListener {
CardView addNotice;
CardView addGalleryImage;
CardView addEbook;
CardView addfaculty;
CardView deleteNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        addNotice=findViewById(R.id.addNotice);
        addGalleryImage=findViewById(R.id.addGalleryImage);
        addEbook=findViewById(R.id.addEbook);
        addfaculty=findViewById(R.id.addfaculty);
        deleteNotice=findViewById(R.id.deleteNotice);
        addNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        addfaculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.addNotice) {
            Log.i("This is for developers","id is working");
            intent = new Intent(Menu.this, UploadNotice.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.addGalleryImage){
            intent=new Intent(Menu.this,UploadImage.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.addEbook){
            intent=new Intent(Menu.this,UploadPdf.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.addfaculty){
            intent=new Intent(Menu.this,UpdateFaculty.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.deleteNotice){
            intent=new Intent(Menu.this,DeleteNotice.class);
            startActivity(intent);
        }
    }

}
