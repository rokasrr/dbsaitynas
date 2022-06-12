package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.dto.EquipmentDto;
import lt.rokas.db.kirneilio.entity.Equipment;
import lt.rokas.db.kirneilio.entity.Sauna;
import lt.rokas.db.kirneilio.enums.EquipmentType;
import lt.rokas.db.kirneilio.enums.FoodType;
import lt.rokas.db.kirneilio.enums.SaunaType;
import lt.rokas.db.kirneilio.repository.EquipmentRepository;
import lt.rokas.db.kirneilio.repository.SaunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    SaunaRepository saunaRepository;

    @Override
    public double getPriceByType(EquipmentType type) {
        List<Equipment> equipmentList = equipmentRepository.findAll();
        Optional<Equipment> equipment = equipmentList.stream().filter(eq -> type.equals(eq.getEquipmentType())).findAny();
        if (equipment.isPresent()) {
            return equipment.get().getPrice();
        }
        return 0;
    }

    @Override
    public double getFoodPriceByType(FoodType breakfast) {
        return 100;
    }

    @Override
    public double getSaunaPriceByType(SaunaType type) {
        List<Sauna> saunas = saunaRepository.findAll();
        Optional<Sauna> sauna = saunas.stream().filter(eq -> type.equals(eq.getType())).findAny();
        if (sauna.isPresent()) {
            return sauna.get().getPrice();
        }
        return 0;
    }

    //TODO REMOVE AFTER TESTING
    @Override
    public void generateTestData() {

        Sauna sauna1 = new Sauna();
        sauna1.setType(SaunaType.SAUNA);
        sauna1.setPrice(50);
        Sauna sauna2 = new Sauna();
        sauna1.setType(SaunaType.HOT_TUB);
        sauna1.setPrice(70);

        saunaRepository.save(sauna1);
        saunaRepository.save(sauna2);

        Equipment eq1 = new Equipment(50, EquipmentType.BOAT);
        Equipment eq2 = new Equipment(70, EquipmentType.TENNIS);
        Equipment eq3 = new Equipment(80, EquipmentType.SHEETS);

        equipmentRepository.save(eq1);
        equipmentRepository.save(eq2);
        equipmentRepository.save(eq3);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.getById(id);
    }

    @Override
    public void saveEquipment(EquipmentDto equipment) {
        Equipment eq = new Equipment(equipment.getPrice(), equipment.getEquipmentType());
        equipmentRepository.save(eq);
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        Equipment eq = equipmentRepository.getById(equipment.getId());
        eq.setPrice(equipment.getPrice());
        eq.setEquipmentType(equipment.getEquipmentType());
        equipmentRepository.save(eq);
    }

    @Override
    public void deleteEquipmentById(Long id) {
        equipmentRepository.deleteById(id);
    }
}
