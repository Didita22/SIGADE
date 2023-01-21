package cu.uci.isp5.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String username;
    private String lapel;
    private String sex;
    private String ci;
    private String type;
    private String password;
            
}
