package com.example.lab51;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button mButton,Addbutton;

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

        VipUser vipUser = new VipUser("U123", "UID-789", "John Doe", "password123", "Gold Member");
        vipUser.setName("John Smith");

        System.out.println("User Name: " + vipUser.getName());
        System.out.println("Account Type: " + vipUser.getVipStatus());

        if (vipUser.authenticate()) {
            System.out.println("Login Success for: " + vipUser.getName());
            System.out.println("Password: " + vipUser.getPassword());
        } else {
            System.out.println("Login Failed");
        }

        java.util.List<Note> notes = new java.util.ArrayList<>();

        notes.add(new TextNote("Lab 3 Task", "2026-07-24", "Complete OOP refactoring"));

        java.util.List<String> items = new java.util.ArrayList<>();
        items.add("Inheritance");
        items.add("Encapsulation");
        items.add("Polymorphism");
        notes.add(new CheckListNote("OOP Principles", "2026-07-24", items));

        System.out.println("\n--- My Notes ---");
        for (Note note : notes) {
            note.getSummary();
        }

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Navigating to AboutMeActivity");
                Intent aboutMeActivity = new Intent(getApplicationContext(), AboutMeActivity.class);
                startActivity(aboutMeActivity);
            }
        });

        Addbutton = findViewById(R.id.button2);
        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Navigating to AddNoteActivity");
                Intent addNote = new Intent(getApplicationContext(), AddNoteActivity.class);
                startActivity(addNote);
            }
        });
    }
}