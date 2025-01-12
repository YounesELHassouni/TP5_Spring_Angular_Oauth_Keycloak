package ma.enset.orderservice;

import ma.enset.orderservice.entities.Order;
import ma.enset.orderservice.entities.OrderState;
import ma.enset.orderservice.entities.ProductItem;
import ma.enset.orderservice.model.Product;
import ma.enset.orderservice.repository.OrderRepository;
import ma.enset.orderservice.repository.ProductItemRepository;
import ma.enset.orderservice.restClients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner  commandLineRunner(OrderRepository orderRepository,
                                         ProductItemRepository productItemRepository,
                                         InventoryRestClient inventoryRestClient) {
        {
            return args -> {
                //List<Product> allProducts = inventoryRestClient.getAllProducts();
                List<String> productsIds = List.of("P01","P02","P03");
                for (int i = 0; i < 5; i++) {
                    Order order = Order.builder()
                            .id(UUID.randomUUID().toString())
                            .date(LocalDate.now())
                            .state(OrderState.PENDING)
                            .build();
                    Order savedOrder = orderRepository.save(order);
                    productsIds.forEach(p->{
                        ProductItem productItem = ProductItem.builder()
                                .productId(p)
                                .price(Math.random()*6000+500)
                                .quantity(new Random().nextInt(20))
                                .order(savedOrder)
                                .build();
                        productItemRepository.save(productItem);
                    });
                }


            };
        }
    }
}
