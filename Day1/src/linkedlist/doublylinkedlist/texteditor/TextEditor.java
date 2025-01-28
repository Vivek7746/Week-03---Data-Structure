package linkedlist.doublylinkedlist.texteditor;

// Primary Class: TextEditor
public class TextEditor {
    public static void main(String[] args) {
        UndoRedoManager editor = new UndoRedoManager(10); // Limit history to 10 states

        // Simulate text editing
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState();

        // Perform undo operations
        System.out.println("\nPerforming Undo:");
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();

        // Perform redo operations
        System.out.println("\nPerforming Redo:");
        editor.redo();
        editor.displayCurrentState();

        // Add a new state and check history management
        System.out.println("\nAdding new state after undo:");
        editor.addState("Hello, everyone!");
        editor.displayCurrentState();

        // Add multiple states to test the limit
        System.out.println("\nAdding states to exceed history limit:");
        for (int i = 1; i <= 12; i++) {
            editor.addState("State " + i);
        }
        editor.displayCurrentState();

        // Undo and redo after exceeding limit
        System.out.println("\nUndo after exceeding limit:");
        editor.undo();
        editor.displayCurrentState();

        System.out.println("\nRedo after exceeding limit:");
        editor.redo();
        editor.displayCurrentState();
    }
}