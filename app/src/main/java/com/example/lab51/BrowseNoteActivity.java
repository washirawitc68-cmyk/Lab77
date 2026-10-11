package com.example.lab51;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class BrowseNoteActivity extends AppCompatActivity {

    EditText editSearch;
    Button buttonSearch, buttonBack;
    ProgressBar progressBar;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_note);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editSearch = findViewById(R.id.editSearch);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonBack = findViewById(R.id.buttonBack);
        progressBar = findViewById(R.id.progressBarSearch);
        textResult = findViewById(R.id.textSearchResult);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Multitasking (Thread) - Requirement 3
                textResult.setText("");
                progressBar.setVisibility(View.VISIBLE);

                //load data from db
                Executors.newSingleThreadExecutor().execute(() -> {
                    List<NoteEntity> entities = AppDatabase.getInstance(BrowseNoteActivity.this).noteDao().getAll();
                    List<Note> notes = new ArrayList<>();
                    for (NoteEntity e : entities) {
                        notes.add(NoteMapper.fromEntity(e));
                    }

                    // display on UI thread
                    runOnUiThread(() -> {
                        progressBar.setVisibility(View.GONE);
                        if (notes.isEmpty()) {
                            textResult.setText("ไม่พบข้อมูล");
                        } else {
                            StringBuilder sb = new StringBuilder();
                            for (Note n : notes) {
                                if (n != null) {
                                    sb.append(n.display()).append("\n\n");
                                }
                            }
                            textResult.setText(sb.toString());
                        }
                    });
                });
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
