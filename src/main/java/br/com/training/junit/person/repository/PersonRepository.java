package br.com.training.junit.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.training.junit.person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findByCityContains(String city);

}
