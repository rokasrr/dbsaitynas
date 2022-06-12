package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.dto.ContractDto;
import lt.rokas.db.kirneilio.entity.*;
import lt.rokas.db.kirneilio.enums.EquipmentType;
import lt.rokas.db.kirneilio.enums.FoodType;
import lt.rokas.db.kirneilio.enums.SaunaType;
import lt.rokas.db.kirneilio.utils.ContractPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserService userService;

    @Autowired
    ContractService contractService;

    @Autowired
    EquipmentService equipmentService;

    public void createReservation(ContractDto contractDto) {
        Contract contract = new Contract();

        ContractPopulator.populateDtoToModel(contractDto, contract);
        contract.setPayment(generatePaymentRequest(contractDto));

        contractService.saveContract(contract);
    }

    public Payment generatePaymentRequest(ContractDto contractDto) {
        Payment payment = new Payment();
        payment.setPaid(false);
        payment.setPrice(calculatePrice(contractDto));
        return payment;
    }

    private double calculatePrice(ContractDto contractDto) {
//        equipmentService.saveSauna();
        double price = 0;
        if (contractDto.isBoat()) {
            price += equipmentService.getPriceByType(EquipmentType.BOAT);
        }
        if (contractDto.isFood()) {
            price += equipmentService.getFoodPriceByType(FoodType.BREAKFAST);
        }
        if (contractDto.isSheets()) {
            price += equipmentService.getPriceByType(EquipmentType.SHEETS);
        }
        if (contractDto.isTennis()) {
            price += equipmentService.getPriceByType(EquipmentType.TENNIS);
        }
        if (contractDto.isSauna()) {
            price += equipmentService.getSaunaPriceByType(SaunaType.SAUNA);
        }
        if (contractDto.isHotTub()) {
            price += equipmentService.getSaunaPriceByType(SaunaType.HOT_TUB);
        }
        price += 100 * calculateDays(contractDto);
        return price;
    }

    private static int calculateDays(ContractDto contractDto) {
        Date inputString2 = contractDto.getDate();
        Date inputString1 = contractDto.getExitDate();

        long diff = inputString1.getTime() - inputString2.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    public void setEquipmentService(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }
}
