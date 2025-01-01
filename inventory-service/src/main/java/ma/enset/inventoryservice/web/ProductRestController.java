package ma.enset.inventoryservice.web;

import lombok.AllArgsConstructor;
import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductRestController {
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> productList() {
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }



}
