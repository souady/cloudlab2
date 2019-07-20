package hello.repository;

import hello.model.Event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByName(@Param("name") String name);
}
