package org.uob.Models;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookID;

    private String title;
    private String author;

    @Enumerated
    @JoinColumn(name = "Category", nullable = false)
    private Categories categories;

    private String status;

    private String synopsis;

    public Books(){}

    public Books(int bookID, String title, String author, Categories categories, String status,String synopsis) {
        BookID = bookID;
        this.title = title;
        this.author = author;
        this.categories = categories;
        this.status = status;
        this.synopsis = synopsis;
    }

    public Books(String title, String author, Categories categories, String status,String synopsis) {
        this.title = title;
        this.author = author;
        this.categories = categories;
        this.status = status;
        this.synopsis = synopsis;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Books{" +
                "BookID=" + BookID +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", categories=" + categories +
                ", status='" + status + '\'' +
                '}';
    }
}
