package hello.repository;

import hello.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long> { //JpaRepository è una superclasse, contiene CrudRepository, fa l'impaginazione e l'ordinazione 
    List<Event> findByName(@Param("name") String name);
    List<Event> findById(@Param ("Id") String Id);
}
