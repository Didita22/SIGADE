package cu.uci.isp5.service;


import cu.uci.isp5.dto.FilterSportDto;
import cu.uci.isp5.dto.FilterUserDto;
import cu.uci.isp5.entity.Sport;
import cu.uci.isp5.entity.User;
import cu.uci.isp5.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User Update(User user) {
        User result = userRepository.findById(user.getUserId()).orElse(null);

        if (user.getName()!=null){
            result.setName(user.getName());
        }
        if (user.getUsername()!=null){
            result.setUsername(user.getUsername());
        }
        if (user.getLastName()!=null){
            result.setLastName(user.getLastName());
        }
        if (user.getLapel()!=null){
            result.setLapel(user.getLapel());
        }
        if (user.getSex()!=null){
           result.setSex(user.getSex());
        }
        if (user.getCi()!=null){
            result.setCi(user.getCi());
        }
        if (user.getType()!=null){
            result.setType(user.getType());
        }
         if (user.getPassword()!=null){
            result.setPassword(user.getPassword());
        }
        return userRepository.save(result);
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Override
    public void delete(Integer id){
        userRepository.deleteById(id);
    }
     @Override
    public FilterUserDto getUser(User user) {
        FilterUserDto model = FilterUserDto.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .lapel(user.getLapel())
                .sex(user.getSex())
                .ci(user.getCi())
                .type(user.getType())
                .build();
        return model;
    }
    @Override
    public List<User> getByFilter(FilterUserDto dto) {
        List<User> users = userRepository.findAllByNameContainingAndLastNameContainingAndUsernameContainingAndLapelContainingAndSexContainingAndCiContainingAndTypeContaining(
        dto.getName(),dto.getLastName(),dto.getUsername(),dto.getLapel(),dto.getSex(),dto.getCi(),dto.getType());
       
        return users;
    }
}
