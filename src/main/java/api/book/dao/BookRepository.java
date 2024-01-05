package api.book.dao;

import api.book.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
