
package com.mycompany.librarysystem;

public class Book {
     private int id;
    private String name;
    private String author;
    private String type;
    private boolean isAvailable;

    public Book(int id, String name, String author, String type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.type = type;
        this.isAvailable = true;
    }
    
    // Empty constructor
    public Book() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

}
