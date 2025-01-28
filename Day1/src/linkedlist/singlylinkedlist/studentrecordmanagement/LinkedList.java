package linkedlist.singlylinkedlist.studentrecordmanagement;

// Secondary class: LinkedList
class LinkedList {
    // Node class to represent each student
    class Node {
        int rollNumber;
        String name;
        int age;
        String grade;
        Node next;

        // Constructor for Node
        public Node(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    private Node head; // Head of the linked list

    // Add a student record at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add a student record at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add a student record at a specific position
    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Node current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a student record by Roll Number
    public void delete(int rollNumber) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Roll Number not found.");
            return;
        }
        current.next = current.next.next;
    }

    // Search for a student record by Roll Number
    public void search(int rollNumber) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll No: " + current.rollNumber +
                        ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Update a student's grade based on their Roll Number
    public void updateGrade(int rollNumber, String newGrade) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all student records
    public void display() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNumber + ", Name: " + current.name +
                    ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}
