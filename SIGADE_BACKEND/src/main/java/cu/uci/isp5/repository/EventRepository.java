package cu.uci.isp5.repository;

import cu.uci.isp5.entity.Event;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
     List<Event> findAllByEvenNameContainingAndDateContainingAndSportContainingAndModalityContaining(
     String eventName, String date,String sport,String modality);
}
