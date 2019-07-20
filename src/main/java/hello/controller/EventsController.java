package hello.controller;

import hello.model.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RemoteEventController {

    @GetMapping("/fetch")
    public List<Event> fetchEvents() {
        return null;
    }
}
