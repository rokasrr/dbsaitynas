package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.enums.EquipmentType;
import lt.rokas.db.kirneilio.enums.FoodType;
import lt.rokas.db.kirneilio.enums.SaunaType;

public interface EquipmentService {
    double getPriceByType(EquipmentType boat);

    double getFoodPriceByType(FoodType breakfast);

    double getSaunaPriceByType(SaunaType sauna);

    void saveSauna();
}
