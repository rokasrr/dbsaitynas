package lt.rokas.db.kirneilio.controller;

import lt.rokas.db.kirneilio.dto.ContractDto;
import lt.rokas.db.kirneilio.entity.User;
import lt.rokas.db.kirneilio.service.ContractService;
import lt.rokas.db.kirneilio.service.ReservationService;
import lt.rokas.db.kirneilio.utils.ContractPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @Autowired
    ContractService contractService;

    @GetMapping("/reservations/new")
    public String reserve(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "reservation";
    }

    @PostMapping("/reservations/save")
    public String saveReservation(Model model, @ModelAttribute ContractDto contractDto) {
        reservationService.createReservation(contractDto);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", contractService.getAllContracts());
        return "reservations_list";
    }

    @GetMapping("/reservations/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        contractService.deleteReservationById(id);
        return "redirect:/";
    }

    @GetMapping("/reservations/edit/{id}")
    public String editContractForm(@PathVariable Long id, Model model) {
        model.addAttribute("contractDto", ContractPopulator.populateModelToDto(contractService.getContractById(id)));
        return "reservation_edit";
    }

    @PostMapping("/reservations/update/{id}")
    public String updateContract(@PathVariable Long id, Model model, @ModelAttribute ContractDto contractDto) {
        contractDto.setId(id);
        contractService.updateContract(contractDto);
        return "redirect:/";
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
}
