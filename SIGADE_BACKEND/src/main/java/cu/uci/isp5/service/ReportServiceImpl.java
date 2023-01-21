package cu.uci.isp5.service;

import cu.uci.isp5.entity.Report;
import cu.uci.isp5.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report create(Report report) {
        return reportRepository.save(report);
    }
    @Override
    public Report Update(Report report){
        Report result = reportRepository.findById(report.getIdReport()).orElse(null);
        if (report.getEvent()!=null){
            result.setEvent(report.getEvent());
        }
        if (report.getInfo()!=null){
            result.setInfo(report.getInfo());
        }
        if (report.getResult()!=null){
            result.setResult(report.getResult());
        }
        return reportRepository.save(result);
    }
    @Override
    public Optional<Report> getById(Integer id){
        return reportRepository.findById(id);
    }
    @Override
    public List<Report> getAll(){
        return reportRepository.findAll();
    }
    @Override
    public void delete(Integer id){
        reportRepository.deleteById(id);
    }
}
