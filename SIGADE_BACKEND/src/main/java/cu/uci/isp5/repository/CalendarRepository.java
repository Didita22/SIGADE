package cu.uci.isp5.repository;

import cu.uci.isp5.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar,Integer> {
    
}
