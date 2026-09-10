# Fix Compilation Error: static declarations not allowed in inner classes

The project is failing to build because an `enum` (which is implicitly static) is declared inside the `Payment` class, which is currently a non-static inner class of `Order`. In Java 11, non-static inner classes cannot contain static members.

## Proposed Changes

### [Component Name]

#### [MODIFY] [Order.java](file:///C:/Users/Advice03/AndroidStudioProjects/Lab51/app/src/main/java/com/example/lab51/Order.java)
- Change `public class OrderItem` to `public static class OrderItem`.
- Change `public class Payment` to `public static class Payment`.
- Simplify or correct `Status` references inside the `Payment` class to use either the short name `Status` or the correct nested path `Order.Payment.Status`.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:compileDebugJavaWithJavac` to verify that the compilation error is resolved.
