package dev.jcampos.spring5webapp.model.repositories;

import dev.jcampos.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
