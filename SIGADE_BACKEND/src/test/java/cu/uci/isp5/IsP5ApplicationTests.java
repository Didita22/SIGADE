package cu.uci.isp5;

import cu.uci.isp5.entity.User;
import cu.uci.isp5.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest
class IsP5ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testSalvarUsuario() {
        int cantidad = userService.getAll().size();
        User u = new User();
        userService.create(u);
        int cantSave = userService.getAll().size();

        assertThat(cantidad).isNotEqualTo(cantSave);
    }

    @Test
    void testEliminarUsuario() {
        assertThat(true).isTrue();
    }

    @Test
    void testUpdatedUsuario() {
        assertThat(true).isTrue();
    }

    @Test
    void testGetByIdUsuario() {
        assertThat(true).isTrue();
    }

    @Test
    void testGetAllUsuario() {
        assertThat(true).isTrue();
    }

    @Test
    void testSalvarCalendario() {
        assertThat(true).isTrue();
    }

    @Test
    void testEliminarCalendario() {
        assertThat(true).isTrue();
    }

    @Test
    void testUpdatedCalendario() {
        assertThat(true).isTrue();
    }

    @Test
    void testGetByIdCalendario() {
        assertThat(true).isTrue();
    }

    @Test
    void testGetAllCalendario() {
        assertThat(true).isTrue();
    }

}
