package ma.enset.inventoryservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
@Data
@Entity @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
