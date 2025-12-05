//package mk.finki.ukim.lab.repository.impl;
//
//import mk.finki.ukim.lab.bootstrap.DataHolder;
//import mk.finki.ukim.lab.models.Author;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class AuthorRepositoryImpl implements AuthorRepository {
//
//
//    @Override
//    public List<Author> findAll() {
//        return DataHolder.authors;
//    }
//
//    public Author findById(Long id){
//        return DataHolder.authors.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
//    }
//}
