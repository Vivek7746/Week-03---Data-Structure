package linkedlist.doublylinkedlist.moviemanager;

// Primary class: MovieManager
public class MovieManager {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();

        // Add movies
        movieList.addAtBeginning("Inception", "Christopher Nolan", 2010, 9.0);
        movieList.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addAtPosition("The Godfather", "Francis Ford Coppola", 1972, 9.2, 2);

        // Display movies in forward order
        System.out.println("Movies in Forward Order:");
        movieList.displayForward();

        // Display movies in reverse order
        System.out.println("\nMovies in Reverse Order:");
        movieList.displayReverse();

        // Search for movies by Director
        System.out.println("\nMovies directed by Christopher Nolan:");
        movieList.searchByDirector("Christopher Nolan");

        // Search for movies by Rating
        System.out.println("\nMovies with Rating 9.0 or higher:");
        movieList.searchByRating(9.0);

        // Update movie rating
        System.out.println("\nUpdating the rating of 'Interstellar':");
        movieList.updateRating("Interstellar", 9.1);
        movieList.displayForward();

        // Remove a movie
        System.out.println("\nRemoving the movie 'The Godfather':");
        movieList.removeByTitle("The Godfather");
        movieList.displayForward();
    }
}