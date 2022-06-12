package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.dto.ContractDto;
import lt.rokas.db.kirneilio.entity.Contract;

import java.util.List;

public interface ContractService {
    void saveContract(Contract contract);

    List<Contract> getAllContracts();

    void deleteReservationById(Long id);

    Contract getContractById(Long id);

    void updateContract(ContractDto contractDto);
}
