package cu.uci.isp5.service;

import cu.uci.isp5.dto.CreateSportCalendarDto;
import cu.uci.isp5.entity.Calendar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CalendarService {
    Calendar created(Calendar calendar);
    Calendar updated(Calendar calendar);
   public List<Calendar> getAll();
    void delete(Integer id);
}
