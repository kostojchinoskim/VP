package mk.finki.ukim.lab.service;

import mk.finki.ukim.lab.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
}
