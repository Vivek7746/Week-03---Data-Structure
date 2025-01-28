package linkedlist.singlylinkedlist.socialmediamanager;

// Primary class: SocialMediaManager
public class SocialMediaManager {
    public static void main(String[] args) {
        FriendList friendList = new FriendList();

        // Add users
        friendList.addUser(1, "Alice", 25);
        friendList.addUser(2, "Bob", 27);
        friendList.addUser(3, "Charlie", 24);
        friendList.addUser(4, "David", 26);

        // Add friend connections
        friendList.addFriendConnection(1, 2); // Alice <-> Bob
        friendList.addFriendConnection(1, 3); // Alice <-> Charlie
        friendList.addFriendConnection(2, 4); // Bob <-> David
        friendList.addFriendConnection(3, 4); // Charlie <-> David

        // Display friends of a specific user
        System.out.println("Friends of Alice:");
        friendList.displayFriends(1);

        // Find mutual friends between Alice and David
        System.out.println("\nMutual friends between Alice and David:");
        friendList.findMutualFriends(1, 4);

        // Search for a user by User ID
        System.out.println("\nSearch for User ID 2:");
        friendList.searchUserById(2);

        // Count number of friends for each user
        System.out.println("\nNumber of friends for each user:");
        friendList.countFriends();

        // Remove a friend connection
        System.out.println("\nRemoving friend connection between Alice and Charlie:");
        friendList.removeFriendConnection(1, 3);
        friendList.displayFriends(1);
    }
}
