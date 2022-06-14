package lt.rokas.db.kirneilio.dto;

import lt.rokas.db.kirneilio.enums.EquipmentType;

/**
 * Equipment DTO class
 */
public class EquipmentDto {

    private double price;

    private EquipmentType equipmentType;

    public EquipmentDto() {
    }

    public EquipmentDto(double price, EquipmentType equipmentType) {
        this.price = price;
        this.equipmentType = equipmentType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
}
