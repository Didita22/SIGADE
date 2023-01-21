package cu.uci.isp5.service;

import cu.uci.isp5.entity.Report;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReportService {
    Report create(Report report);
    Report Update(Report report);
    Optional<Report> getById(Integer id);
    List<Report> getAll();
    void delete(Integer id);
}
