package cu.uci.isp5.service;

import cu.uci.isp5.dto.FilterEventDto;
import cu.uci.isp5.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {
    Event created(Event event);
    Event updated(Event event);
    Optional<Event> getById(Integer id);
    List<Event> getAll();
    void delete(Integer id);
    FilterEventDto getEvent(Event event);
    List<Event> getByFilter(FilterEventDto dto);
}
