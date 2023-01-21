package cu.uci.isp5.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medalTable")
@Entity
public class MedalTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String place;
    private String team;
    private Integer gold;
    private String plate;
    private String bronze;
    private String total;
}
