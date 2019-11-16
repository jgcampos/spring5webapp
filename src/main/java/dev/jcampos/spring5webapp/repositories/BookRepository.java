package dev.jcampos.spring5webapp.repositories;

import dev.jcampos.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
