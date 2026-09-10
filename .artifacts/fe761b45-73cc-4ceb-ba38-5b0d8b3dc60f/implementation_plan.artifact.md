# Implementation Plan - Event-Driven Note App with User Integration

The goal is to implement a note-taking application that supports both `TextNote` and `CheckListNote`, integrates `User` data into notes, and follows Event-driven programming principles.

## User Review Required

> [!IMPORTANT]
> The files `MainActivity.java`, `AddNoteActivity.java`, and `NoteController.java` currently contain significant syntax errors and structural issues (e.g., unreachable code, undefined variables, missing layout elements) that prevent the application from compiling or running.
>
> Although you requested **not** to change these files, I must perform minimal "surgical" fixes to them so that the project can build and function as intended by the assignment. I will preserve your intended logic while making it syntactically correct and functional.

## Proposed Changes

### 1. Data Models & Inheritance

#### [MODIFY] [Note.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/Note.java)
- Add a `User` field to associate a note with its creator.
- Update constructors and getters/setters.

#### [MODIFY] [TextNote.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/TextNote.java)
- Add `setTextContent()` and `getTextContent()` to match the usage in `NoteController` and `AddNoteActivity`.
- Update constructors to support easier instantiation.

#### [MODIFY] [CheckListNote.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/CheckListNote.java)
- Ensure it properly handles list-based summaries.

### 2. Event-Driven Programming

#### [NEW] [NoteEventListener.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/NoteEventListener.java)
- Define an interface to handle note-related events (e.g., `onNoteSaved`). This satisfies the "Event-driven programming" requirement by decoupling the controller from the view.

### 3. Controller Logic

#### [MODIFY] [NoteController.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/NoteController.java)
- Fix variable names (`title` instead of `strOfTitle`, etc.).
- Fix the `view` reference to use a proper interface or class type.
- Implement the logic to save notes and notify listeners.

### 4. UI & Layouts

#### [MODIFY] [activity_add_note.xml](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/res/layout/activity_add_note.xml)
- Add `EditText` for Title and Content.
- Add `Button` to save the note.
- Add `TextView` to display the result.
- Add input for User name/ID as per requirement 3.

#### [MODIFY] [AddNoteActivity.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/AddNoteActivity.java)
- Move initialization code outside the `WindowInsetsListener` to make it reachable.
- Fix syntax errors (variable naming, method definitions).
- Hook up the `NoteController` and implement the "display" logic.

## Verification Plan

### Manual Verification
1. Run the app on an emulator/device.
2. Click the button in `MainActivity` to go to `AddNoteActivity`.
3. Enter Note Title, Content, and User information.
4. Click "Add Note" and verify the summary is displayed correctly in the `TextView`.
5. Check Logcat for "Event-driven" output if implemented.
