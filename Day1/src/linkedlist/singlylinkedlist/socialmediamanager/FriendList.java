package linkedlist.singlylinkedlist.socialmediamanager;

// Secondary class: FriendList
import java.util.ArrayList;

class FriendList {
    // Node class to represent each user
    class Node {
        int userId;
        String name;
        int age;
        ArrayList<Integer> friends; // List of friend IDs
        Node next;

        // Constructor
        public Node(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
            this.next = null;
        }
    }

    private Node head; // Head of the linked list

    // Add a new user
    public void addUser(int userId, String name, int age) {
        Node newUser = new Node(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            if (!user1.friends.contains(userId2)) user1.friends.add(userId2);
            if (!user2.friends.contains(userId1)) user2.friends.add(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove((Integer) userId2);
            user2.friends.remove((Integer) userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            ArrayList<Integer> mutualFriends = new ArrayList<>(user1.friends);
            mutualFriends.retainAll(user2.friends); // Find intersection
            if (mutualFriends.isEmpty()) {
                System.out.println("No mutual friends found.");
            } else {
                System.out.println("Mutual Friends:");
                for (int friendId : mutualFriends) {
                    Node friend = findUserById(friendId);
                    if (friend != null) {
                        System.out.println(friend.name);
                    }
                }
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        Node user = findUserById(userId);
        if (user != null) {
            if (user.friends.isEmpty()) {
                System.out.println(user.name + " has no friends.");
            } else {
                for (int friendId : user.friends) {
                    Node friend = findUserById(friendId);
                    if (friend != null) {
                        System.out.println(friend.name);
                    }
                }
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by User ID
    public void searchUserById(int userId) {
        Node user = findUserById(userId);
        if (user != null) {
            System.out.println("User Found: ID: " + user.userId + ", Name: " + user.name + ", Age: " + user.age);
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        Node current = head;
        while (current != null) {
            System.out.println(current.name + " has " + current.friends.size() + " friend(s).");
            current = current.next;
        }
    }

    // Helper method: Find a user by User ID
    private Node findUserById(int userId) {
        Node current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
