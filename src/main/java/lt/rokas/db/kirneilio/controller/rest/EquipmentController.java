package lt.rokas.db.kirneilio.controller.rest;

import lt.rokas.db.kirneilio.dto.EquipmentDto;
import lt.rokas.db.kirneilio.entity.Equipment;
import lt.rokas.db.kirneilio.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipment/{id}")
    public Optional<Equipment> getEquipmentById(@PathVariable Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @GetMapping("/equipment")
    public List<Equipment> listEquipment() {
        return equipmentService.getAllEquipment();
    }

    @PostMapping("/equipment/new")
    public ResponseEntity<HttpStatus> createEquipment(@RequestBody EquipmentDto equipment) {
        equipmentService.saveEquipment(equipment);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/equipment/edit/{id}")
    public ResponseEntity<HttpStatus> updateEquipment(@PathVariable Long id, @RequestBody Equipment equipment) {
        equipmentService.updateEquipment(equipment);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/equipment/{id}")
    public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipmentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public void setEquipmentService(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }
}
