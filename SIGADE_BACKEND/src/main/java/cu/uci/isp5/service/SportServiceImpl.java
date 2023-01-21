package cu.uci.isp5.service;

import cu.uci.isp5.dto.FilterEventDto;
import cu.uci.isp5.dto.FilterSportDto;
import cu.uci.isp5.entity.Event;
import cu.uci.isp5.entity.Sport;
import cu.uci.isp5.repository.SportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImpl implements SportService {
    private final SportRepository sportRepository;

    public SportServiceImpl(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public Sport create(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public Sport Update(Sport sport) {
        Sport result = sportRepository.findById(sport.getSportId()).orElse(null);
        if (sport.getModality() != null) {
            result.setModality(sport.getModality());
        }
        if (sport.getSex() != null) {
            result.setSex(sport.getSex());
        }
        if (sport.getFaculty() != null) {
            result.setFaculty(sport.getFaculty());
        }
        if (sport.getName()!=null){
            result.setName(sport.getName());
        }
        return sportRepository.save(result);
    }

    @Override
    public Optional<Sport> getById(Integer id) {
        return sportRepository.findById(id);
    }

    @Override
    public List<Sport> getAll() {
        return sportRepository.findAll();
    }
    @Override
    public void delete(Integer id){
        sportRepository.deleteById(id);
    }

    @Override
    public FilterSportDto getSport(Sport sport) {
        FilterSportDto model = FilterSportDto.builder()
                .modality(sport.getModality())
                .name(sport.getName())
                .sex(sport.getSex())
                .faculty(sport.getFaculty())
                .build();
        return model;
    }
    @Override
    public List<Sport> getByFilter(FilterSportDto dto) {
        List<Sport> events = sportRepository.findAllByModalityContainingAndNameContainingAndSexContainingAndFacultyContaining(dto.getModality(), dto.getName()
                , dto.getSex(), dto.getFaculty());
       
        return events;
    }
}
