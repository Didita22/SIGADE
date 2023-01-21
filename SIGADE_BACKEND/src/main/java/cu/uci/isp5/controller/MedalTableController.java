package cu.uci.isp5.controller;

import cu.uci.isp5.entity.MedalTable;
import cu.uci.isp5.service.MedalTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/medals")
public class MedalTableController {
    private final MedalTableService medalTableService;

    public MedalTableController(MedalTableService medalTableService) {

        this.medalTableService = medalTableService;
    }

    @PostMapping
    public ResponseEntity<MedalTable> createdMedalTable(@RequestBody MedalTable medalTable){
        return ResponseEntity.ok(medalTableService.createdMedalTable(medalTable));
    }
    @PutMapping("/id{id}")
    public ResponseEntity<MedalTable> updatedMedalTable(@RequestBody MedalTable medalTable){
        return ResponseEntity.ok(medalTableService.updatedMedalTable(medalTable));
    }
    @GetMapping("/all")
    public ResponseEntity<List<MedalTable>> getMedalTableList(){
        return ResponseEntity.ok(medalTableService.getMedalTable());
    }
}
