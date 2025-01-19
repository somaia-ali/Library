package com.mycompany.librarysystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private Map<Integer, User> users;
    private Map<Integer, Book> books;
    private static final int MAX_BORROW_LIMIT = 5;
    private int visitorCounter;

    public Library() {
        this.users = new HashMap<>();
        this.books = new HashMap<>();
        this.visitorCounter = 0;
    }

    public int getVisitorCounter() {
        return visitorCounter;
    }

    public int registerUser(String username, String password, boolean isRegularUser) {
        User newUser;
        if (isRegularUser) {
            newUser = new RegularUser(username, password);
        } else {
            newUser = new User(username, password);
        }
        int visitorNumber = ++visitorCounter;
        users.put(visitorNumber, newUser);
        return visitorNumber;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public int getVisitorNumber(User user) {
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            if (entry.getValue() == user) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public void addBook(int id, String name, String author, String type) {
        Book newBook = new Book(id, name, author, type);
        books.put(id, newBook);
    }

    public Book findBookById(int id) {
        return books.get(id);
    }

    public void borrowBook(int visitorNumber, int bookId) {
        User user = users.get(visitorNumber);
        Book book = findBookById(bookId);

        if (user != null && book != null && book.isAvailable()) {
            book.setAvailable(false);
            user.addBorrowedBook(book);
            Borrow borrow = new Borrow(user, book);
            System.out.println("Book borrowed successfully. \nBorrow details:\n" + borrow);

            if (user instanceof RegularUser) {
                RegularUser regularUser = (RegularUser) user;
                regularUser.addPoints(1); // Add points to regular user
            }
        } else {
            System.out.println("Failed to borrow the book.");
        }
    }

    public void returnBook(int visitorNumber, int bookId) {
        User user = users.get(visitorNumber);
        Book book = findBookById(bookId);

        if (user != null && book != null && !user.getBorrowedBooks().isEmpty() && user.getBorrowedBooks().contains(book)) {
            book.setAvailable(true);
            user.removeBorrowedBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Failed to return the book.");
        }
    }

    public List<Book> searchBooks(String query) {
        List<Book> searchResults = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getName().contains(query) || book.getAuthor().contains(query) || book.getType().contains(query)) {
                searchResults.add(book);
            }
        }

        return searchResults;
    }

    public void viewAllBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book.getName() + " by " + book.getAuthor() + " [" + book.getType() + "]");
            }
        }
    }

    private String borrowDetailsToString(Borrow borrow) {
        User user = borrow.getUser();
        Book book = borrow.getBorrowedBook();

        return "Borrower: " + user.getUsername() + "\n"
                + "Book: " + book.getName() + "\n"
                + "Author: " + book.getAuthor() + "\n"
                + "Type: " + book.getType();
    }

}
