package ma.emsi.billingservice;

import ma.emsi.billingservice.entities.*;
import ma.emsi.billingservice.models.*;
import ma.emsi.billingservice.repository.*;
import ma.emsi.billingservice.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.lang.Math;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
                            InventoryServiceClient inventoryServiceClient, CustomerServiceClient customerServiceClient)
    {
        return args ->
        {
            for(int cpt=0,i=1 ; i<4 ; i++, cpt=cpt+3)
            {
                Customer customer=customerServiceClient.findCustomerById((long)i);
                if(customer==null) throw new RuntimeException("Customer Not found");
                System.out.println("# CUSTOMER : "+customer);
                Bill bill=new Bill();
                bill.setBillingDate(new Date());
                bill.setCustomerID(customer.getId());
                bill.setCustomer(customerServiceClient.findCustomerById((long)i));
                Bill savedBill = billRepository.save(bill);
                System.out.println("# Saved BILL : "+savedBill);
                List<Product> listProduct = inventoryServiceClient.allProducts().getContent().stream().toList();
                productItemRepository.save(new ProductItem(null,listProduct.get(cpt).getId(),listProduct.get(cpt).getPrice(),(int)(1+Math.random()*1000),savedBill,listProduct.get(cpt)));
                System.out.println(" Product ====> "+listProduct.get(cpt));
                productItemRepository.save(new ProductItem(null,listProduct.get(1+cpt).getId(),listProduct.get(1+cpt).getPrice(),(int)(1+Math.random()*1000),savedBill,listProduct.get(1+cpt)));
                System.out.println(" Product ====> "+listProduct.get(1+cpt));
                productItemRepository.save(new ProductItem(null,listProduct.get(2+cpt).getId(),listProduct.get(2+cpt).getPrice(),(int)(1+Math.random()*1000),savedBill,listProduct.get(2+cpt)));
                System.out.println(" Product ====> "+listProduct.get(2+cpt));
            };
        };
    };
}