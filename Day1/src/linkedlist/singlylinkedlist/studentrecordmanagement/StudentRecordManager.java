package linkedlist.singlylinkedlist.studentrecordmanagement;

// Primary class: StudentRecordManager
public class StudentRecordManager {
    public static void main(String[] args) {
        // Create an instance of the LinkedList
        LinkedList studentList = new LinkedList();

        // Add student records
        studentList.addAtBeginning(1, "Alice", 20, "A");
        studentList.addAtEnd(2, "Bob", 22, "B");
        studentList.addAtPosition(3, "Charlie", 21, "A+", 2);

        // Display all student records
        System.out.println("All Student Records:");
        studentList.display();

        // Search for a student by Roll Number
        System.out.println("\nSearching for Roll Number 2:");
        studentList.search(2);

        // Update a student's grade
        System.out.println("\nUpdating grade for Roll Number 1:");
        studentList.updateGrade(1, "A+");
        studentList.display();

        // Delete a student record
        System.out.println("\nDeleting Roll Number 3:");
        studentList.delete(3);
        studentList.display();
    }
}
