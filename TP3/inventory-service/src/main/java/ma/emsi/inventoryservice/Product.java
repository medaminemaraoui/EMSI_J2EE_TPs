package ma.emsi.inventoryservice;

import lombok.*;
import jakarta.persistence.*;

@Entity @Data @NoArgsConstructor
@AllArgsConstructor @ToString
class Product{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

}
