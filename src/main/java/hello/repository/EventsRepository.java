package hello.repository;

import hello.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long> {
    List<Event> findByName(@Param("name") String name);
}
