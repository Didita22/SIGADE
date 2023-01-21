package cu.uci.isp5.repository;

import cu.uci.isp5.entity.Sport;
import cu.uci.isp5.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
     List<User> findAllByNameContainingAndLastNameContainingAndUsernameContainingAndLapelContainingAndSexContainingAndCiContainingAndTypeContaining(
     String name, String lastName,String userName,String lapel,String sex,String ci,String type);
}
