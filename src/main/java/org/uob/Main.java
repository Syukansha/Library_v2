package org.uob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uob.Models.Categories;
import org.uob.Models.CategoriesType;
import org.uob.Repositories.CategoriesRepositories;
import org.uob.Services.LibraryServices;

import javax.xml.ws.Action;

@SpringBootApplication
public class Main implements CommandLineRunner{
    @Autowired
    LibraryServices libraryServices;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

//    public void addCategory(CategoriesType categoriesType){
//
//        libraryServices.addCategory(categoriesType);
//
//    }


    @Override
    public void run(String... args) throws Exception {
        CategoriesType categoriesType = new CategoriesType();
        libraryServices.addCategory(categoriesType);
    }
}