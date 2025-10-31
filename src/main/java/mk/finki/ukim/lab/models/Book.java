package mk.finki.ukim.lab.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String genre;
    private double averageRating;
}
