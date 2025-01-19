package com.mycompany.librarysystem;

public class Borrow {

    private User user;
    private Book borrowedBook;

    public Borrow(User user, Book borrowedBook) {
        this.user = user;
        this.borrowedBook = borrowedBook;
    }

    // Empty constructor
    public Borrow() {
    }

    public User getUser() {
        return user;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    @Override
    public String toString() {
        return "Borrow{"
                + "user=" + user
                + ", borrowedBook=" + borrowedBook
                + '}';
    }

}
