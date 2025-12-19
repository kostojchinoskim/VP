package mk.finki.ukim.lab.repository.mock;


import jakarta.annotation.PostConstruct;
import mk.finki.ukim.lab.models.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryAuthorRepository {
    public static List<Author> authors =  new ArrayList<>();

    @PostConstruct
    public void init(){
//        authors.add(new Author("F. Scott", "Fitzgerald","United States","/"));
//        authors.add(new Author("Harper", "Lee","United States","/"));
//        authors.add(new Author("Frank", "Herbert","United States","/"));
//        authors.add(new Author("J.R.R.", "Tolkien","United Kingdom","/"));
//        authors.add(new Author("Stephen", "King","United States","/"));
//        authors.add(new Author("Jane", "Austen","United Kingdom","/"));
//        authors.add(new Author("Dan", "Brown","United States","/"));
//        authors.add(new Author("Suzanne", "Collins","United States","/"));
//        authors.add(new Author("Gillian", "Flynn","United States","/"));
//        authors.add(new Author("Andy", "Weir","United States","/"));
    }

    public List<Author> findAll() {
        return authors;
    }

    public Author findById(Long id) {
        return authors.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }
}
