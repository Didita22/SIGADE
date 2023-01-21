package cu.uci.isp5.service;

import cu.uci.isp5.dto.CreateSportCalendarDto;
import cu.uci.isp5.entity.Calendar;
import cu.uci.isp5.entity.Sport;
import cu.uci.isp5.repository.CalendarRepository;
import cu.uci.isp5.repository.SportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarServiceImpl implements CalendarService{
    private final CalendarRepository calendarRepository;
    private final SportRepository sportRepository;

    public CalendarServiceImpl(SportRepository sportRepository,CalendarRepository calendarRepository) {
        this.sportRepository = sportRepository;
        this.calendarRepository = calendarRepository;
    }
    @Override
    public Calendar created(Calendar calendar){
        return calendarRepository.save(calendar);
    }
    @Override
    public Calendar updated(Calendar calendar){
        Calendar cale = calendarRepository.findById(calendar.getIdCalendar()).orElse(null);
        if (calendar.getDate()!=null){
            cale.setDate(calendar.getDate());
        }
        if (calendar.getSite()!=null){
            cale.setSite(calendar.getSite());
        }
        return calendarRepository.save(cale);
    }
    
    @Override
    public List<Calendar> getAll(){

        List<Calendar> calendar = calendarRepository.findAll();
       

        return calendar;
    }
    @Override
    public void delete(Integer id){
        calendarRepository.deleteById(id);
    }
}
