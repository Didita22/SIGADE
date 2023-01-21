package cu.uci.isp5.service;

import cu.uci.isp5.dto.FilterSportDto;
import cu.uci.isp5.entity.Sport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SportService {
    Sport create(Sport sport);
    Sport Update(Sport sport);
    Optional<Sport> getById(Integer id);
    List<Sport> getAll();
    void delete(Integer id);
    FilterSportDto getSport(Sport sport);
    List<Sport> getByFilter(FilterSportDto dto);
}
