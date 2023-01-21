package cu.uci.isp5.repository;

import cu.uci.isp5.entity.MedalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalTableRepository extends JpaRepository<MedalTable,Integer> {
}
