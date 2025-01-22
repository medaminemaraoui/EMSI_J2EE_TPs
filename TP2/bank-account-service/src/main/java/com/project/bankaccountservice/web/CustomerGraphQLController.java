package com.project.bankaccountservice.web;

import com.project.bankaccountservice.entities.BankAccount;
import com.project.bankaccountservice.entities.Customer;
import com.project.bankaccountservice.repositories.BankAccountRepository;
import com.project.bankaccountservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerGraphQLController {
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<Customer> CustomerList() {
        return customerRepository.findAll();
    }

//    query{
//        CustomerList {
//            id,
//            name,
//            BankAccounts { id, balance, type }
//        }
//    }

    @QueryMapping
    public Customer CustomerById(@Argument Long id) {
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Customer Not Found")));
    }

//    query{
//        CustomerById (id : "xxxxx-xxx-xxx-xxx-xx") {
//            id,
//            name,
//            BankAccounts { id, currency, balance, type }
//        }
//    }
}
