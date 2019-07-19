package hello.Repository;

import hello.model.Event;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "event", path = "event")
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
    List<Event> findByName(@Param("name") String name);
}
