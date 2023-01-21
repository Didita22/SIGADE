package cu.uci.isp5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSportCalendarDto {
    private Integer idCalendar;
    private String date;
    private String site;
    private Integer sportId;
    private String modality;
}
