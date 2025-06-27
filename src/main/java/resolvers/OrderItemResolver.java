package resolvers;

import entities.Order;
import entities.OrderItem;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import repo.OrderItemRepository;
import repo.OrderRepository;
import repo.ProductRepository;

@Controller
public class OrderItemResolver {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @QueryMapping
    public OrderItem orderItem(@Argument Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public OrderItem createOrderItem(@Argument Integer quantity, @Argument Long productId, @Argument Long orderId) {
        Product product = productRepository.findById(productId).orElseThrow();
        Order order = orderRepository.findById(orderId).orElseThrow();

        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(quantity);
        orderItem.setProduct(product);
        orderItem.setOrder(order);

        return orderItemRepository.save(orderItem);
    }
}
