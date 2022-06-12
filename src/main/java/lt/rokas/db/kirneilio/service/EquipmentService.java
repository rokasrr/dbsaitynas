package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.controller.rest.EquipmentDto;
import lt.rokas.db.kirneilio.entity.Equipment;
import lt.rokas.db.kirneilio.enums.EquipmentType;
import lt.rokas.db.kirneilio.enums.FoodType;
import lt.rokas.db.kirneilio.enums.SaunaType;

import java.util.List;

public interface EquipmentService {
    double getPriceByType(EquipmentType boat);

    double getFoodPriceByType(FoodType breakfast);

    double getSaunaPriceByType(SaunaType sauna);

    void generateTestData();

    List<Equipment> getAllEquipment();

    Equipment getEquipmentById(Long id);

    void saveEquipment(EquipmentDto equipment);

    void updateEquipment(Equipment equipment);

    void deleteEquipmentById(Long id);
}
