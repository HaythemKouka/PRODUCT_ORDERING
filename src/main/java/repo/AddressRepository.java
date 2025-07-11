package repo; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Custom queries for Address can go here if necessary
}
