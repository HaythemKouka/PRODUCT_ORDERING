package repo;
 
 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Order;

 
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom queries for Order can go here, for example:
    List<Order> findByUserId(Long userId);
}
  