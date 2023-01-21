package cu.uci.isp5.service;

import cu.uci.isp5.dto.FilterUserDto;
import cu.uci.isp5.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User create(User user);
    User Update(User user);
    Optional<User> getById(Integer id);
    List<User> getAll();
    void delete(Integer id);
    FilterUserDto getUser(User user);
    List<User> getByFilter(FilterUserDto dto);
}
