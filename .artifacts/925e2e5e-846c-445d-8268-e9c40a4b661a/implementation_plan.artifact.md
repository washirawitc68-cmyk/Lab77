# Implementation Plan - Integrating Room Database Snippets

The user wants to integrate three code snippets for loading and saving notes using a Room database.

## Proposed Changes

### 1. [Component: Models] - Update `Note` and subclasses
To support `sb.append(n.display())` from the snippet:
- Add `public abstract String display();` to `Note.java`.
- Implement `display()` in `TextNote.java` and `CheckListNote.java`.

### 2. [Component: Activities] - Integrate Snippets
#### [MODIFY] [AddNoteActivity.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/AddNoteActivity.java)
- In `onNoteSaved(Note note)`, add the logic to convert the `Note` to `NoteEntity` and insert it into the database using an `Executor`.
- This fulfills Snippet 2 and 3.

#### [MODIFY] [BrowseNoteActivity.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/BrowseNoteActivity.java)
- In `buttonSearch.setOnClickListener`, replace the simulated search with the database loading logic.
- Fetch all notes from `AppDatabase`, map them to `Note` objects, and display them in the `textResult` TextView.
- This fulfills Snippet 1.

### 3. [Component: Mapper] - Fix `NoteMapper.java`
- Ensure `NoteMapper` correctly accesses `Note` properties (using getters) and handles the date properly.

## Verification Plan

### Manual Verification
- **Add Note**: Open `AddNoteActivity`, enter details, and click "Save". Verify in Logcat that "Insert successful" is printed.
- **Browse Notes**: Open `BrowseNoteActivity`, click "Search". Verify that the notes saved previously are displayed in the list.
