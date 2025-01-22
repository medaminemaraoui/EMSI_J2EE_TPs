package com.project.bankaccountservice.services;

import com.project.bankaccountservice.dto.*;

public interface AccountService{
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO);
}
