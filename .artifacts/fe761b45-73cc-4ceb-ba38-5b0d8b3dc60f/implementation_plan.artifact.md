# Implementation Plan - File Consolidation

The goal is to reduce the number of Java files by merging related classes into common files. This will make the project structure cleaner while maintaining all functionality.

## Proposed Changes

### 1. User Model Consolidation
- **[MODIFY] [User.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/User.java)**:
    - Keep `User` as the public class.
    - Append the `VipUser` class definition at the end of the file (as a non-public/package-private class).
- **[DELETE] `VipUser.java`**

### 2. Domain Model Consolidation
- **[NEW] [Models.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/Models.java)**:
    - Create this new file in the `com.example.lab51` package.
    - Move the definitions of `Address`, `Order`, `OrderItem`, and `Payment` into this file as non-public (package-private) classes.
- **[DELETE] `Address.java`**
- **[DELETE] `Order.java`**
- **[DELETE] `OrderItem.java`**
- **[DELETE] `Payment.java`**

### 3. Note Model Consolidation
- **[MODIFY] [Note.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/Note.java)**:
    - Keep `Note` as the public abstract class.
    - Append `TextNote` and `CheckListNote` class definitions at the end of the file as non-public (package-private) classes.
- **[DELETE] `TextNote.java`**
- **[DELETE] `CheckListNote.java`**

### 4. Controller Consolidation
- **[MODIFY] [NoteController.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/NoteController.java)**:
    - Move the `NoteEventListener` interface definition into this file.
- **[DELETE] `NoteEventListener.java`**

## Verification Plan
1. **Build Verification**: Run `gradle assembleDebug` to ensure all classes are correctly identified by the compiler despite being in shared files.
2. **Runtime Verification**: Verify navigation and note-saving functionality in the app to ensure no logic was lost during consolidation.
