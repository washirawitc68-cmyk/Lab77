package com.example.lab51;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity implements NoteEventListener {
    EditText titleEdit, contentEdit, userEdit;
    Button saveBtn, backBtn;
    TextView showNote;
    NoteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        titleEdit = findViewById(R.id.edittitle);
        contentEdit = findViewById(R.id.editcontent);
        userEdit = findViewById(R.id.edituser);
        saveBtn = findViewById(R.id.buttonSave);
        backBtn = findViewById(R.id.buttonBack);
        showNote = findViewById(R.id.textView);

        controller = new NoteController(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTitle = titleEdit.getText().toString();
                String strContent = contentEdit.getText().toString();
                String strUser = userEdit.getText().toString();
                String strDate = new Date().toString();

                User user = new User("U1", "ID1", strUser, "pass");
                controller.saveNote(strTitle, strContent, strDate, user);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onNoteSaved(Note note) {
        // This is called by the controller when the note is saved (Event-driven)
        if (note instanceof TextNote) {
            TextNote textNote = (TextNote) note;
            String ownerName = (textNote.getOwner() != null) ? textNote.getOwner().getName() : "Unknown";
            showNote.setText("Title: " + textNote.getTitle() + "\nOwner: " + ownerName + "\nContent: " + textNote.getContent());
        }
    }
}
