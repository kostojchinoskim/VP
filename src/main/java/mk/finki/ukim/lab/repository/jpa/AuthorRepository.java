package mk.finki.ukim.lab.repository.jpa;

import mk.finki.ukim.lab.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}