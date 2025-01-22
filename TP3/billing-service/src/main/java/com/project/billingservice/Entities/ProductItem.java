package com.project.billingservice.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class ProductItem{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long productID;
    private double price;
    private double quantity;

    @ManyToOne
    private Bill bill;

    @Transient
    private Product product;

    public ProductItem(Long id, Long o, double price, int quantity, Bill bill, Product p) {
    }
}
