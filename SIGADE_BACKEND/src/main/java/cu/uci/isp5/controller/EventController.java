package cu.uci.isp5.controller;


import cu.uci.isp5.dto.FilterEventDto;
import cu.uci.isp5.entity.Event;
import cu.uci.isp5.service.EventService;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event){
        return ResponseEntity.ok(eventService.created(event));
    }
    @PutMapping("id{id}")
    public ResponseEntity<Event> update(@RequestBody Event event){
        return ResponseEntity.ok(eventService.updated(event));
    }
    @GetMapping
    public ResponseEntity<Optional<Event>> getById(Integer id){
        return ResponseEntity.ok(eventService.getById(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(eventService.getAll());
    }
    @DeleteMapping("id{id}")
    public void delete(Integer id){
        eventService.delete(id);
    }
    @GetMapping("/filter")
    public ResponseEntity<Map<String, List<FilterEventDto>>> getByFilter(@RequestParam(required = false) String evenName,
                                                                           @RequestParam(required = false) String date,
                                                                           @RequestParam(required = false) String sport,
                                                                           @RequestParam(required = false) String modality) {
        Map<String, List<FilterEventDto>> result = new HashMap<>();

        FilterEventDto filterChargePoint = FilterEventDto.builder()
               .evenName(evenName==null?"":evenName)
                .date(date==null?"":date)
                .sport(sport==null?"":date)
                .modality(modality==null?"":modality)
                .build();
        List<Event> list = eventService.getByFilter(filterChargePoint);
        System.out.println("---->>>>>" + list);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<FilterEventDto> modelList = new ArrayList<>();
        for (Event point : list) {
            modelList.add(eventService.getEvent(point));
        }
        result.put("event", modelList);

        return ResponseEntity.ok(result);
    }
}
