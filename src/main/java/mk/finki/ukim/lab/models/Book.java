package mk.finki.ukim.lab.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private static long counter = 0;
    private Long id;
    private String title;
    private String genre;
    private double averageRating;
    private Author author;


    public Book(String title, String genre, double averageRating, Author author){
        this.id = counter++;
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }

}
