package be.pxl.hotel.repository;

import be.pxl.hotel.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Wallet, Long>{

}
