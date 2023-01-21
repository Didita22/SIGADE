package cu.uci.isp5.controller;

import cu.uci.isp5.dto.CreateSportCalendarDto;
import cu.uci.isp5.entity.Calendar;
import cu.uci.isp5.service.CalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/calendars")
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }
    @PostMapping
    public ResponseEntity<Calendar> create(@RequestBody Calendar calendar){
        return ResponseEntity.ok(calendarService.created(calendar));
    }
    @PutMapping("id{id}")
    public ResponseEntity<Calendar> update(@RequestBody Calendar calendar){
        return ResponseEntity.ok(calendarService.updated(calendar));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Calendar>> getAll(){
        return ResponseEntity.ok(calendarService.getAll());
    }
    @DeleteMapping("id{id}")
    public void delete(Integer id){
        calendarService.delete(id);
    }
}
