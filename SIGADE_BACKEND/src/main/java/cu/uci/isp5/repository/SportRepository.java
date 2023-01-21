package cu.uci.isp5.repository;

import cu.uci.isp5.entity.Event;
import cu.uci.isp5.entity.Sport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport,Integer> {
    List<Sport> findAllByModalityContainingAndNameContainingAndSexContainingAndFacultyContaining(
     String modality, String name,String sex,String faculty);
}
