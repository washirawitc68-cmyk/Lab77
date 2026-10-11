package com.example.lab51;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Date;
import java.util.List;

public class NoteMapper {

    static Gson gson = new Gson();

    // OOP -> Entity
    public static NoteEntity toEntity(Note note) {
        if (note instanceof TextNote) {
            return new NoteEntity(note.getTitle(), "text", null, ((TextNote) note).getContent(), new Date());
        } else if (note instanceof CheckListNote) {
            String jsonItems = gson.toJson(((CheckListNote) note).getChecklistItems());
            return new NoteEntity(note.getTitle(), "checklist", jsonItems, null, new Date());
        }
        return null;
    }

    // Entity -> OOP
    public static Note fromEntity(NoteEntity entity) {
        if (entity.type.equals("text")) {
            return new TextNote(entity.title, entity.createdDate != null ? entity.createdDate.toString() : "", entity.content);
        } else if (entity.type.equals("checklist")) {
            List<String> items = gson.fromJson(entity.checklistItemsJson, new TypeToken<List<String>>(){}.getType());
            return new CheckListNote(entity.title, entity.createdDate != null ? entity.createdDate.toString() : "", items);
        }
        return null;
    }
}
