package lt.rokas.db.kirneilio.repository;

import lt.rokas.db.kirneilio.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
