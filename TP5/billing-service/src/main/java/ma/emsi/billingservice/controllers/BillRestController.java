package ma.emsi.billingservice.controllers;

import ma.emsi.billingservice.entities.Bill;
import ma.emsi.billingservice.models.Customer;
import ma.emsi.billingservice.repository.BillRepository;
import ma.emsi.billingservice.repository.ProductItemRepository;
import ma.emsi.billingservice.services.CustomerServiceClient;
import ma.emsi.billingservice.services.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class BillRestController{
    @Autowired
    BillRepository billRepository;
    @Autowired
    ProductItemRepository productItemRepository;
    @Autowired
    CustomerServiceClient customerServiceClient;
    @Autowired
    InventoryServiceClient inventoryServiceClient;
    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable("id") Long id){
        return FullBill(id);
    }

    Bill FullBill(Long id)
    {
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });
        return bill;

    }

    @GetMapping("/bills/All")
    List<Bill> getBills(){
        return AllFullBill();
    }

    List<Bill> AllFullBill()
    {
        List<Bill> bill=billRepository.findAll();
        for(Bill b:bill)
        {
            Customer customer = customerServiceClient.findCustomerById(b.getCustomerID());
            b.setCustomer(customer);
        }

        return bill;

    }

}
