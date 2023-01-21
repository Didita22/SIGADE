package cu.uci.isp5.controller;

import cu.uci.isp5.dto.FilterSportDto;
import cu.uci.isp5.dto.FilterUserDto;
import cu.uci.isp5.entity.Sport;
import cu.uci.isp5.entity.User;
import cu.uci.isp5.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @PutMapping("id{id}")
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.Update(user));
    }

    @GetMapping("id{id}")
    public ResponseEntity<Optional<User>> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
    @DeleteMapping("id{id}")
    public void delete(Integer id){
        userService.delete(id);
    }
    @GetMapping("/filter")
    public ResponseEntity<Map<String, List<FilterUserDto>>> getByFilter(@RequestParam(required = false) String name,
                                                                           @RequestParam(required = false) String Lastname,
                                                                           @RequestParam(required = false) String userName,
                                                                           @RequestParam(required = false) String lape,
                                                                           @RequestParam(required = false) String sex,
                                                                           @RequestParam(required = false) String ci,
                                                                           @RequestParam(required = false) String type) {
        Map<String, List<FilterUserDto>> result = new HashMap<>();

        FilterUserDto filterUserDto = FilterUserDto.builder()
               .name(name==null?"":name)
                .lastName(Lastname==null?"":Lastname)
                .username(userName==null?"":userName)
                .lapel(lape==null?"":lape)
                .sex(sex==null?"":sex)
                .ci(ci==null?"":ci)
                .type(type==null?"":type)
                .build();
        List<User> list = userService.getByFilter(filterUserDto);
        System.out.println("---->>>>>" + list);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<FilterUserDto> modelList = new ArrayList<>();
        for (User point : list) {
            modelList.add(userService.getUser(point));
        }
        result.put("user", modelList);

        return ResponseEntity.ok(result);
    }
}
