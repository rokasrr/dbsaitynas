package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.dto.ContractDto;
import lt.rokas.db.kirneilio.entity.Contract;
import lt.rokas.db.kirneilio.entity.Payment;

import java.util.List;

public interface ReservationService {
    void createReservation(ContractDto contractDto);

    Payment generatePaymentRequest(ContractDto contractDto);
}
