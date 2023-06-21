package epsi.ws_gestion_stock.repository;

import epsi.ws_gestion_stock.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
