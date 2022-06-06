package com.javaguides.springboot;

import com.javaguides.springboot.model.*;
import com.javaguides.springboot.repository.ActorRepository;
import com.javaguides.springboot.repository.BookRepository;
import com.javaguides.springboot.repository.RolesRepository;
import com.javaguides.springboot.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		UserProfile userProfile = new UserProfile(1, 35, "male", "red", null);
		var reRun = SpringApplication.run(SpringbootAppApplication.class, args);
		var result = reRun.getBean("userRepository", UserRepository.class);
		User user = new User(1, "John Dou",
				"John", "Dou", "jd@mail.com", userProfile);
		userProfile.setUser(user);
		result.save(user);

//------------------------------------------------
		Author author = new Author(1L, "J.Rouling", null);
		Author author1 = new Author(2L, "J.Tolkin", null);

		var result1 = reRun.getBean("bookRepository", BookRepository.class);
		Book book = new Book(1L, "Harry Potter", author);
		Book book1 = new Book(2L, "Harry Potter2", author1);
		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book1);
		author.setBooks(books);
		author1.setBooks(books);
		result1.save(book);

//---------------------------------
		Roles roles = new Roles(1L, "Jorik", null);
		Roles roles1 = new Roles(2L, "Otello", null);
		Roles roles2 = new Roles(3L, "Hamlet", null);
		List<Roles> listOfRoles = new ArrayList<>();
		listOfRoles.add(roles);
		listOfRoles.add(roles1);
		listOfRoles.add(roles2);

		var result2 = reRun.getBean("actorRepository", ActorRepository.class);

		Actor actor = new Actor(1L, "andrew", listOfRoles);
		Actor actor1 = new Actor(2L, "simple", listOfRoles);
		Actor actor2 = new Actor(3L, "michael", listOfRoles);

		List<Actor> listOfActors = new ArrayList<>();
		listOfActors.add(actor);
		listOfActors.add(actor1);
		listOfActors.add(actor2);

		roles.setActors(listOfActors);
		roles1.setActors(listOfActors);
		roles2.setActors(listOfActors);
		result2.save(actor);
		result2.save(actor1);
		result2.save(actor2);

	}

}
