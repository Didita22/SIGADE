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
@Table(name = "Calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendar")
    private Integer idCalendar;
    private String date;
    private String site;
   
}
