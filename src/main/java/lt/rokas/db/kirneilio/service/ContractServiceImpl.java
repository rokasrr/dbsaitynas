package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.dto.ContractDto;
import lt.rokas.db.kirneilio.entity.Contract;
import lt.rokas.db.kirneilio.entity.Payment;
import lt.rokas.db.kirneilio.enums.EquipmentType;
import lt.rokas.db.kirneilio.enums.FoodType;
import lt.rokas.db.kirneilio.enums.SaunaType;
import lt.rokas.db.kirneilio.repository.ContractRepository;
import lt.rokas.db.kirneilio.utils.ContractPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Autowired
    EquipmentService equipmentService;

    @Override
    public void saveContract(Contract contract) {
        contractRepository.saveAndFlush(contract);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public void deleteReservationById(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Contract getContractById(Long id) {
        List<Contract> contracts = getAllContracts();
        Contract contract = contracts.stream().filter(c -> id == c.getId()).findFirst().orElse(null);
        return contract;
    }

    @Override
    public void updateContract(ContractDto contractDto) {
        Contract existingContract = getContractById(contractDto.getId());
        existingContract = ContractPopulator.populateDtoToModel(contractDto, existingContract);
        existingContract.setPayment(generatePaymentRequest(contractDto));
            contractRepository.save(existingContract);
    }

    public Payment generatePaymentRequest(ContractDto contractDto) {
        Payment payment = new Payment();
        payment.setPaid(false);
        payment.setPrice(calculatePrice(contractDto));
        return payment;
    }

    private double calculatePrice(ContractDto contractDto) {
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
}