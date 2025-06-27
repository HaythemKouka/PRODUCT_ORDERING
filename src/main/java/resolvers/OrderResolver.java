package resolvers;

import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import repo.OrderItemRepository;
import repo.OrderRepository;
import repo.ProductRepository;
import repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderResolver {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @QueryMapping
    public List<Order> orders() {
        return orderRepository.findAll();
    }

    @QueryMapping
    public Order order(@Argument Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Order createOrder(@Argument Long userId, @Argument List<Long> productIds) {
        User user = userRepository.findById(userId).orElseThrow();

        Order order = new Order();
        order.setUser(user);
        order = orderRepository.save(order); // Save first to get an ID

        List<OrderItem> orderItems = new ArrayList<>();

        for (Long productId : productIds) {
            Product product = productRepository.findById(productId).orElseThrow();
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(1); // valeur par défaut
            orderItems.add(item);
        }

        orderItemRepository.saveAll(orderItems);
        order.setOrderItems(orderItems);

        return order;
    }
}
