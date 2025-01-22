package ma.emsi.billingservice.entities;

import ma.emsi.billingservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long customerID;

    @Transient
    private Customer customer;

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (ProductItem productItem : productItems) {
            totalPrice += productItem.getPrice();
        }
        return totalPrice;
    }

    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;

}
