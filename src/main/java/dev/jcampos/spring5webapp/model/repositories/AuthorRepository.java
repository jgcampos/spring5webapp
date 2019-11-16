package dev.jcampos.spring5webapp.model.repositories;

import dev.jcampos.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
