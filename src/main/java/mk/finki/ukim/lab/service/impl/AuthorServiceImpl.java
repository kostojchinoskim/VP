package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.models.Author;
import mk.finki.ukim.lab.repository.AuthorRepository;
import mk.finki.ukim.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll()
    {
        return authorRepository.findAll();
    }
}
