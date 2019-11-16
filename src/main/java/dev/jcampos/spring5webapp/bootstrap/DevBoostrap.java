package dev.jcampos.spring5webapp.bootstrap;

import dev.jcampos.spring5webapp.model.Author;
import dev.jcampos.spring5webapp.model.Book;
import dev.jcampos.spring5webapp.model.Publisher;
import dev.jcampos.spring5webapp.repositories.AuthorRepository;
import dev.jcampos.spring5webapp.repositories.BookRepository;
import dev.jcampos.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBoostrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBoostrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // Eric
        Publisher allison = new Publisher("Allison Wesley" , "NY, USA");
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "1234", allison);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(allison);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Publisher prentice = new Publisher("Prentice Hall" , "Madrid, Spain");
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", prentice);
        rod.getBooks().add(noEJB);

        publisherRepository.save(prentice);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
