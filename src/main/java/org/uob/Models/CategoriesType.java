package org.uob.Models;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIES")
public class CategoriesType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GenreID;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category",nullable = false)
    private  Categories categories;

    @Column(name = "Copies")
    private int copies;

    public CategoriesType(){}

    public CategoriesType(int genreID, Categories categories, int copies) {
        GenreID = genreID;
        this.categories = categories;
        this.copies = copies;
    }

    public int getGenreID() {
        return GenreID;
    }

    public void setGenreID(int genreID) {
        GenreID = genreID;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "CategoriesType{" +
                "GenreID=" + GenreID +
                ", categories=" + categories +
                ", copies=" + copies +
                '}';
    }
}
