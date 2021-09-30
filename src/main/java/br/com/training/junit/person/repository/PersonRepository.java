package br.com.training.junit.person.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.training.junit.person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
	
	@Query("SELECT p FROM Person p WHERE p.id = ?1")
	Optional<Person> findById(String id);
	
	List<Person> findByCityContains(String city);
	
	List<Person> findByStreetNameContains(String streetName);

	@Query("SELECT p FROM Person p WHERE p.city = ?1 and p.name like ?2")
	List<Person> findByCityAndNameStartWith(String city, String name);

}
