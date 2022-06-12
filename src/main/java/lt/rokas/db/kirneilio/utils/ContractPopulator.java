package lt.rokas.db.kirneilio.utils;

import lt.rokas.db.kirneilio.dto.ContractDto;
import lt.rokas.db.kirneilio.entity.*;
import lt.rokas.db.kirneilio.enums.EquipmentType;
import lt.rokas.db.kirneilio.enums.FoodType;
import lt.rokas.db.kirneilio.enums.SaunaType;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ContractPopulator {

    public static ContractDto populateModelToDto(Contract contract) {
        ContractDto dto = new ContractDto();
        dto.setId(contract.getId());
        dto.setFirstName(contract.getUser().getFirstName());
        dto.setEmail(contract.getUser().getEmail());
        dto.setPhone(contract.getUser().getPhoneNumber());
        dto.setDate(contract.getReservation().getDate());
        dto.setExitDate(contract.getReservation().getExitDate());
        dto.setBoat(checkEquipmentOrder(contract.getEquipmentList(), EquipmentType.BOAT));
        dto.setSheets(checkEquipmentOrder(contract.getEquipmentList(), EquipmentType.SHEETS));
        dto.setFood(!contract.getFood().isEmpty());
        dto.setSauna(checkSaunaOrder(contract.getSaunaList(), SaunaType.SAUNA));
        dto.setHotTub(checkSaunaOrder(contract.getSaunaList(), SaunaType.HOT_TUB));
        if (!contract.getReviews().isEmpty()) {
            dto.setComments(contract.getReviews().get(0).getReview());
        }
        dto.setExtraOrder(contract.getExtraOrder().getData());

        return dto;
    }

    private static boolean checkSaunaOrder(List<Sauna> saunaList, SaunaType type) {
        Optional<Sauna> sauna = saunaList.stream().filter(eq -> type.equals(eq.getType())).findAny();
        if (sauna.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkEquipmentOrder(List<Equipment> equipmentList, EquipmentType type) {
        Optional<Equipment> equipment = equipmentList.stream().filter(eq -> type.equals(eq.getEquipmentType())).findAny();
        if (equipment.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public static Contract populateDtoToModel(ContractDto contractDto, Contract contract) {
        User user = createUser(contractDto.getFirstName(), contractDto.getEmail(), contractDto.getPhone());
        contract.setUser(user);

        contract.setReservation(generateReservation(contractDto));

        contract.setSaunaList(generateSaunaList(contractDto));

        contract.setEquipmentList(generateEqpuipmentList(contractDto));

        contract.setExtraOrder(createExtraOrder(contractDto));

        contract.setReviews(createReviews(contractDto));

        return contract;
    }

    private static List<Equipment> generateEqpuipmentList(ContractDto contractDto) {
        List<Equipment> equipment = new ArrayList<Equipment>();
        if (contractDto.isBoat()) {
            equipment.add(new Equipment(10, EquipmentType.BOAT));
        }
        if (contractDto.isSheets()) {
            equipment.add(new Equipment(50, EquipmentType.SHEETS));
        }
        if (contractDto.isTennis()) {
            equipment.add(new Equipment(10, EquipmentType.TENNIS));
        }
        return equipment;
    }

    private static List<Sauna> generateSaunaList(ContractDto contractDto) {
        List<Sauna> saunaList = new ArrayList<Sauna>();
        if (contractDto.isSauna()) {
            saunaList.add(new Sauna(50, SaunaType.SAUNA));
        }
        if (contractDto.isHotTub()) {
            saunaList.add(new Sauna(70, SaunaType.HOT_TUB));
        }
        return saunaList;
    }

    private static List<Review> createReviews(ContractDto contractDto) {
        Review review = new Review();
        review.setReview(contractDto.getComments());
        List<Review> reviews = new ArrayList<Review>();
        reviews.add(review);
        return reviews;
    }

    private static ExtraOrder createExtraOrder(ContractDto contractDto) {
        ExtraOrder order = new ExtraOrder();
        order.setPrice(50);
        order.setData(contractDto.getExtraOrder());
        return order;
    }

    private static Reservation generateReservation(ContractDto contractDto) {
        Reservation reservation = new Reservation();
        reservation.setDate(contractDto.getDate());
        reservation.setExitDate(contractDto.getExitDate());
        return reservation;
    }

    public static User createUser(String firstName, String email, String phone) {
        return new User(firstName, email, phone);
    }
}
