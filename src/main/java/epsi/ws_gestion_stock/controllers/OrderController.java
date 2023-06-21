package epsi.ws_gestion_stock.controllers;


import epsi.ws_gestion_stock.Dto.OrderDTO;
import epsi.ws_gestion_stock.controllers.Exceptions.OrderNotFoundException;
import epsi.ws_gestion_stock.models.Order;
import epsi.ws_gestion_stock.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "orders",produces = APPLICATION_JSON_VALUE)
public class OrderController {

    //Attributes
    private final OrderRepository orderRepository;


    //Constructors
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    //Methods
    @GetMapping("")
    public List<OrderDTO> all(){
        return Order.mapToDTO(orderRepository.findAll());
    }

    @PostMapping("")
    public OrderDTO newOrder(@RequestBody Order order) {
        return Order.mapToDTO(orderRepository.save(order));
    }

    @GetMapping("/{id}")
    public OrderDTO one(@PathVariable Long id){
        return Order.mapToDTO(orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id)));
    }

    @PutMapping("/{id}")
    public OrderDTO replaceOrder(@RequestBody Order newOrder, @PathVariable Long id){
        return Order.mapToDTO(orderRepository.findById(id).map(order -> {
            order.setLabel(newOrder.getLabel());
            order.setArticles(newOrder.getArticles());
            return orderRepository.save(order);
        }).orElseGet(() -> {
            newOrder.setId(id);
            return orderRepository.save(newOrder);
        }));
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id);
    }
}
