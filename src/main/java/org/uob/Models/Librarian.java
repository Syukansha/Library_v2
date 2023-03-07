package org.uob.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARIAN")
public class Librarian extends Users{

    public Librarian(){}

    public Librarian(int id, String username, String password, String email) {
        super(id, username, password, email);
    }


}
