package cu.uci.isp5.controller;

import cu.uci.isp5.dto.FilterEventDto;
import cu.uci.isp5.dto.FilterSportDto;
import cu.uci.isp5.entity.Event;
import cu.uci.isp5.entity.Sport;
import cu.uci.isp5.service.SportService;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/sports")
public class SportController {
    private final SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }
    @PostMapping
    public ResponseEntity<Sport> create(@RequestBody Sport sport){
        return ResponseEntity.ok(sportService.create(sport));
    }
    @PutMapping("id{id}")
    public ResponseEntity<Sport> update(@RequestBody Sport sport){
        return ResponseEntity.ok(sportService.Update(sport));
    }
    @GetMapping("id{id}")
    public ResponseEntity<Optional<Sport>>getById(@RequestParam Integer id){
        return ResponseEntity.ok(sportService.getById(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Sport>> getAll(){
        return ResponseEntity.ok(sportService.getAll());
    }
    @DeleteMapping("id{id}")
    public void delete(Integer id){
        sportService.delete(id);
    }
    @GetMapping("/filter")
    public ResponseEntity<Map<String, List<FilterSportDto>>> getByFilter(@RequestParam(required = false) String modality,
                                                                           @RequestParam(required = false) String name,
                                                                           @RequestParam(required = false) String sex,
                                                                           @RequestParam(required = false) String faculty) {
        Map<String, List<FilterSportDto>> result = new HashMap<>();

        FilterSportDto filterSportDto = FilterSportDto.builder()
               .name(name==null?"":name)
                .sex(sex==null?"":sex)
                .faculty(faculty==null?"":faculty)
                .modality(modality==null?"":modality)
                .build();
        List<Sport> list = sportService.getByFilter(filterSportDto);
        System.out.println("---->>>>>" + list);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<FilterSportDto> modelList = new ArrayList<>();
        for (Sport point : list) {
            modelList.add(sportService.getSport(point));
        }
        result.put("sport", modelList);

        return ResponseEntity.ok(result);
    }
}
