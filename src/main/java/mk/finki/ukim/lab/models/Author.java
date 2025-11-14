package mk.finki.ukim.lab.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {

    private static long counter = 0;
    private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;


    public  Author(String name, String surname, String country, String biography) {
        this.id = ++counter;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
    }
}
