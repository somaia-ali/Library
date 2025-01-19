
package com.mycompany.librarysystem;

import java.util.List;

public class LibrarySystem {

    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic");
        library.addBook(2, "To Kill a Mockingbird", "Harper Lee", "Fiction");
        library.addBook(3, "1984", "George Orwell", "Dystopian");
        library.addBook(4, "Pride and Prejudice", "Jane Austen", "Romance");
        library.addBook(5, "The Catcher in the Rye", "J.D. Salinger", "Coming-of-Age");

        // Register users
        int visitor1 = library.registerUser("John", "password123", false);
        int visitor2 = library.registerUser("Jane", "securePassword", true);

        // Perform book borrowing and returning
        library.borrowBook(visitor1, 1);
        library.borrowBook(visitor2, 2);
        library.returnBook(visitor1, 1);
        library.returnBook(visitor2, 2);

        // View all books and search
        library.viewAllBooks();
        List<Book> searchResults = library.searchBooks("Pride");
        System.out.println("Search results:");
        for (Book book : searchResults) {
            System.out.println(book.getName() + " by " + book.getAuthor() + " [" + book.getType() + "]");
        }

        // Print user details
        System.out.println("User details:");
        for (User user : library.getUsers().values()) {
            System.out.println(user);
        }
    


    }
}
