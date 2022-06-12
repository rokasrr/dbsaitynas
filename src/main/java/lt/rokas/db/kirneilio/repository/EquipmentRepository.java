package lt.rokas.db.kirneilio.repository;

import lt.rokas.db.kirneilio.entity.Equipment;
import lt.rokas.db.kirneilio.enums.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
