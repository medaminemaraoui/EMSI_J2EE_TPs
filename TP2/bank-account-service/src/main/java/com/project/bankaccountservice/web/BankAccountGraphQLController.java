package com.project.bankaccountservice.web;

import com.project.bankaccountservice.dto.BankAccountRequestDTO;
import com.project.bankaccountservice.dto.BankAccountResponseDTO;
import com.project.bankaccountservice.entities.BankAccount;
import com.project.bankaccountservice.repositories.BankAccountRepository;
import com.project.bankaccountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired private BankAccountRepository bankAccountRepository;
    @Autowired private AccountService accountService;

    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

//    query{
//        accountList {
//            id,
//            currency,
//            balance,
//            type
//        }
//    }

    @QueryMapping
    public BankAccount BankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account Not Found")));
    }

//    query{
//        BankAccountById (id : "xxxxx-xxxx-xxx-xx--x") {
//            id,
//            currency,
//            balance,
//            type
//        }
//    }


    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

//    mutation {
//        addAccount(bankAccount : { type:"SAVING_ACCOUNT", balance:4000, currency:"USD" } )
//        { id,type,currency,balance }
//    }

//    OU BIEN

//    mutation($t:String, $b:Float, $c:String) {
//        addAccount(bankAccount : { type:$t, balance:$b, currency:$c } )
//        { id,type,currency,balance }
//    }
//
//    Variables
//    {"t": "CURRENT_ACCOUNT", "b": 3000, "c": "MAD"}

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }

//    mutation($t:String, $b:Float, $c:String) {
//        updateAccount(
//                id : "xxxx-xxxxx-xxxxx-xxxx",
//                bankAccount : { type:$t, balance:$b, currency:$c }  )
//        {  id, currency, balance,  type }
//    }
//    Variables
//    {"t": "CURRENT_ACCOUNT", "b": 6666, "c": "EUR"}

    @MutationMapping
    public boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

//    mutation {
//        deleteAccount(id:"xxxxx-xxxxx-xxxxxxx-xxxxx")
//    }
}
