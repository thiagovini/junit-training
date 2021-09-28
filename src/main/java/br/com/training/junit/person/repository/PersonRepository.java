package br.com.training.junit.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.training.junit.person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findByCityContains(String city);
	
	List<Person> findByStreetNameContains(String streetName);

	@Query("SELECT p FROM Person p WHERE p.city = ?1 and p.name like ?2")
	List<Person> findByCityAndNameStartWith(String city, String name);

}
