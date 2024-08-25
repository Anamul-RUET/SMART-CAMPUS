package com.example.smart_campus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
CardView home;
CardView notice;
CardView ebook;
CardView faculty;
DrawerLayout drawerLayout;
NavigationView navigationView;
ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        home=findViewById(R.id.home);
        notice=findViewById(R.id.notice);
        ebook=findViewById(R.id.ebook);
        faculty=findViewById(R.id.faculty);

        home.setOnClickListener(this);
        notice.setOnClickListener(this);
        ebook.setOnClickListener(this);
        faculty.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        } else {
            Log.e("Dashboard", "ActionBar is not available.");
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_developer) {
                    Toast.makeText(Dashboard.this, "Developer", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.navigation_video) {
                    Toast.makeText(Dashboard.this, "Video Lectures", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.navigation_theme) {
                    Toast.makeText(Dashboard.this, "Themes", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.navigation_ebook) {
                    Toast.makeText(Dashboard.this, "Ebooks", Toast.LENGTH_SHORT).show();

                } else if (itemId == R.id.navigation_website) {
                    Toast.makeText(Dashboard.this, "Website", Toast.LENGTH_SHORT).show();

                } else if (itemId == R.id.navigation_rate) {
                    Toast.makeText(Dashboard.this, "Rate Us", Toast.LENGTH_SHORT).show();

                } else if (itemId == R.id.navigation_share) {
                    Toast.makeText(Dashboard.this, "Share", Toast.LENGTH_SHORT).show();
                }

                return true;
            }

        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v.getId()==R.id.notice){
            intent=new Intent(Dashboard.this,Show.class);
            startActivity(intent);
        }
       else if(v.getId()==R.id.home){
            intent=new Intent(Dashboard.this,ShowHome.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.faculty){
            intent=new Intent(Dashboard.this,ShowFaculty.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.ebook){
            intent=new Intent(Dashboard.this,ShowEbook.class);
            startActivity(intent);
        }
    }
}