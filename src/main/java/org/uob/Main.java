package org.uob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uob.Models.CategoriesType;
import org.uob.Services.LibraryServices;

@SpringBootApplication
public class Main implements CommandLineRunner{
    @Autowired
    LibraryServices libraryServices;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CategoriesType categoriesType = new CategoriesType();
        libraryServices.addCategory(categoriesType);
    }
}