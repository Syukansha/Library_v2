package org.uob.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student extends Users{
    private int student_merits;

    public Student(){}

    public Student(int student_merits) {
        this.student_merits = student_merits;
    }

    public Student(int id, String username, String password, String email, int student_merits) {
        super(id, username, password, email);
        this.student_merits = student_merits;
    }

    public int getStudent_merits() {
        return student_merits;
    }

    public void setStudent_merits(int student_merits) {
        this.student_merits = student_merits;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_merits=" + student_merits +
                '}';
    }
}
