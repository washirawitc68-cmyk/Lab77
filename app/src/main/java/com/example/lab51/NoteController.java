package com.example.lab51;

public class NoteController {
    private final NoteEventListener eventListener;

    public NoteController(NoteEventListener listener){
        this.eventListener = listener;
    }

    public void saveNote(String title, String content, String date, User user){
        TextNote textNote1 = new TextNote(title, date);
        textNote1.setTextContent(content);
        textNote1.setOwner(user);

        // Notify listener (Event-driven)
        if (eventListener != null) {
            eventListener.onNoteSaved(textNote1);
        }
    }


    public interface NoteEventListener {
        void onNoteSaved(Note note);
    }
}
