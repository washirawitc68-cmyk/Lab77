package com.example.lab51;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button mButton, Addbutton, Browsebutton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar = findViewById(R.id.progressBar);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutMeActivity = new Intent(getApplicationContext(), AboutMeActivity.class);
                startActivity(aboutMeActivity);
            }
        });

        Addbutton = findViewById(R.id.button2);
        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNote = new Intent(getApplicationContext(), AddNoteActivity.class);
                startActivity(addNote);
            }
        });

        Browsebutton = findViewById(R.id.buttonBrowse);
        Browsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Multitasking (Thread) - Requirement 2
                progressBar.setVisibility(View.VISIBLE);
                
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Simulate loading data (2 seconds)
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Update UI on main thread
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);
                                Intent browseIntent = new Intent(MainActivity.this, BrowseNoteActivity.class);
                                startActivity(browseIntent);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
