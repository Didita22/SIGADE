package cu.uci.isp5.service;

import cu.uci.isp5.entity.MedalTable;
import cu.uci.isp5.entity.Report;
import cu.uci.isp5.repository.MedalTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedalTableServiceImpl implements MedalTableService {
    private final MedalTableRepository tableRepository;

    public MedalTableServiceImpl(MedalTableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public MedalTable createdMedalTable(MedalTable medalTable) {
        return tableRepository.save(medalTable);
    }

    @Override
    public MedalTable updatedMedalTable(MedalTable medalTable) {
        MedalTable table = tableRepository.findById(medalTable.getId()).orElse(null);
        if (medalTable.getPlace() != null) {
            table.setPlate(medalTable.getPlate());
        }
        if (medalTable.getTeam() != null) {
            table.setTeam(medalTable.getTeam());
        }
        if (medalTable.getGold() != null) {
            table.setGold(medalTable.getGold());
        }
        if (medalTable.getBronze() != null) {
            table.setBronze(medalTable.getBronze());
        }
        if (medalTable.getPlate() != null) {
            table.setPlate(medalTable.getPlate());
        }
        if (medalTable.getTotal() != null) {
            table.setTotal(medalTable.getTotal());
        }
        return tableRepository.save(table);
    }
    @Override
    public List<MedalTable> getMedalTable(){
        return tableRepository.findAll();
    }
}