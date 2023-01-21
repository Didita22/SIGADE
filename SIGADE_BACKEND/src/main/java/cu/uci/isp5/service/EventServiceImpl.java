package cu.uci.isp5.service;

import cu.uci.isp5.dto.FilterEventDto;
import cu.uci.isp5.entity.Calendar;
import cu.uci.isp5.entity.Event;
import cu.uci.isp5.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public Event created(Event event){
        return eventRepository.save(event);
    }
    @Override
    public Event updated(Event event){
        Event result = eventRepository.findById(event.getEventId()).orElse(null);
        if (event.getEvenName()!=null){
            result.setEvenName(event.getEvenName());
        }
        if (event.getModality()!=null){
            result.setModality(event.getModality());
        }
        return eventRepository.save(result);
    }
    @Override
    public Optional<Event> getById(Integer id){
        return eventRepository.findById(id);
    }
    @Override
    public List<Event> getAll(){
        return eventRepository.findAll();
    }
    @Override
    public void delete(Integer id){
        eventRepository.deleteById(id);
    }
    @Override
    public FilterEventDto getEvent(Event event) {
        FilterEventDto model = FilterEventDto.builder()
                .evenName(event.getEvenName())
                .date(event.getDate())
                .sport(event.getSport())
                .modality(event.getModality())
                .build();
        return model;
    }
    @Override
    public List<Event> getByFilter(FilterEventDto dto) {
        List<Event> events = eventRepository.findAllByEvenNameContainingAndDateContainingAndSportContainingAndModalityContaining(dto.getEvenName()
                , dto.getDate(), dto.getSport(), dto.getModality());
       
        return events;
    }
}
