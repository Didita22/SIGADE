package cu.uci.isp5.service;

import cu.uci.isp5.entity.MedalTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedalTableService {
    MedalTable createdMedalTable(MedalTable medalTable);
    MedalTable updatedMedalTable(MedalTable medalTable);
    List<MedalTable> getMedalTable();
}
