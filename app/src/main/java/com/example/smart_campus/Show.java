package com.example.smart_campus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Show extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        linearLayout = findViewById(R.id.linearLayout);

        // Initialize Firebase reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Notice");

        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {
        // Query to get all notices in ascending order
        Query allNoticesQuery = databaseReference.orderByKey();

        allNoticesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    linearLayout.removeAllViews(); // Clear the layout before adding new data

                    for (DataSnapshot noticeSnapshot : dataSnapshot.getChildren()) {
                        String title = noticeSnapshot.child("title").getValue(String.class);
                        String date = noticeSnapshot.child("date").getValue(String.class);
                        String time = noticeSnapshot.child("time").getValue(String.class);
                        String imageUrl = noticeSnapshot.child("image").getValue(String.class);

                        addNoticeToLayout(title, date, time, imageUrl);
                    }
                } else {
                    Toast.makeText(Show.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Show.this, "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addNoticeToLayout(String title, String date, String time, String imageUrl) {
        // Inflate single_notice layout for each notice dynamically
        LinearLayout noticeLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.single_notice, null);

        TextView textViewTitle = noticeLayout.findViewById(R.id.textViewTitle);
        TextView textViewDate = noticeLayout.findViewById(R.id.textViewDate);
        TextView textViewTime = noticeLayout.findViewById(R.id.textViewTime);
        ImageView imageView = noticeLayout.findViewById(R.id.imageView);

        textViewTitle.setText(title);
        textViewDate.setText(date);
        textViewTime.setText(time);

        Picasso.get().load(imageUrl).into(imageView);

        // Add the noticeLayout to the top of the LinearLayout
        linearLayout.addView(noticeLayout, 0);
    }
}
