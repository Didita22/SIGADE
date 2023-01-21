package cu.uci.isp5.controller;

import cu.uci.isp5.entity.Report;
import cu.uci.isp5.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @PostMapping
    public ResponseEntity<Report> create(@RequestBody Report report){
        return ResponseEntity.ok(reportService.create(report));
    }
    @PutMapping("id{id}")
    public ResponseEntity<Report> update(@RequestBody Report report){
        return ResponseEntity.ok(reportService.Update(report));
    }
    @GetMapping("id{id}")
    public ResponseEntity<Optional<Report>>getById(@RequestParam Integer id){
        return ResponseEntity.ok(reportService.getById(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Report>> getAll(){
        return ResponseEntity.ok(reportService.getAll());
    }
    @DeleteMapping("id{id}")
    public void delete(Integer id){
        reportService.delete(id);
    }
}
