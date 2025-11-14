package mk.finki.ukim.lab.repository;

import mk.finki.ukim.lab.bootstrap.DataHolder;
import mk.finki.ukim.lab.models.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository {

    public List<Author> findAll();
    public Author findById(Long id);
}
