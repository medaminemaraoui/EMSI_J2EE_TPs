package com.project.billingservice.Controllers;

import com.project.billingservice.Repository.*;
import com.project.billingservice.Services.*;
import com.project.billingservice.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class BillRestController{
    @Autowired BillRepository billRepository;
    @Autowired ProductItemRepository productItemRepository;
    @Autowired CustomerServiceClient customerServiceClient;
    @Autowired InventoryServiceClient inventoryServiceClient;
    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });
        return bill; }
}
